package com.zgf.Test.aligorthm.twopoint;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 */
public class TpJumpGame {
    public static void main(String[] args) {
        TpJumpGame tpJumpGame = new TpJumpGame();
        System.out.println(tpJumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(tpJumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int i = 0;
        int len = nums.length - 1;
        int maxArea = 0;

        for (; i <= maxArea; ) {
            maxArea = Math.max(i + nums[i], maxArea);
            if (maxArea >= len) {
                return true;
            }
            i++;
        }
        return false;
    }
}
