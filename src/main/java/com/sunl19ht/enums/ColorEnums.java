package com.sunl19ht.enums;

public enum ColorEnums {
    BLACK("§0"),    //黑色
    DARK_BLUE("§1"), //深蓝
    DARK_GREEN("§2"), //深绿
    DARK_AQUA("§3"), //深蓝绿
    DARK_RED("§4"), //深红
    DARK_PURPLE("§5"), //紫色
    GOLD("§6"), //金色
    GRAY("§7"), //灰色
    DARK_GRAY("§8"), //深灰
    BLUE("§9"), //蓝色
    GREEN("§a"), //亮绿色
    AQUA("§b"), //亮蓝色
    RED("§c"), //红色
    LIGHT_PURPLE("§d"), //粉色
    YELLOW("§e"), //黄色
    WHITE("§f"); //白色

    private final String code;

    ColorEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
