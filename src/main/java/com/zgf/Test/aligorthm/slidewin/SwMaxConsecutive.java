package com.zgf.Test.aligorthm.slidewin;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class SwMaxConsecutive {
    public static void main(String[] args) {
        SwMaxConsecutive swMaxConsecutive = new SwMaxConsecutive();
        System.out.println(swMaxConsecutive.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public int longestOnes(int[] A, int K) {
        int curLen = 0;
        int maxLen = 0;
        int start = 0, end = 0;
        int revCount = 0;

        for (; end < A.length; ) {
            if (A[end] == 0) {
                revCount++;
                if (revCount > K) {
                    // 重新计数 - 找到区间左边第一个0
                    while (A[start] != 0 && curLen > 0) {
                        start++;
                        curLen--;
                    }
                    // 跳过0
                    start++;
                    end++;
                    revCount--;
                } else {
                    curLen++;
                    end++;
                    maxLen = Math.max(curLen, maxLen);
                }
            } else {
                curLen++;
                end++;
                maxLen = Math.max(curLen, maxLen);
            }
        }

        return maxLen;
    }
}
