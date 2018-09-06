package com.zgf.Test.shudu;

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
        return true;
    }
}
