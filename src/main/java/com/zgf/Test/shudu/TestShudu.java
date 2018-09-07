package com.zgf.Test.shudu;

import java.util.HashSet;

public class TestShudu {

    public static void main(String[] args) {
        int allNum = 0;
        int succNum = 0;
        int failNum = 0;
        for (int i = 0; i < 1; i++) {
            System.out.println("create shudu " + i);
            Shudu shudu = new Shudu();
            boolean initResult = shudu.init();
            allNum++;
            if (initResult) {
                succNum++;
            } else {
                failNum++;
            }
            shudu.printShudu();
            int[][] shuduArray = shudu.getShudu();
            boolean checkShuduResult = checkShuduResult(shuduArray);
            System.out.println("create shuduResult " + initResult + ",checkShuduResult=" + checkShuduResult + ", allNum=" + allNum + ",succNum=" + succNum + ",failNum=" + failNum);
        }
    }

    private static boolean checkShuduResult(int[][] shuduArray) {
        HashSet<Integer> templateSet = new HashSet<>();
        templateSet.add(1);
        templateSet.add(2);
        templateSet.add(3);
        templateSet.add(4);
        templateSet.add(5);
        templateSet.add(6);
        templateSet.add(7);
        templateSet.add(8);
        templateSet.add(9);

        // 行判断
        for (int i = 0; i < Shudu.PX; i++) {
            HashSet<Integer> temp = (HashSet<Integer>) templateSet.clone();
            for (int j = 0; j < Shudu.PX; j++) {
                temp.remove(shuduArray[i][j]);
            }
            if (temp.size() > 0) {
                return false;
            }
        }

        // 列判断
        for (int i = 0; i < Shudu.PX; i++) {
            HashSet<Integer> temp = (HashSet<Integer>) templateSet.clone();
            for (int j = 0; j < Shudu.PX; j++) {
                temp.remove(shuduArray[j][i]);
            }
            if (temp.size() > 0) {
                return false;
            }
        }

        // 区域判断
        for (int startx = 0; startx < Shudu.PX; startx += 3) {
            HashSet<Integer> temp = (HashSet<Integer>) templateSet.clone();
            for (int starty = 0; starty < Shudu.PX; starty += 3) {
                temp.remove(shuduArray[startx][starty]);
                temp.remove(shuduArray[startx][starty + 1]);
                temp.remove(shuduArray[startx][starty + 2]);
                temp.remove(shuduArray[startx + 1][starty]);
                temp.remove(shuduArray[startx + 1][starty + 1]);
                temp.remove(shuduArray[startx + 1][starty + 2]);
                temp.remove(shuduArray[startx + 2][starty]);
                temp.remove(shuduArray[startx + 2][starty + 1]);
                temp.remove(shuduArray[startx + 2][starty + 2]);
            }
            if (temp.size() > 0) {
                return false;
            }
        }
        return true;
    }
}
