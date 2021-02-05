package com.zgf.Test.aligorthm.backtrack;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/interleaving-string/
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 */
public class BtIsInterleave {
    public static void main(String[] args) {
        BtIsInterleave btIsInterleave = new BtIsInterleave();
        System.out.println(btIsInterleave.isInterleave2("ab", "bc", "babc"));
//        System.out.println(btIsInterleave.isInterleave2("aabcc", "dbbca", "aadbbcbcac"));
    }

    /**
     * 动态规划的解法
     * <p>
     * 假设s1长度为m s2长度为n s3长度为l，当然首先l==m+n需要满足
     * <p>
     * 1.如果s1和s2交错构成s3，那么dp[m][n]=1,表示s1的前m个元素和s2的前n个元素可以构成l的前(m+n)个元素
     * <p>
     * 2.dp[m][n]可以由dp[m-1][n]或者dp[m][n-1]获得：
     * dp[m-1][n] 表示当s1的前m-1个元素和s2的前n个元素可以构成l的前(m+n-1)个元素 + 条件s1[m-1]==s3[m+n-1]
     * dp[m][n-1] 表示当s1的前m个元素和s2的前n-1个元素可以构成l的前(m+n-1)个元素 + 条件s2[n-1]==s3[m+n-1]
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dpTalbe = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    // 空字符串匹配
                    dpTalbe[i][j] = true;
                } else if (i == 0) {
                    // 只使用s2
                    dpTalbe[i][j] = dpTalbe[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    // 只使用s1
                    dpTalbe[i][j] = dpTalbe[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    // s1 || s2
                    dpTalbe[i][j] = dpTalbe[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dpTalbe[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }


        for (int i = 0; i < dpTalbe.length; i++) {
            for (int j = 0; j < dpTalbe[i].length; j++) {
                if (dpTalbe[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        return dpTalbe[s1.length()][s2.length()];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> cache = new HashMap<>();
        return doIsInterleave(s1, s2, s3, 0, 0, 0, cache);
    }

    /**
     * 回溯法，超时了，需要加上剪支c
     *
     * @param s1
     * @param s2
     * @param s3
     * @param idx1
     * @param idx2
     * @param idx3
     * @param cache
     * @return
     */
    private boolean doIsInterleave(String s1, String s2, String s3, int idx1, int idx2, int idx3, HashMap<String, Boolean> cache) {
        if (idx3 >= s3.length()) {
            if (idx1 >= s1.length() && idx2 >= s2.length()) {
                return true;
            }
            return false;
        }
        Boolean aBoolean = cache.get(idx1 + "&" + idx2);
        if (aBoolean != null) {
            return aBoolean;
        }

        char c3 = s3.charAt(idx3);
        boolean isInterleave = false;
        if (idx1 < s1.length()) {
            char c1 = s1.charAt(idx1);
            if (c3 == c1) {
                isInterleave = doIsInterleave(s1, s2, s3, idx1 + 1, idx2, idx3 + 1, cache);
            }
        }

        if (isInterleave) {
            return true;
        }

        if (idx2 < s2.length()) {
            char c2 = s2.charAt(idx2);
            if (c3 == c2) {
                isInterleave = doIsInterleave(s1, s2, s3, idx1, idx2 + 1, idx3 + 1, cache);
            }
        }
        cache.put(idx1 + "&" + idx2, isInterleave);
        return isInterleave;
    }
}
