package com.zgf.Test.robot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GZGF {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // 初始化窗口
        ArrayList<GWindow> gWindowArrayList = new ArrayList<>();
        gWindowArrayList.add(new GWindow(robot, 808, 81)); // 需校准位置
        gWindowArrayList.add(new GWindow(robot, 1208, 206)); // 需校准位置
        gWindowArrayList.add(new GWindow(robot, 1563, 366)); // 需校准位置

        // 定时执行
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                for (GWindow gWindow : gWindowArrayList) {
                    gWindow.frontShowMe();
                    gWindow.eat50(1);
                    gWindow.dropLoadAll(5);
                }
            }
        }, 5000, 60000);
    }
}
