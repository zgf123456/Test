package com.zgf.Test.gusi;

import java.util.ArrayList;

public class GuPiaoInfo {

    public static final ArrayList<GuPiaoInfo> guPiaoInfos = new ArrayList<GuPiaoInfo>();

    static {
        guPiaoInfos.add(new GuPiaoInfo("sh510300", "300ETF", "3"));
        guPiaoInfos.add(new GuPiaoInfo("sh600036", "招商", "zs"));
        guPiaoInfos.add(new GuPiaoInfo("sz002007", "华兰", "hl"));
        guPiaoInfos.add(new GuPiaoInfo("sz000338", "淮柴", "hc"));
        guPiaoInfos.add(new GuPiaoInfo("sh600702", "舍得", "sd"));
    }

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
