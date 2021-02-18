package com.zgf.Test.aligorthm.slidewin;

import java.util.HashMap;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class SwMinimumWindowSubstring {
    public static void main(String[] args) {
        SwMinimumWindowSubstring swMinimumWindowSubstring = new SwMinimumWindowSubstring();
        System.out.println(swMinimumWindowSubstring.minWindow("acbba", "aab"));
        System.out.println(swMinimumWindowSubstring.minWindow("ab", "a"));
        System.out.println(swMinimumWindowSubstring.minWindow("a", "b"));
        System.out.println(swMinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));

        System.out.println(swMinimumWindowSubstring.minWindow2("acbba", "aab"));
        System.out.println(swMinimumWindowSubstring.minWindow2("ab", "a"));
        System.out.println(swMinimumWindowSubstring.minWindow2("a", "b"));
        System.out.println(swMinimumWindowSubstring.minWindow2("ADOBECODEBANC", "ABC"));
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.equals(t)) return s;
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = start + t.length() - 1;

        // 先找到最长的匹配串
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = start; i <= end; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (isContain(sMap, tMap)) {
            return s.substring(start, end + 1);
        }

        end++;
        int minStart = start;
        int minEnd = s.length() - 1;
        int minLen = s.length();
        boolean isMatch = false;
        for (; end < s.length(); ) {
            sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
            if (isContain(sMap, tMap)) {
                isMatch = true;
                // 缩小start
                do {
                    sMap.put(s.charAt(start), sMap.getOrDefault(s.charAt(start), 1) - 1);
                    start++;
                } while (isContain(sMap, tMap));
                //获取最小的串
                int len = end - (start - 1) + 1;
                if (len < minLen) {
                    minStart = start - 1;
                    minEnd = end;
                    minLen = len;
                }
//                break;
            }
            end++;
        }

        if (isMatch) {
            return s.substring(minStart, minEnd + 1);
        }
        return "";
    }

    /**
     *  整个算法有点问题，结果不一定是最小的
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        if (s.equals(t)) return s;
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minStart = 0;
        int minEnd = s.length() - 1;

        // 先将整个字符串初始化成map
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = minStart; i <= minEnd; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (isContain(sMap, tMap)) {
            // 收缩左窗口
            do {
                sMap.put(s.charAt(minStart), sMap.getOrDefault(s.charAt(minStart), 1) - 1);
                minStart++;
            } while (isContain(sMap, tMap));
            minStart--;
            sMap.put(s.charAt(minStart), sMap.getOrDefault(s.charAt(minStart), 0) + 1);

            // 收缩右窗口
            do {
                sMap.put(s.charAt(minEnd), sMap.getOrDefault(s.charAt(minEnd), 1) - 1);
                minEnd--;
            } while (isContain(sMap, tMap));
            minEnd++;
            return s.substring(minStart, minEnd + 1);
        } else {
            return "";
        }
    }

    boolean isContain(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        Set<Character> characters = tMap.keySet();
        for (Character key : characters) {
            Integer r1 = sMap.get(key);
            Integer r2 = tMap.get(key);
            if (r1 == null) {
                r1 = 0;
            }
            if (r2 == null) {
                r2 = 0;
            }
            if (r1 < r2) {
                return false;
            }
        }
        return true;
    }
}
