package com.zgf.Test.aligorthm.aStar;

/**
 * 地图，包含点阵集合
 */
public class AMap {
    private int wight;
    private int height;
    private APoint[][] aPoints = null;

    public AMap(int wight, int height, APoint[][] aPoints) {
        this.wight = wight;
        this.height = height;
        this.aPoints = aPoints;
    }

    public int getWight() {
        return wight;
    }

    public int getHeight() {
        return height;
    }

    public APoint getPoint(int x, int y) {
        return aPoints[x][y];
    }
}
