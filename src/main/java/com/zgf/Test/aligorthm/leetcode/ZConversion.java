package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 */
public class ZConversion {

    public static void main(String[] args) {
        ZConversion zConversion = new ZConversion();
//        System.out.println(zConversion.convert("LEETCODEISHIRING", 3)); // "LCIRETOESIIGEDHN"
//        System.out.println(zConversion.convert("LEETCODEISHIRING", 4)); // "LDREOEIIECIHNTSG"
//        System.out.println(zConversion.convert("ABCDE", 4)); // "ABCED"
        System.out.println(zConversion.convert("ABCDEF", 5)); // "ABCDFE"
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len < numRows) {
            return s;
        }

        if (numRows <= 1) {
            return s;
        }

        int padLen = (numRows - 1) + (numRows - 2);
        int col = (len + numRows - 2) / (numRows + numRows - 2);
        int midPadLen = padLen;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int colIdx = col;
            for (int j = i; j < len; ) {
                sb.append(s.charAt(j));
                if (i > 0 && i < (numRows - 1) && colIdx > 0) {
                    int idx = j + midPadLen + 1;
                    if (idx < len) {
                        sb.append(s.charAt(j + midPadLen + 1));
                    }
                }
                colIdx--;
                j = j + padLen + 1;
            }
            midPadLen = midPadLen - 2;
        }
        return sb.toString();
    }
}
