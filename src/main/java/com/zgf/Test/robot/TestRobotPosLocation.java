package com.zgf.Test.robot;

import java.awt.*;

/**
 * 位置校准
 */
public class TestRobotPosLocation {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(1000);

        // 绝对位置
        int rx_abs = 1193;
        int ry_abs = 194;

        GWindow gWindow = new GWindow(robot, rx_abs, ry_abs);
        int lx = gWindow.getLeftX();
        int ly = gWindow.getLeftY();

        // 绝对位置
        int boat_x_abs = 952;
        int boat_y_abs = 602;
        int load_x_abs = 761;
        int load_y_abs = 344;


        int boat_x_opp = boat_x_abs - lx;
        int boat_y_opp = boat_y_abs - ly;
        int load_x_opp = load_x_abs - lx;
        int load_y_opp = load_y_abs - ly;

        // 相对目标点
        GPos gPos_boat = new GPos(boat_x_opp, boat_y_opp);
        GPos gPos_load = new GPos(load_x_opp, load_y_opp);
        gWindow.move(gPos_boat);
        robot.delay(5000);
        gWindow.move(gPos_load);
    }
}
