package com.ruoyi.common.enums;

public enum TitleSource {

    title1("1", "教师科研"),
    title2("2", "社会生产实践"),
    title3("3", "教学"),
    title4("4", "其他");

    private String key;

    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    TitleSource(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String get(String key) {
        for (TitleSource titleSource : TitleSource.values()) {
            if (key.equals(titleSource.getKey())) {
                return titleSource.getName();
            }
        }
        return "";
    }
}
