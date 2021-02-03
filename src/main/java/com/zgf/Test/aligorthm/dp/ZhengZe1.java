package com.zgf.Test.aligorthm.dp;

import java.util.Date;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/submissions/
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 */
public class ZhengZe1 {
    public static void main(String[] args) {
        ZhengZe1 zhengZe = new ZhengZe1();
//        System.out.println(zhengZe.isMatch("aa", "a"));
//        System.out.println(zhengZe.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(zhengZe.isMatch("", "c*"));
//        System.out.println(zhengZe.isMatch("", ""));
//        System.out.println(zhengZe.isMatch("", "c*c*"));
//        System.out.println(zhengZe.isMatch("adceb", "*a*b"));
//        System.out.println(zhengZe.isMatch("aa", "*"));
//        System.out.println(zhengZe.isMatch("zacabz", "*a?b*"));
//        System.out.println(zhengZe.isMatch("", "*****"));
        Date start = new Date();
        System.out.println(zhengZe.isMatch("abbaaaabbbbbababbbbbbbbaaabaabbabaabbaaabbbbabbbbab", "a*aaba***b**a*a********"));
        System.out.println(zhengZe.isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb"
                , "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
    }

    /**
     * 矩阵
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        // 正则简化，连续的*简化成单个
        StringBuilder sb = new StringBuilder();
        char pre = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (pre == 0) {
                pre = c;
                sb.append(c);
            } else if (pre == '*' && c == '*') {
                continue;
            } else {
                pre = c;
                sb.append(c);
            }
        }
        p = sb.toString();

        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        return dp[len1][len2];
    }

    /**
     * 动态规划，自底向上填表法
     * 从左上角，按斜线的方式，向右下角走
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        // 正则简化，连续的*简化成单个
        StringBuilder sb = new StringBuilder();
        char pre = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (pre == 0) {
                pre = c;
                sb.append(c);
            } else if (pre == '*' && c == '*') {
                continue;
            } else {
                pre = c;
                sb.append(c);
            }
        }
        p = sb.toString();

        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        // 空串
        dp[0][0] = true;
        // 处理一下匹配串 p 以若干个星号开头的情况。因为星号是可以匹配空串的
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        // i为匹配串下标，j为被匹配串下标
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 第i，j保存第i-1,j-1位置的结果
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    // 相同 或为 ?
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    // * 匹配0次 dp[i][j - 1]
                    // * 匹配n次 dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                System.out.print(dp[i][j] ? 0 : 1);
            }
            System.out.println();
        }
        return dp[len1][len2];
    }
}
