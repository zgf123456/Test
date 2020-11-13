package com.zgf.Test.aligorthm.aStar;

import java.util.Objects;

/**
 * 点阵
 */
public class APoint implements Comparable {
    private int x;
    private int y;
    private int status = 0; // 负数-不可通行，0-普通，1-起点，9-终点

    public APoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int compareTo(Object o) {
        return this.equals(o) ? 0 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APoint aPoint = (APoint) o;
        return x == aPoint.x &&
                y == aPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
