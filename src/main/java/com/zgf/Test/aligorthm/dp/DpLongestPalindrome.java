package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class DpLongestPalindrome {
    public static void main(String[] args) {
        DpLongestPalindrome dpLongestPalindrome = new DpLongestPalindrome();
        System.out.println(dpLongestPalindrome.longestPalindrome("aaaaa"));
        System.out.println(dpLongestPalindrome.longestPalindrome("abb"));
        System.out.println(dpLongestPalindrome.longestPalindrome("babad"));
    }

    /**
     * 暴力破解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 1) return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.substring(0, 1);
        }

        int maxI = 0, maxJ = 0, maxLen = 0;
        // 偶数情况
        for (int i = 0, j = i + 1; j < s.length(); ) {
            if (s.charAt(i) == s.charAt(j)) {
                // 向两边扩散判断是否回文
                int m = i - 1, n = j + 1;
                while (m >= 0 && n < s.length()) {
                    if (s.charAt(m) == s.charAt(n)) {
                        m--;
                        n++;
                    } else {
                        break;
                    }
                }

                // 发现回文串
                m = m + 1;
                n = n - 1;
                if (maxLen == 0) {
                    maxLen = n - m + 1;
                    maxI = m;
                    maxJ = n;
                } else {
                    if (n - m + 1 > maxLen) {
                        maxLen = n - m + 1;
                        maxI = m;
                        maxJ = n;
                    }
                }
            }
            i++;
            j++;
        }

        // 奇数情况
        for (int i = 0, j = i + 2; j < s.length(); ) {
            if (s.charAt(i) == s.charAt(j)) {
                // 向两边扩散判断是否回文
                int m = i - 1, n = j + 1;
                while (m >= 0 && n < s.length()) {
                    if (s.charAt(m) == s.charAt(n)) {
                        m--;
                        n++;
                    } else {
                        break;
                    }
                }

                // 发现回文串
                m = m + 1;
                n = n - 1;
                if (maxLen == 0) {
                    maxLen = n - m + 1;
                    maxI = m;
                    maxJ = n;
                } else {
                    if (n - m + 1 > maxLen) {
                        maxLen = n - m + 1;
                        maxI = m;
                        maxJ = n;
                    }
                }
            }
            i++;
            j++;
        }

        if (maxLen == 0) {
            return s.substring(0, 1);
        }
        return s.substring(maxI, maxJ + 1);
    }
}
