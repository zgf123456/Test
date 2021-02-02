package com.zgf.Test.aligorthm.slidewin;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 104。
 */
public class SwCharacterReplacement {
    public static void main(String[] args) {
        SwCharacterReplacement swCharacterReplacement = new SwCharacterReplacement();

//        System.out.println(swCharacterReplacement.characterReplacement0("ABBBA"));
//        System.out.println(swCharacterReplacement.characterReplacement0("ABBB"));
//        System.out.println(swCharacterReplacement.characterReplacement0("AABABBA"));
//        System.out.println(swCharacterReplacement.characterReplacement0("ABAB"));

        System.out.println(swCharacterReplacement.characterReplacement("ABBBA", 2));
        System.out.println(swCharacterReplacement.characterReplacement("ABBB", 2));
        System.out.println(swCharacterReplacement.characterReplacement("AABABBA", 1));
        System.out.println(swCharacterReplacement.characterReplacement("ABAB", 2));
    }

    /**
     * 将K退化成0的写法
     *
     * @param s
     * @return
     */
    public int characterReplacement0(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int winMaxLen = 1;
        int winLen = 1;
        for (int i = 0, j = 1; j < s.length(); ) {
            if (s.charAt(i) == s.charAt(j)) {
                winLen++;
                j++;
                continue;
            } else {
                // 窗体右移
                winMaxLen = Math.max(winLen, winMaxLen);
                i++;
                j = i + 1;
                winLen = 1;
            }
        }
        winMaxLen = Math.max(winLen, winMaxLen);
        return winMaxLen;
    }

    /**
     * 使用滑动窗口
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int winMaxLen = 1;
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0, j = 0; j < s.length(); ) {
            char c = s.charAt(j);
            Integer size = treeMap.get(c);
            if (size == null) {
                treeMap.put(c, 1);
            } else {
                treeMap.put(c, size + 1);
            }

            // 判断窗口合法性
            int len = check(treeMap, k);
            if (len == -1) {
                // 移除第一位
                char st = s.charAt(i);
                Integer integer = treeMap.get(st);
                treeMap.put(st, integer - 1);
                i++;
                j++;
            } else {
                j++;
                winMaxLen = Math.max(len, winMaxLen);
            }
        }
        return winMaxLen;
    }

    /**
     * 判断合法窗口长度
     * @param treeMap
     * @param k
     * @return
     */
    private int check(TreeMap<Character, Integer> treeMap, int k) {
        if (treeMap.size() == 1) {
            return treeMap.firstEntry().getValue();
        }

        int diffNum = 0;
        int maxNum = 0;
        Set<Map.Entry<Character, Integer>> entries = treeMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            diffNum += entry.getValue();
            if (entry.getValue() > maxNum) {
                maxNum = entry.getValue();
            }
        }

        if (diffNum - maxNum <= k) {
            return diffNum;
        }
        return -1;
    }
}
