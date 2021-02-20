package com.zgf.Test.aligorthm.twopoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class TpFindShortestSubArray {
    public static void main(String[] args) {
        TpFindShortestSubArray tpFindShortestSubArray = new TpFindShortestSubArray();
        System.out.println(tpFindShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(tpFindShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    /**
     * 遍历数组，记录每个数字的最大度数和左右边界
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        // 计算最大的度
        int maxNumCount = 0;
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numCount = numCountMap.getOrDefault(nums[i], 0) + 1;
            maxNumCount = Math.max(maxNumCount, numCount);
            numCountMap.put(nums[i], numCount);
            if (!leftMap.containsKey(nums[i])) {
                leftMap.put(nums[i], i);
            }
            rightMap.put(nums[i], i);
        }

        /**
         * 比较每个最大度数的长度
         */
        int minLen = nums.length;
        Set<Map.Entry<Integer, Integer>> entries = numCountMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == maxNumCount) {
                minLen = Math.min(minLen, rightMap.get(entry.getKey()) - leftMap.get(entry.getKey()) + 1);
            }
        }
        return minLen;
    }
}
