package com.sunl19ht.event;

import com.sunl19ht.GoTo;
import com.sunl19ht.data.GlobalPlayerData;
import com.sunl19ht.data.GlobalPointData;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class MyEventListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        HashMap<Player, HashMap<String, Boolean>> playerData = GlobalPlayerData.getInstance().getPlayerData();
        HashMap<String, Boolean> hashMap = new HashMap<>();

        HashMap<String, Object> readData = readYamlFile("F:\\Minecraft\\1.20.1Server\\plugins\\GoTo\\config.yml");

        if (readData.get(event.getPlayer().getName()) != null) {
            String openTp = readData.get(event.getPlayer().getName()).toString();
            if(openTp.contains("true")) {
                hashMap.put("open_tp", true);
            } else {
                hashMap.put("open_tp", false);
            }
            GlobalPlayerData.getInstance().getPlayerData().put(event.getPlayer(), hashMap);
        } else {
            //玩家进入游戏 初始化玩家对应的数据
            hashMap.put("open_tp", true); //默认开启
            playerData.put(event.getPlayer(), hashMap);
        }
    }

    private static HashMap<String, Object> readYamlFile(String fileName) {
        Path filePath = Paths.get(fileName);

        try {
            byte[] fileContent = Files.readAllBytes(filePath);

            // 将YAML文件内容解析为Map
            Yaml yaml = new Yaml();
            HashMap<String, Object> data = yaml.load(new String(fileContent));

            // 打印Map内容
            System.out.println("Read YAML file content:");
            System.out.println(data);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
