package com.zgf.Test.aligorthm.aStar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 测试A*算法
 */
public class TestAStar {
    public static void main(String[] args) {
        AGame aGame = initAGame(40, 20, 0.3f);
        aGame.printAMap();

        if (aGame.isGameInitResult()) {
            List<APoint> aPoints = aGame.startFindPath(aGame);

            if (aPoints != null) {
                System.out.println("game success....");
                aGame.printAMap(aPoints);
            } else {
                System.out.println("game fail....");
                List<APointWrap> closePoints = aGame.getClosePoints();
                List<APoint> findPath = new ArrayList<>();
                for (APointWrap cp : closePoints) {
                    findPath.add(cp.getaPoint());
                }
                aGame.printAMap(findPath);
            }
        }
    }

    /**
     * @param width
     * @param height
     * @param blockSizePre
     */
    private static AGame initAGame(int width, int height, float blockSizePre) {
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
        int gameInitCount = 0;
        boolean gameInitResult = false;
        for (; gameInitCount < 100; ) {
            gameInitCount++;
            int bCount = 0;
            int blockSize = (int) (blockSizePre * (width * height));
            for (; bCount < blockSize; ) {
                int wb = random.nextInt(width);
                int hb = random.nextInt(height);
                if (aPoints[wb][hb].getStatus() == 0) {
                    aPoints[wb][hb].setStatus(-2);
                    bCount++;
                }
            }

            // 尝试寻找路径
            // 清除障碍，重新生成
            gameInitResult = true;
            break;
        }

        aGame.setGameInitResult(gameInitResult);
        if (gameInitResult) {
            System.out.println("aGame init sucess....,initCount=" + gameInitCount);
        } else {
            System.out.println("aGame init fail....,initCount=" + gameInitCount);
        }
        return aGame;
    }
}
