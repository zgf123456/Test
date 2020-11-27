package com.zgf.Test.aligorthm;

import java.util.Arrays;

/**
 * 爬楼梯，1次走1步或两步，动态规划解法，结果为斐波那契数列
 */
public class Step {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        dp[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        System.out.println(Arrays.toString(dp));
    }
}
