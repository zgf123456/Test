package com.zgf.Test.robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TestRobot {
    public static void main(String[] args) throws Exception {

        Robot robot = new Robot();
        robot.setAutoDelay(1000);

        // 获取分辨率
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(d);

//        //以屏幕的尺寸创建个矩形
//        Rectangle screenRect = new Rectangle(d);
//        //截图（截取整个屏幕图片）
//        BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
//        //保存截图
//        File file = new File("/Users/zgf/Downloads/temp/screenRect" + System.currentTimeMillis() + ".png");
//        ImageIO.write(bufferedImage, "png", file);


        // 鼠标控制
        robot.mouseMove(500, 500);
        // 点击鼠标
        // 鼠标左键
        System.out.println("单击");
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        //鼠标右键
        System.out.println("右击");
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);

        //按下ESC，退出右键状态
        System.out.println("按下ESC");
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}
