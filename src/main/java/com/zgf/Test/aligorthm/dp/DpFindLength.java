package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class DpFindLength {
    public static void main(String[] args) {
        DpFindLength dpFindLength = new DpFindLength();
        System.out.println(dpFindLength.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        return maxLen;
    }
}
