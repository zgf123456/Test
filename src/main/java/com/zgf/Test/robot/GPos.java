package com.zgf.Test.robot;

/**
 * 点的相对位置
 */
public class GPos {
    private int x; // 相对窗口的偏移量
    private int y; // 相对窗口的偏移量

    public GPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
