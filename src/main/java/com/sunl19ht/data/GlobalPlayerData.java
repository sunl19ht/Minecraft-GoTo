package com.sunl19ht.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class GlobalPlayerData {
    private static GlobalPlayerData instance;
    private HashMap<Player, HashMap<String, Boolean>> playerData;

    private GlobalPlayerData() {
        playerData = new HashMap<>();
    }

    public static GlobalPlayerData getInstance() {
        if (instance == null) {
            synchronized (GlobalPointData.class) {
                if (instance == null) {
                    instance = new GlobalPlayerData();
                }
            }
        }
        return instance;
    }

    public HashMap<Player, HashMap<String, Boolean>> getPlayerData() {
        return playerData;
    }

    public void setPlayerData(HashMap<Player, HashMap<String, Boolean>> newPlayerData) {
        this.playerData = newPlayerData;
    }
}
