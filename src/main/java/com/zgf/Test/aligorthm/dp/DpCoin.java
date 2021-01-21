package com.zgf.Test.aligorthm.dp;

import java.util.HashMap;

/**
 * 硬币找零问题
 * 先看下题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 */
public class DpCoin {
    public static void main(String[] args) {
        DpCoin dpCoin = new DpCoin();
        int[] coins = new int[]{1, 2, 5, 10};
        System.out.println("============11111=============");
        System.out.println(dpCoin.coinChange(coins, 10));
        System.out.println(dpCoin.coinChange(coins, 11));
        System.out.println(dpCoin.coinChange(coins, 12));
        System.out.println(dpCoin.coinChange(coins, 13));
        System.out.println(dpCoin.coinChange(coins, 14));
        System.out.println(dpCoin.coinChange(coins, 15));
        System.out.println(dpCoin.coinChange(coins, 16));
        System.out.println(dpCoin.coinChange(coins, 17));
        System.out.println(dpCoin.coinChange(coins, 18));
        System.out.println(dpCoin.coinChange(coins, 19));
        System.out.println(dpCoin.coinChange(coins, 20));

        System.out.println("============22222=============");
        System.out.println(dpCoin.coinChange2(coins, 10));
        System.out.println(dpCoin.coinChange2(coins, 11));
        System.out.println(dpCoin.coinChange2(coins, 12));
        System.out.println(dpCoin.coinChange2(coins, 13));
        System.out.println(dpCoin.coinChange2(coins, 14));
        System.out.println(dpCoin.coinChange2(coins, 15));
        System.out.println(dpCoin.coinChange2(coins, 16));
        System.out.println(dpCoin.coinChange2(coins, 17));
        System.out.println(dpCoin.coinChange2(coins, 18));
        System.out.println(dpCoin.coinChange2(coins, 19));
        System.out.println(dpCoin.coinChange2(coins, 20));

        System.out.println("============33333=============");
        System.out.println(dpCoin.coinChange3(coins, 10));
        System.out.println(dpCoin.coinChange3(coins, 11));
        System.out.println(dpCoin.coinChange3(coins, 12));
        System.out.println(dpCoin.coinChange3(coins, 13));
        System.out.println(dpCoin.coinChange3(coins, 14));
        System.out.println(dpCoin.coinChange3(coins, 15));
        System.out.println(dpCoin.coinChange3(coins, 16));
        System.out.println(dpCoin.coinChange3(coins, 17));
        System.out.println(dpCoin.coinChange3(coins, 18));
        System.out.println(dpCoin.coinChange3(coins, 19));
        System.out.println(dpCoin.coinChange3(coins, 20));
    }

    /**
     * 1. 递归的解法，自顶向下
     *
     * @param coins
     * @param amount
     * @return
     */
    int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        // 自顶向下
        int minCoin = -1;
        for (int i = 0; i < coins.length; i++) {
            // 状态转移方程，自顶向下，递归
            int ccNum = coinChange(coins, amount - coins[i]);
            if (ccNum != -1) {
                if (minCoin == -1) {
                    minCoin = ccNum + 1;
                } else {
                    minCoin = Math.min(minCoin, ccNum + 1);
                }
            }
        }
        return minCoin;
    }

    /**
     * 2. 添加备忘录，减少运算
     *
     * @param coins
     * @param amount
     * @return
     */
    int coinChange2(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        HashMap<Integer, Integer> dpMap = new HashMap<Integer, Integer>();
        dpMap.put(0, 0);
        return doCoinChange2(coins, amount, dpMap);
    }

    int doCoinChange2(int[] coins, int amount, HashMap<Integer, Integer> dpMap) {
        if (dpMap.get(amount) != null) return dpMap.get(amount);

        int minCoin = -1;
        for (int i = 0; i < coins.length; i++) {
            // 状态转移方程，自顶向下，递归
            int ccNum = coinChange(coins, amount - coins[i]);
            if (ccNum != -1) {
                if (minCoin == -1) {
                    minCoin = ccNum + 1;
                } else {
                    minCoin = Math.min(minCoin, ccNum + 1);
                }
            }
        }
        dpMap.put(amount, minCoin);
        return minCoin;
    }

    /**
     * 3. 自底向上
     *
     * @param coins
     * @param amount
     * @return
     */
    int coinChange3(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dpTable = new int[amount + 1];
        dpTable[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 计算每一个金额最少的硬币数
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                // 计算每一种硬币的最少数量
                int subProblom = i - coins[j];
                if (subProblom < 0) continue; // 无解
                if (dpTable[subProblom] == -1) continue; // 无解

                if (min == -1) {
                    min = dpTable[subProblom] + 1;
                } else {
                    min = Math.min(min, dpTable[subProblom] + 1);
                }
            }
            dpTable[i] = min;
        }
        return dpTable[amount];
    }
}
