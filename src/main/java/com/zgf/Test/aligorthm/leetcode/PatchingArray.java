package com.zgf.Test.aligorthm.leetcode;

/**
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 * https://leetcode-cn.com/problems/patching-array/
 */
public class PatchingArray {
    public static void main(String[] args) {
        PatchingArray patchingArray = new PatchingArray();
        int i = patchingArray.minPatches(new int[]{1, 3}, 6);
        System.out.println(i);
        i = patchingArray.minPatches(new int[]{}, 6);
        System.out.println(i);
        i = patchingArray.minPatches(new int[]{1,2,31,33}, 2147483647);
        System.out.println(i);
    }

    public int minPatches(int[] nums, int n) {
        int appendNum = 0;

        int curNum = 1;
        if (curNum == 1 && (nums.length == 0 || nums[0] > 1)) {
            appendNum = 1;
            curNum = 2;
        }

        int index = 0;
        while (curNum <= n) {
            // 判断数组里面是否有满足的数字
            if (index < nums.length && nums[index] <= curNum) {
                curNum += nums[index];
                index++;
            } else {
                if(curNum > Integer.MAX_VALUE / 2) {
                    appendNum++;
                    break;
                }
                curNum *= 2;
//                System.out.println(curNum);
//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                appendNum++;
            }
        }

        return appendNum;
    }
}
