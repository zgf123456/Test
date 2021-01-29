package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {
    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap.trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(trap.trap(new int[]{1, 2, 0, 3, 2, 5}));
    }

    /**
     * 思路  找到当前柱子，左右两边最高的柱子, 当前柱子可接雨水 = Min(left, right) - height; 小于等于0表示不能接
     * @param height
     * @return
     */
    public int trap(int[] height) {
            if (height.length < 3) return 0;
            int maxLeft = height[0];
            int maxRightIdx = -1;
            int maxRight = 0;
            int sum = 0;

            for (int i = 1; i < height.length - 1; i++) {
                // 找左边最大值
                if (maxLeft == 0) {
                    maxLeft = height[i];
                    continue;
                }
                if (height[i] >= maxLeft) {
                    maxLeft = height[i];
                    continue;
                }

                // 找右边相对大值m
                if (maxRightIdx != -1 && i < maxRightIdx) {
                    // 可接雨水
                    sum += Math.min(maxLeft, height[maxRightIdx]) - height[i];
                } else {
                    // 寻找右边最高，且不能比当前的低
                    maxRightIdx = -1;
                    maxRight = 0;
                    for (int j = i + 1; j < height.length; j++) {
                        if (height[j] >= maxRight && height[j] >= height[i]) {
                            maxRight = height[j];
                            maxRightIdx = j;
                        }
                    }
                    if (maxRightIdx != -1) {
                        sum += Math.min(maxLeft, height[maxRightIdx]) - height[i];
                    }
                }
            }
            return sum;
    }
}
