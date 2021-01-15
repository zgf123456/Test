package com.zgf.Test.gusi;

import java.util.ArrayList;

public class GuPiaoInfo {

    public static final ArrayList<GuPiaoInfo> guPiaoInfos = new ArrayList<GuPiaoInfo>();

    static {
        guPiaoInfos.add(new GuPiaoInfo("sh510300", "300ETF", "3"));
        guPiaoInfos.add(new GuPiaoInfo("sh600036", "招商", "ZS", false));
        guPiaoInfos.add(new GuPiaoInfo("sh601166", "兴业", "XY", false));
        guPiaoInfos.add(new GuPiaoInfo("sh601939", "建设", "JS"));
        guPiaoInfos.add(new GuPiaoInfo("sz002007", "华兰", "HL"));
        guPiaoInfos.add(new GuPiaoInfo("sz000338", "淮柴", "HC"));
        guPiaoInfos.add(new GuPiaoInfo("sh600702", "舍得", "SD"));
//        guPiaoInfos.add(new GuPiaoInfo("sh600030", "中信", "ZX"));
    }

    private String id;
    private String name;
    private String showName;
    private boolean showCurPrice;

    public GuPiaoInfo(String id, String name, String showName) {
        this.id = id;
        this.name = name;
        this.showName = showName;
        this.showCurPrice = false;
    }

    public GuPiaoInfo(String id, String name, String showName, boolean showCurPrice) {
        this.id = id;
        this.name = name;
        this.showName = showName;
        this.showCurPrice = showCurPrice;
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

    public static ArrayList<GuPiaoInfo> getGuPiaoInfos() {
        return guPiaoInfos;
    }

    public boolean isShowCurPrice() {
        return showCurPrice;
    }

    public void setShowCurPrice(boolean showCurPrice) {
        this.showCurPrice = showCurPrice;
    }
}
