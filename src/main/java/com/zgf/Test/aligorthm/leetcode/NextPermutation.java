package com.zgf.Test.aligorthm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * <p>
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] ints = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * 1. 从右往左找值比左边大的值
     * 2. 控制交换地点尽可能在右边
     * 3. 将交换点右边的进行重排序
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int changeX = -1;
        int changeY = -1;
        for (int i = length - 1; i >= 0 && i > changeX; i--) {
            for (int j = i - 1; j >= 0 && j > changeX; j--) {
                if (nums[i] > nums[j]) {
                    changeX = j;
                    changeY = i;
                    break;
                }
            }
        }

        if (changeX != -1) {
            int temp = nums[changeX];
            nums[changeX] = nums[changeY];
            nums[changeY] = temp;
            Arrays.sort(nums, changeX + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}
