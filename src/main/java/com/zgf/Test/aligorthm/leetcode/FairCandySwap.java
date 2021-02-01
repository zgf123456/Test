package com.zgf.Test.aligorthm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class FairCandySwap {
    public static void main(String[] args) {
        FairCandySwap fairCandySwap = new FairCandySwap();
        System.out.println(Arrays.toString(fairCandySwap.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }

        int sub = sumA - sumB;
        int midSub = sub / 2;
        if (midSub == 0) return new int[]{};

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == midSub) {
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return new int[]{};
    }
}
