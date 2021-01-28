package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));
    }

    /**
     * 记录法解决 - 额外空间
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;

        // 思路 nums.length = N
        // N个数表示 1 ~ N 的区间，最刚好的情况是nums里面全是1~N的数据，且不重复
        int[] ary = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                // 非法数字
                continue;
            }
            ary[nums[i]] += nums[i];
        }

        for (int i = 1; i < ary.length; i++) {
            if (ary[i] == 0) {
                return i;
            }
        }
        return ary.length;
    }
}
