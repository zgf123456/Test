package com.zgf.Test.aligorthm.leetcode;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestStr {
    public static void main(String[] args) {
        LongestStr longestStr = new LongestStr();
        int maxLen = 0;
//        longestStr.longestValidParentheses("(()");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("(()())");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("()(()");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("()(())");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("(()(((()");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("(()(((())");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("(()(((()))");
//        System.out.println(maxLen);
//        maxLen = longestStr.longestValidParentheses("(()()(())((");
//        System.out.println(maxLen);

        // dp
        longestStr.longestValidParentheses_dp("(()");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("(()())");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("()(()");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("()(())");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("(()(((()");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("(()(((())");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("(()(((()))");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses_dp("(()()(())((");
        System.out.println(maxLen);
    }

    /**
     * dp思路
     * (...){1, n} 有效括号形式, ... 为子有效括号
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_dp(String s) {
        int res = 0;
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 寻找对应的闭合括号，为前一个，或减去前一个闭合区间的前一个
                int leftIndex = i - 1 - dp[i - 1];

                // 判断闭合括号的下标是否合法，且是否是匹配的闭合括号
                if (leftIndex >= 0 && s.charAt(leftIndex) == '(') {
                    // 匹配成功，存储当前的值
                    // 当前的值 = 2 + 内部闭合值 + 上一个连续的闭合值(leftIndex - 1);
                    // 不一定有连续的游戏括号区间，所以需判断 leftIndex - 1 的合法性
                    dp[i] = 2 + dp[i - 1] + (leftIndex - 1 >= 0 ? dp[leftIndex - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


//    /**
//     * 动态规划解法 - TODO 待理解
//     *
//     * @param s
//     * @return
//     */
//    public int longestValidParentheses_dp(String s) {
//        int res = 0, N = s.length();
//        int dp[] = new int[N];
//        for (int i = 1; i < N; i++) {
//            if (s.charAt(i) == ')') {
//                int leftIndex = i - dp[i - 1] - 1;
//                if (leftIndex >= 0 && s.charAt(leftIndex) == '(') {
//                    dp[i] = dp[i - 1] + (leftIndex - 1 >= 0 ? dp[leftIndex - 1] : 0) + 2;
//                }
//                res = Math.max(res, dp[i]);
//            }
//        }
//        return res;
//    }

    /**
     * 递归 + 替换的方法
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        doLongestValidParentheses(chars);

        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0' || chars[i] == '1') {
                curLen = curLen + 1;
            } else {
                maxLen = Math.max(curLen, maxLen);
                curLen = 0;
            }
        }
        maxLen = Math.max(curLen, maxLen);
        return maxLen;
    }

    public void doLongestValidParentheses(char[] chars) {
        boolean hasMatch = false;
        for (int i = 0, j = 1; j < chars.length; ) {
            if (chars[i] != '(') {
                i = i + 1;
                j = i + 1;
            } else if (chars[j] == '0' || chars[j] == '1') {
                j = j + 1;
            } else if (chars[j] == ')') {
                hasMatch = true;
                chars[i] = '0';
                chars[j] = '1';
                i = j + 1;
                j = i + 1;
            } else {
                i = i + 1;
                j = i + 1;
            }
        }
        if (hasMatch) {
            doLongestValidParentheses(chars);
        }
    }
}
