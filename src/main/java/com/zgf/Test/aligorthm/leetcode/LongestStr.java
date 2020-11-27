package com.zgf.Test.aligorthm.leetcode;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestStr {
    public static void main(String[] args) {
        LongestStr longestStr = new LongestStr();
        int maxLen = longestStr.longestValidParentheses("(()");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("(()())");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("()(()");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("()(())");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("(()(((()");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("(()(((())");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("(()(((()))");
        System.out.println(maxLen);
        maxLen = longestStr.longestValidParentheses("(()()(())((");
        System.out.println(maxLen);
    }

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
