package com.zgf.Test.aligorthm.bit;

import java.util.BitSet;

/**
 * @author zgf
 * @date 2021-04-15 上午10:23
 */
public class BitFindRepeatNumber {
    public static void main(String[] args) {
        BitFindRepeatNumber bitFindRepeatNumber = new BitFindRepeatNumber();
        System.out.println(bitFindRepeatNumber.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        BitSet bitSet = new BitSet();

        for (int i = 0; i < nums.length; i++) {
            if (bitSet.get(nums[i])) {
                return nums[i];
            } else {
                bitSet.flip(nums[i]);
            }
        }

        return nums[0];
    }
}
