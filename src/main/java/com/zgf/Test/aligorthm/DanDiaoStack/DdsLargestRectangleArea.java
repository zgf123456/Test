package com.zgf.Test.aligorthm.DanDiaoStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class DdsLargestRectangleArea {
    public static void main(String[] args) {
        DdsLargestRectangleArea ddsLargestRectangleArea = new DdsLargestRectangleArea();
        System.out.println(ddsLargestRectangleArea.largestRectangleArea(new int[]{1, 1}));
        System.out.println(ddsLargestRectangleArea.largestRectangleArea(new int[]{2, 4}));
        System.out.println(ddsLargestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    /**
     * 思路
     * 1. 找到左右两边第一个小于自身的高度，利用单调递增栈
     * 2. 因为计算面积需要宽度，所以将数组下标入栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }
}
