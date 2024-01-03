package enums;

public enum ColorEnums {
    BLACK("§0");

    private final String code;

    ColorEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
