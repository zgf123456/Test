package com.zgf.Test.aligorthm.bit;

/**
 * @author zgf
 * @date 2021-04-08 下午1:44
 */
public class BitCount {
    public static void main(String[] args) {
        BitCount bitCount = new BitCount();
        // 求一个数中1的个数
        System.out.println(bitCount.getNumOf_1(100));
        // 获取只出现一次的数
        System.out.println(bitCount.getOnceNum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    /**
     * 求一个数中1的个数
     *
     * @param i
     * @return
     */
    private int getNumOf_1(int i) {
        int num = 0;
        while (i != 0) {
            // 原理就是利用 i & (i-1)，每次操作都会使最后一个1变成0
            // 比如
            // 10101000 原数
            // 10100111 减1
            // 10100000 与操作后
            i = i & (i - 1);
            num++;
        }
        return num;
    }


    /**
     * 获取只出现一次的数，其他数出现两次，数都>0
     * 利用异或操作
     *
     * @param nums
     * @return
     */
    private int getOnceNum(int[] nums) {
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value ^= nums[i];
        }
        return value;
    }
}
