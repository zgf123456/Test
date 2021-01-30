package com.zgf.Test.aligorthm.slidewin;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class SwLengthOfLongestSubstring {
    public static void main(String[] args) {
        SwLengthOfLongestSubstring swLengthOfLongestSubstring = new SwLengthOfLongestSubstring();
        System.out.println(swLengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(swLengthOfLongestSubstring.lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return 1;
            return 2;
        }

        int start = 0;
        int end = 0;
        int maxLen = 1;
        // 窗口
        HashSet<Character> hashSet = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            char c = s.charAt(end);
            if (hashSet.contains(c)) {
                while (hashSet.contains(c)) {
                    hashSet.remove(s.charAt(start));
                    start++;
                }
                hashSet.add(c);
                end++;
                maxLen = Math.max(maxLen, end - start);
            } else {
                hashSet.add(c);
                end++;
                maxLen = Math.max(maxLen, end - start);
            }
        }
        return maxLen;
    }
}
