package com.zgf.Test.aligorthm.slidewin;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/comments/
 * <p>
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 * <p>
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 */
public class SwMinKBitFlips {
    public static void main(String[] args) {
        SwMinKBitFlips swMinKBitFlips = new SwMinKBitFlips();
        System.out.println(swMinKBitFlips.minKBitFlips(new int[]{0, 1, 0}, 1));
    }

    /**
     * 暴力解法，遇到每个需要翻转的计数，同时更新后续K-1个数的翻转次数
     *
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        int[] countAry = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            boolean isChange = false;
            if (countAry[i] > 0 && countAry[i] % 2 == 1) {
                isChange = true;
            }

            if ((A[i] == 0 && !isChange) || (A[i] == 1 && isChange)) {
                // 需要翻转
                count++;
                for (int j = 1; j < K; j++) {
                    if (i + j >= A.length) return -1;
                    countAry[i + j] += 1;
                }
            }
        }
        return count;
    }
}
