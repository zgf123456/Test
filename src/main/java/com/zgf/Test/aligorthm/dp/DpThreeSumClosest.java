package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 非DP
 */
public class DpThreeSumClosest {
    public static void main(String[] args) {
        DpThreeSumClosest dpThreeSumClosest = new DpThreeSumClosest();
        System.out.println(dpThreeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];

        int min = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int sub = Math.abs(target - sum);
                    if (sub < min) {
                        min = sub;
                        minSum = sum;
                    }
                }
            }
        }
        return minSum;
    }

}
