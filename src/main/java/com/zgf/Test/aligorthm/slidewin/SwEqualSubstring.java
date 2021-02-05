package com.zgf.Test.aligorthm.slidewin;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 */
public class SwEqualSubstring {
    public static void main(String[] args) {
        SwEqualSubstring swEqualSubstring = new SwEqualSubstring();

        System.out.println(swEqualSubstring.equalSubstring("ctlnkysaguywprybtfcrwfsfw", "tyhxrxiaerrwcxrbfqmrcxkek", 97));
        System.out.println(swEqualSubstring.equalSubstring("pxezla", "loewbi", 25));
        System.out.println(swEqualSubstring.equalSubstring("abcd", "acde", 0));
        System.out.println(swEqualSubstring.equalSubstring("abcd", "bcdf", 3));
    }

    /**
     * 简单的做法，顺序必须相同，使用滑动窗口，超时了
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int[] costAry = new int[s.length()];

        int costSum = 0;
        for (int i = 0, j = 0; j < s.length(); ) {
            int cost = Math.abs(s.charAt(j) - t.charAt(j));
            costAry[j] = cost;
            costSum += cost;

            if (costSum <= maxCost) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
                continue;
            } else {
                // 滑动窗口
                costSum -= costAry[i];
                i++;
                j++;
            }
        }
        return maxLen;
    }
}
