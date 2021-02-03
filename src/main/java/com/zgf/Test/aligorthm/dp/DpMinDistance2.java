package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class DpMinDistance2 {
    public static void main(String[] args) {
        DpMinDistance2 dpFindLength = new DpMinDistance2();
        System.out.println(dpFindLength.minDistance("horse", "ros"));
        System.out.println(dpFindLength.minDistance("inten", "execu"));
    }

    public int minDistance(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化表示对空字符串的编辑距离
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // 不用新增编辑距离
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 增加(i+1, j) || 删除(i, j+1) || 替换(i, j) + 1
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[len1][len2];
    }
}
