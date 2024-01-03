package com.sunl19ht;

import com.google.gson.Gson;
import com.sunl19ht.command.MyCommand;
import com.sunl19ht.data.GlobalPlayerData;
import com.sunl19ht.event.MyEventListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class GoTo extends JavaPlugin {
    private static GoTo main;
    private File configFile;
    private FileConfiguration config;
    @Override
    public void onLoad() {
        saveDefaultConfig();
        super.onLoad();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("goto").setExecutor(new MyCommand());
        Bukkit.getPluginManager().registerEvents(new MyEventListener(), this);
        main = this;

        // 初始化配置文件
        configFile = new File(getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    @Override
    public void onDisable() {
        HashMap<Player, HashMap<String, Boolean>> playerData = GlobalPlayerData.getInstance().getPlayerData();
        Set<Player> players = playerData.keySet(); // 所有玩家

        HashMap<String, Object> data = new HashMap<>();

        for (Player p : players) {
            data.put(p.getName(), playerData.get(p));
        }

        // 设置YAML文件输出格式
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        // 创建YAML对象
        Yaml yaml = new Yaml(options);

        // 将数据写入YAML文件
        try (FileWriter writer = new FileWriter("F:\\Minecraft\\1.20.1Server\\plugins\\GoTo\\config.yml")) {
            yaml.dump(data, writer);
            writer.flush();
            System.out.println("Write YAML file successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
