package com.zgf.Test.aligorthm.dp;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/scramble-string/
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * @author zgf
 * @date 2021-04-16 上午11:10
 */
public class DpIsScramble {

    public static void main(String[] args) {
        DpIsScramble dpIsScramble = new DpIsScramble();
        System.out.println(dpIsScramble.isScramble("abcde", "caebd"));
        System.out.println(dpIsScramble.isScramble("great", "rgeat"));
    }

    /**
     * 穷举 + 备忘录
     * 基本用例能过
     * 超时了，需要备忘录，减少计算
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        HashMap<String, Boolean> dpMap = new HashMap<>();
        return isScrambleSub(s1, s2, 0, s1.length(), dpMap);
    }

    private boolean isScrambleSub(String str1, String str2, int start, int end, HashMap<String, Boolean> dpMap) {
//        System.out.println("subLeft=" + subLeft + ",start=" + start + ",end=" + end);
//        System.out.println(dpMap);
        String key = str1 + "_" + start + "_" + end;
        Boolean aBoolean = dpMap.get(key);
        if (aBoolean != null) {
            return aBoolean;
        }

        if (str1.equals(str2.substring(start, end))) {
            dpMap.put(key, true);
            return true;
        }

        if (str1.length() == 1) {
            dpMap.put(key, false);
            return false;
        }

        // 切割
        for (int i = 1; i < str1.length(); i++) {
            String ll = str1.substring(0, i);
            String rr = str1.substring(i, str1.length());
            // 正向比较
            boolean isMatch = isScrambleSub(ll, str2, start, start + i, dpMap) && isScrambleSub(rr, str2, start + i, end, dpMap);
            if (!isMatch) {
                // 翻转比较
                isMatch = isScrambleSub(ll, str2, end - i, end, dpMap) && isScrambleSub(rr, str2, start, end - i, dpMap);
            }
            if (isMatch) {
                dpMap.put(key, true);
                return true;
            }
        }
        dpMap.put(key, false);
        return false;
    }
}
