package com.sunl19ht.command;

import com.sunl19ht.GoTo;
import com.sunl19ht.data.GlobalPlayerData;
import com.sunl19ht.enums.ColorEnums;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerTpImp {
    private HashMap<Player, HashMap<String, Boolean>> playerData = GlobalPlayerData.getInstance().getPlayerData();

    /**
     * goto <目标玩家>
     * @param player    玩家
     * @param targetPlayerName  目标玩家
     */
    public void goToPlayer(Player player, String targetPlayerName) {

        HashMap<String, Boolean> hashMap = playerData.get(Bukkit.getServer().getPlayerExact(targetPlayerName));
        Boolean openTp = hashMap.get("open_tp");

        if(player.getName().equals(targetPlayerName)) {
            player.sendMessage(ColorEnums.RED.getCode() + "[GoTo] 不能自己传送自己！");
        } else {
            if(!openTp) {
                player.sendMessage(ColorEnums.RED.getCode() + "[GoTo] 玩家 " + targetPlayerName + "未开启传送");
            } else {
                Player targetPlayer = Bukkit.getServer().getPlayerExact(targetPlayerName);
                if(targetPlayer != null && targetPlayer.isOnline()) {
                    player.teleport(targetPlayer.getLocation());
                    player.sendMessage(ColorEnums.GREEN.getCode() + "[GoTo] 已将 " + player.getName() + " 传送到 " + targetPlayerName);
                } else {
                    player.sendMessage(ColorEnums.RED.getCode() + "[GoTo] 玩家 " + targetPlayerName + " 离线或不存在");
                }
            }
        }
    }

    public void setPlayerData(Player player, boolean b) {
        HashMap<String, Boolean> hashMap = playerData.get(player);
        hashMap.put("open_tp", b);
    }
}
