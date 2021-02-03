package com.zgf.Test.aligorthm.slidewin;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sliding-window-median/
 * <p>
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 */
public class SwMedianSlidingWindow {
    public static void main(String[] args) {
        SwMedianSlidingWindow swMedianSlidingWindow = new SwMedianSlidingWindow();
        System.out.println(Arrays.toString(swMedianSlidingWindow.medianSlidingWindow(new int[]{2147483647,2147483647}, 2)));
        System.out.println(Arrays.toString(swMedianSlidingWindow.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4)));
//        System.out.println(Arrays.toString(swMedianSlidingWindow.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int[] ary = new int[k];
        // 初始化
        for (int i = 0; i < k; i++) {
            ary[i] = nums[i];
        }
        Arrays.sort(ary);
        System.out.println(Arrays.toString(ary));

        double[] result = new double[nums.length - k + 1];
        int idx = 0;
        result[idx] = mid(ary);

        int i = 1, j = i + k - 1;
        for (; j < nums.length; i++, j++) {
            remove(ary, nums[i - 1]);
            add(ary, nums[j]);
            System.out.println(Arrays.toString(ary));
            idx++;
            result[idx] = mid(ary);
        }
        return result;
    }

    private void remove(int[] ary, int x) {
        int start = 0;
        int end = ary.length;
        int mid = start + (end - start) / 2;
        while (ary[mid] != x) {
            if (ary[mid] < x) {
                start = mid + 1;
                mid = start + (end - start) / 2;
            } else {
                end = mid - 1;
                mid = start + (end - start) / 2;
            }
        }

        for (int i = mid; i < ary.length - 1; i++) {
            ary[i] = ary[i + 1];
        }
    }

    private void add(int[] ary, int x) {
        int start = 0;
        for (; start < ary.length - 1; start++) {
            if (ary[start] < x) {
                continue;
            }
            break;
        }

        for (int i = ary.length - 1; i > start; i--) {
            ary[i] = ary[i - 1];
        }
        ary[start] = x;
    }

    /**
     * 计算中位数
     *
     * @param ary
     * @return
     */
    private double mid(int[] ary) {
        int size = ary.length;
        if (size % 2 == 0) {
            // 偶数
            int mid1 = size / 2;
            int mid2 = mid1 - 1;
            return (Double.valueOf(ary[mid1]) + Double.valueOf(ary[mid2])) / 2;
        } else {
            // 奇数
            int mid = size / 2;
            return ary[mid];
        }
    }
}
