package com.zgf.Test.aligorthm.aStar;

/**
 * 点阵
 */
public class APointWrap {
    private APoint aPoint;
    private APointWrap parentPoint;
    private int costF;
    private int costG;
    private int costH;

    public APointWrap(APoint aPoint, APointWrap parentPoint) {
        this.aPoint = aPoint;
        this.parentPoint = parentPoint;
    }

    public APoint getaPoint() {
        return aPoint;
    }

    public void setaPoint(APoint aPoint) {
        this.aPoint = aPoint;
    }

    public APointWrap getParentPoint() {
        return parentPoint;
    }

    public void setParentPoint(APointWrap parentPoint) {
        this.parentPoint = parentPoint;
    }

    public int getCostF() {
        return costF;
    }

    public void setCostF(int costF) {
        this.costF = costF;
    }

    public int getCostG() {
        return costG;
    }

    public void setCostG(int costG) {
        this.costG = costG;
    }

    public int getCostH() {
        return costH;
    }

    public void setCostH(int costH) {
        this.costH = costH;
    }
}
