package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 */
public class DpLongestCommonSubsequence {
    public static void main(String[] args) {
        DpLongestCommonSubsequence dpFindLength = new DpLongestCommonSubsequence();
        System.out.println(dpFindLength.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println(dpFindLength.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        System.out.println(dpFindLength.longestCommonSubsequence("abcde", "aceb"));
        System.out.println(dpFindLength.longestCommonSubsequence("abcba", "abcbcba"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
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
        return maxLen;
    }
}
