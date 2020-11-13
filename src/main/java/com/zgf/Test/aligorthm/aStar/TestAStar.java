package com.zgf.Test.aligorthm.aStar;

import java.util.Random;

/**
 * 测试A*算法
 */
public class TestAStar {
    public static void main(String[] args) {
        AGame aGame = initAGame(10, 10, 20);
        aGame.printAMap();
        aGame.startFindPath(aGame);
    }

    /**
     * @param width
     * @param height
     * @param blockSize
     */
    private static AGame initAGame(int width, int height, int blockSize) {
        System.out.println("aGame init start....");

        AGame aGame = new AGame();
        APoint[][] aPoints = new APoint[width][height];
        AMap aMap = new AMap(width, height, aPoints);
        aGame.setaMap(aMap);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                aPoints[i][j] = new APoint(i, j);
            }
        }

        // 随机开始结束节点
        Random random = new Random();
        int ws = random.nextInt(width);
        int hs = random.nextInt(height);
        APoint aPointStart = aPoints[ws][hs];
        aPointStart.setStatus(1);
        aGame.setStartPoint(aPointStart);

        for (; ; ) {
            int we = random.nextInt(width);
            int he = random.nextInt(height);
            if (aPoints[we][he].getStatus() == 0) {
                APoint aPointEnd = aPoints[we][he];
                aPointEnd.setStatus(9);
                aGame.setEndPoint(aPointEnd);
                break;
            }
        }

        // 设置障碍
        int bCount = 0;
        for (; bCount < blockSize; ) {
            int wb = random.nextInt(width);
            int hb = random.nextInt(height);
            if (aPoints[wb][hb].getStatus() == 0) {
                aPoints[wb][hb].setStatus(-1);
                bCount++;
            }
        }
        System.out.println("aGame init end....");
        return aGame;
    }
}
