package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 就是求最长子序列（不要求连），其余的就是要删除的
 */
public class DpMinDistance {
    public static void main(String[] args) {
        DpMinDistance dpFindLength = new DpMinDistance();
        System.out.println(dpFindLength.minDistance("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println(dpFindLength.minDistance("bsbininm", "jmjkbkjkv"));
        System.out.println(dpFindLength.minDistance("abcde", "aceb"));
        System.out.println(dpFindLength.minDistance("abcba", "abcbcba"));
    }

    public int minDistance(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // 将0用非0填充，设置为已经匹配最长的值
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        int maxLen = 0;
        for (int i = 0; i <= len1; i++) {
            maxLen = Math.max(maxLen, dp[i][len2]);
        }
        return (len1 - maxLen) + (len2 - maxLen);
    }
}
