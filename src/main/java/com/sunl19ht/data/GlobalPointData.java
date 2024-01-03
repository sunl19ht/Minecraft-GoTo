package com.sunl19ht.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GlobalPointData {
    private static GlobalPointData instance;
    private HashMap<Player, HashMap<String, Location>> pointData;

    private GlobalPointData() {
        pointData = new HashMap<>();
    }

    public static GlobalPointData getInstance() {
        if (instance == null) {
            synchronized (GlobalPointData.class) {
                if (instance == null) {
                    instance = new GlobalPointData();
                }
            }
        }
        return instance;
    }

    public HashMap<Player, HashMap<String, Location>> getPointData() {
        return pointData;
    }
}
