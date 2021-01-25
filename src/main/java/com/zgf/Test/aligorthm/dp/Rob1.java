package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Rob1 {
    public static void main(String[] args) {
        Rob1 rob1 = new Rob1();
        System.out.println(rob1.rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob1.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob1.rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 备忘录 - 解决重复计算
        int[] dbTable = new int[nums.length];
        for (int i = 0; i < dbTable.length; i++) {
            dbTable[i] = -1;
        }
        return doRob(nums, 0, dbTable);
    }

    private int doRob(int[] nums, int i, int[] dbTable) {
        if (i >= nums.length) return 0;
        if (dbTable[i] > -1) return dbTable[i];

        // 状态转移方程
        int length = nums.length;
        int lessN = length - i;

        // dp状态转移方程
        // 如果只剩一间屋子 base case
        if (lessN == 1) {
            return nums[i];
        } else {
            // dp状态转移方程，当前房间偷或不偷 -- 第一个手动写出
            int max = Math.max(nums[i] + doRob(nums, i + 2, dbTable), 0 + doRob(nums, i + 1, dbTable));
            dbTable[i] = max;
            return max;
        }
    }
}
