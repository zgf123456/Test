package com.zgf.Test.aligorthm.dp;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 */
public class DpBurstBalloon {
    public static void main(String[] args) {
        DpBurstBalloon dpBurstBalloon = new DpBurstBalloon();
//        System.out.println(dpBurstBalloon.maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(dpBurstBalloon.maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5}));
    }

    public int maxCoins(int[] nums) {
        // 扩展数组，将前后都置为1
        int[] numPlus = new int[nums.length + 2];
        numPlus[0] = numPlus[numPlus.length - 1] = 1;
        for (int i = 1; i < (numPlus.length - 1); i++) {
            numPlus[i] = nums[i - 1];
        }

        // 正向思路，戳破气球后，气球的位置一直在变化，没法计算
        // 逆向思路，从i~j开区间中，选择第k个最后戳破，则此时获取的硬币数为 num[i]*num[j]*num[k]
        int[][] dpTable = new int[numPlus.length][numPlus.length];
        for (int i = 0; i < dpTable.length; i++) {
            for (int j = 0; j < dpTable[i].length; j++) {
                dpTable[i][j] = -1;
            }
        }

        return doGetMaxCoins(numPlus, 0, numPlus.length - 1, dpTable);
    }

    private int doGetMaxCoins(int[] numPlus, int i, int j, int[][] dpTable) {
        // 备忘录
        if (dpTable[i][j] != -1) {
            return dpTable[i][j];
        }

        int max = 0;
        for (int k = i + 1; k < j; k++) {
            // 状态转移
            int coins = numPlus[i] * numPlus[j] * numPlus[k] + doGetMaxCoins(numPlus, i, k, dpTable) + doGetMaxCoins(numPlus, k, j, dpTable);
            max = Math.max(max, coins);
        }
        dpTable[i][j] = max;
        return max;
    }
}
