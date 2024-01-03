package com.sunl19ht.command;

import com.sunl19ht.enums.ColorEnums;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyCommand implements CommandExecutor {
    private PlayerTpImp playerTpImp = new PlayerTpImp();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player && command.getName().equalsIgnoreCase("goto") && strings != null && strings.length > 0) {
            Player player = (Player) commandSender;

            if(strings.length == 1 && !strings[0].equals("open") && !strings[0].equals("close")) {
                String targetPlayerName = strings[0];
                playerTpImp.goToPlayer(player, targetPlayerName);
            } else if(strings[0].equals("open")) {
                playerTpImp.setPlayerData(player, true);
                player.sendMessage(ColorEnums.GREEN.getCode() + "[GoTo] 已将传送" + ColorEnums.GREEN.getCode() + " 开启" + "！");
            } else if(strings[0].equals("close")) {
                playerTpImp.setPlayerData(player, false);
                player.sendMessage(ColorEnums.GREEN.getCode() + "[GoTo] 已将传送" + ColorEnums.RED.getCode() + " 关闭" + "！");
            }

        }
        return false;
    }
}
