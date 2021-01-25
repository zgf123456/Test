package com.zgf.Test.aligorthm.dp;

/**
 * 正则匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class ZhengZe {
    public static void main(String[] args) {
        ZhengZe zhengZe = new ZhengZe();
        System.out.println(zhengZe.isMatch("aa", "a"));
//        System.out.println(zhengZe.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(zhengZe.isMatch("", "c*"));
//        System.out.println(zhengZe.isMatch("", ""));
        System.out.println(zhengZe.isMatch("", "c*c*"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null) return false;
        if (p == null) return false;

        if (s.equals(p)) return true;

        // 2指针
        // 追加字符串，避免判断空的问题
        s = "a" + s;
        p = "a" + p;
        int sp1 = 0;
        int pp1 = 0;
        return doIsMatch(s, p, sp1, pp1);
    }

    private boolean doIsMatch(String s, String p, int sp1, int pp1) {
        // 结束条件
        if (sp1 >= s.length()) {
            if (pp1 >= p.length()) {
                return true;
            }
            if((pp1+1) < p.length() && p.charAt(pp1 + 1) == '*') {
                // 进行空串匹配模式
                return doIsMatch(s, p, sp1, pp1 + 2);
            }
            return false;
        }

        if(pp1 >= p.length()) {
            if(sp1 >= s.length()) {
                return true;
            }
            return false;
        }

        // . 匹配1次
        // * 匹配0次或多次，这用一次或多次表示
        char sc = s.charAt(sp1);
        char pc = p.charAt(pp1);
        int pp1Next = pp1 + 1;
        Character pcNext = null;
        if (pp1Next < p.length()) {
            pcNext = p.charAt(pp1Next);
        }

        if (pcNext != null && pcNext == '*') {
            // 匹配0次 或 匹配1次
            boolean rs1 = doIsMatch(s, p, sp1, pp1 + 2); // 匹配0次，表示跳过当前模式串

            // 匹配1次，表示可以继续向后匹配字符
            boolean rs2;
            if (sc == pc || pc == '.') {
                rs2 = doIsMatch(s, p, sp1 + 1, pp1);
            } else {
                rs2 = false;
            }
            return rs1 || rs2;
        } else {
            if (sc == pc || pc == '.') {
                return doIsMatch(s, p, sp1 + 1, pp1 + 1);
            } else {
                return false;
            }
        }
    }
}
