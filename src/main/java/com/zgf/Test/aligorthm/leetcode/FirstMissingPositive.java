package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
        }
        return 1;
    }
}
