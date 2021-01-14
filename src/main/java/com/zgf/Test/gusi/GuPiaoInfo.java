package com.zgf.Test.gusi;

public class GuPiaoInfo {
    private String id;
    private String name;
    private String showName;

    public GuPiaoInfo(String id, String name, String showName) {
        this.id = id;
        this.name = name;
        this.showName = showName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }
}
