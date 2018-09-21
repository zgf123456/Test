package com.zgf.Test.robot;

import java.awt.*;

public class TestRobotPos {
    public static void main(String[] args) throws Exception {

        Robot robot = new Robot();
        robot.setAutoDelay(1000);

        while (true) {
            PointerInfo pinfo = MouseInfo.getPointerInfo();
            Point p = pinfo.getLocation();
            int mx = (int) p.getX();
            int my = (int) p.getY();
            System.out.println("mx=" + mx + ",my=" + my);
            Thread.sleep(5000);
        }
    }
}
