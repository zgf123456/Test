package com.zgf.Test.aligorthm.dp;

/**
 * 斐波那契 - 动态规划解法
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        for (int i = 0; i < 100; i++) {
            System.out.println("fib(" + i + ")=" + fib.fib(i));
            System.out.println("fib2(" + i + ")=" + fib.fib2(i));
        }
    }

    public long fib(int n) {
        if (n < 1) return 0;
        if (n <= 2) return 1;
        long[] dbTable = new long[n + 1];
        dbTable[1] = 1;
        dbTable[2] = 1;

        for (int i = 3; i <= n; i++) {
            dbTable[i] = dbTable[i - 1] + dbTable[i - 2];
        }
        return dbTable[n];
    }

    /**
     * 状态压缩
     * @param n
     * @return
     */
    public long fib2(int n) {
        if (n < 1) return 0;
        if (n <= 2) return 1;
        long preN1 = 1;
        long preN2 = 1;
        long fibn = 0;

        for (int i = 3; i <= n; i++) {
            fibn = preN1 + preN2;
            preN2 = preN1;
            preN1 = fibn;
        }
        return fibn;
    }
}
