package com.zgf.Test.aligorthm.slidewin;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class SwFindMaxAverage {
    public static void main(String[] args) {
        SwFindMaxAverage swFindMaxAverage = new SwFindMaxAverage();
        System.out.println(swFindMaxAverage.findMaxAverage(new int[]{4, 2, 1, 3, 3}, 2));
//        System.out.println(swFindMaxAverage.findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
//        System.out.println(swFindMaxAverage.findMaxAverage(new int[]{7, 4, 5, 8, 8, 3, 9, 8, 7, 6}, 7));
//        System.out.println(swFindMaxAverage.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = start + k - 1;
        if (end > nums.length - 1) end = nums.length - 1;

        int sum = 0;
        for (int i = 0; i <= end; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        start++;
        end++;
        for (; end < nums.length; start++, end++) {
            sum = sum + nums[end] - nums[start - 1];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }
}
