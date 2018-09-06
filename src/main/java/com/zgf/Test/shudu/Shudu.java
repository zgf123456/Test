package com.zgf.Test.shudu;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Shudu {
    private static final int PX = 9;
    private int[][] sdArr = new int[PX][PX];
    private Random random = new Random();

    // 随机池
    private LinkedList<Pos> stepPool = new LinkedList<>();
    private LinkedList<Pos> existPool = new LinkedList<>();
    private Stack<LinkedList<Pos>> poolStack = new Stack<>();

    // 初始化
    public boolean init() {
        boolean buildResult = false;
        while (!buildResult) {
            sdArr = new int[PX][PX];
            stepPool.clear();
            existPool.clear();
            poolStack.clear();
            for (int i = 0; i < PX; i++) {
                for (int j = 0; j < PX; j++) {
                    stepPool.add(new Pos(i, j));
                }
            }
            int start = 1;
            int end = 5;
            buildResult = randomInitPart(start, end);
            if (buildResult) {
                buildResult = stepInitOther(end);
            }
        }
        return buildResult;
    }

    /**
     * 生成部分局面 1 ~ 5
     *
     * @return
     */
    public boolean randomInitPart(int start, int end) {
        for (int i = start; i <= end; i++) {
            boolean result = false;
            int tryNum = 0;
            while (!result) {
                tryNum++;
                result = randomSetNum(i);
                System.out.println("randomInitPart " + i + "=" + result);
                if (!result && tryNum > 7) {
                    i--;
                    if (i < 0) {
                        return false;
                    }
                    tryNum = 0;
                    if (poolStack.size() > 0) {
                        LinkedList<Pos> posList = poolStack.pop();
                        for (Pos pos : posList) {
                            sdArr[pos.getX()][pos.getY()] = 0;
                        }
                    }
                }
            }

        }
        return true;
    }

    /**
     * 顺序填充
     *
     * @param end
     */
    private boolean stepInitOther(int end) {
        for (int i = end + 1; i <= PX; i++) {
            boolean result = false;
            int tryNum = 0;
            while (!result) {
                tryNum++;
                result = stepSetNum(i);
                System.out.println("stepInitOther " + i + "=" + result);
                if (!result && tryNum > 7) {
                    i--;
                    if (i <= end) {
                        return false;
                    }
                    tryNum = 0;
                    if (poolStack.size() > 0) {
                        LinkedList<Pos> posList = poolStack.pop();
                        for (Pos pos : posList) {
                            sdArr[pos.getX()][pos.getY()] = 0;
                        }
                    }
                }
            }

        }
        return true;
    }

    /**
     * 先随机填充值
     *
     * @param num
     * @return
     */
    public boolean randomSetNum(int num) {
        int passNum = 0;

        LinkedList<Pos> randomPoolClone = (LinkedList<Pos>) stepPool.clone();
        randomPoolClone.removeAll(existPool);
        LinkedList<Pos> curPool = new LinkedList<>();

        while (true) {
            Pos pos;
            int size = randomPoolClone.size();
            if (size > 2) {
                int p = random.nextInt(size);
                pos = randomPoolClone.get(p);
            } else if (size == 0) {
                return false;
            } else {
                pos = randomPoolClone.get(0);
            }

            if (check(sdArr, pos.getX(), pos.getY(), num)) {
                sdArr[pos.getX()][pos.getY()] = num;
                existPool.add(pos);
                curPool.add(pos);
                passNum++;
            }

            randomPoolClone.remove(pos);
            if (randomPoolClone.size() == 0 || passNum == PX) {
                break;
            }
        }

        if (passNum == PX) {
            poolStack.push(curPool);
            return true;
        } else {
            for (Pos pos : curPool) {
                sdArr[pos.getX()][pos.getY()] = 0;
            }
            existPool.removeAll(curPool);
            return false;
        }
    }

    /**
     * 按顺序设置值
     *
     * @param num
     * @return
     */
    public boolean stepSetNum(int num) {
        int passNum = 0;

        LinkedList<Pos> randomPoolClone = (LinkedList<Pos>) stepPool.clone();
        randomPoolClone.removeAll(existPool);
        LinkedList<Pos> curPool = new LinkedList<>();

        while (true) {
            Pos pos;
            int size = randomPoolClone.size();
            if (size > 0) {
                pos = randomPoolClone.get(0);
            } else {
                return false;
            }

            if (check(sdArr, pos.getX(), pos.getY(), num)) {
                sdArr[pos.getX()][pos.getY()] = num;
                existPool.add(pos);
                curPool.add(pos);
                passNum++;
            }

            randomPoolClone.remove(pos);
            if (randomPoolClone.size() == 0 || passNum == PX) {
                break;
            }
        }

        if (passNum == PX) {
            poolStack.push(curPool);
            return true;
        } else {
            for (Pos pos : curPool) {
                sdArr[pos.getX()][pos.getY()] = 0;
            }
            existPool.removeAll(curPool);
            return false;
        }
    }

    // 格子合法判定
    private boolean check(int[][] tempAry, int x, int y, int val) {
        // 1. 检查是否为空
        if (tempAry[x][y] != 0) {
            return false;
        }

        // 判断同行
        for (int i = 0; i < PX; i++) {
            if (tempAry[x][i] == val) {
                return false;
            }
        }

        // 判断同列
        for (int i = 0; i < PX; i++) {
            if (tempAry[i][y] == val) {
                return false;
            }
        }

        // 判断同区
        int rx = x / 3;
        int ry = y / 3;
        for (int startx = rx * 3, endx = (rx + 1) * 3; startx < endx; startx++) {
            for (int starty = ry * 3, endy = (ry + 1) * 3; starty < endy; starty++) {
                if (tempAry[startx][starty] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printShudu() {
        for (int i = 0; i < PX; i++) {
            for (int j = 0; j < PX; j++) {
                System.out.print(sdArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] getShudu() {
        return sdArr.clone();
    }
}
