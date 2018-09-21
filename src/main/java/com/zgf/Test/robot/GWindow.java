package com.zgf.Test.robot;

import java.awt.*;
import java.awt.event.InputEvent;

public class GWindow {
    private int width = 800;
    private int height = 600;

    private Robot robot;

    // 窗口左上位置
    private int leftX;
    private int leftY;

    // 窗口右上位置
    private int rightX;
    private int rightY;

    // 窗口位置
    public GWindow(Robot robot, int x, int y) {
        this.robot = robot;
        leftX = x - width;
        leftY = y;
        rightX = x;
        rightY = y;
    }

    // 前台显示
    public void frontShowMe() {
        robot.mouseMove(rightX, rightY);
        // 鼠标左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    // 吃50料理
    public void eat50(int times) {

    }

    // 丢垃圾
    public void dropLoadAll() {

    }
}
