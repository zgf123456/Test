package com.zgf.Test.aligorthm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 直接3个循环，非回溯
 */
public class BfsThreeSum {
    public static void main(String[] args) {
        BfsThreeSum bfsThreeSum = new BfsThreeSum();
        System.out.println(bfsThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        System.out.println(bfsThreeSum.threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println(bfsThreeSum.threeSum(new int[]{1, 2, -2, -1}));
        System.out.println(bfsThreeSum.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(bfsThreeSum.threeSum(new int[]{1, 1, -2}));
        System.out.println(bfsThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(bfsThreeSum.threeSum(new int[]{1, 1, 1}));
        System.out.println(bfsThreeSum.threeSum(new int[]{5, -9, -11, 9, 9, -4, 14, 10, -11, 1, -13, 11, 10, 14, -3, -3, -4, 6, -15, 6, 6, -13, 7, -11, -15, 10, -8, 13, -14, -12, 12, 6, -6, 8, 0, 10, -11, -8, -2, -6, 8, 0, 12, 3, -9, -6, 8, 3, -15, 0, -6, -1, 3, 9, -5, -5, 4, 2, -15, -3, 5, 13, -11, 7, 6, -4, 2, 11, -5, 7, 12, -11, -15, 1, -1, -9, 10, -8, 1, 2, 8, 11, -14, -4, -3, -12, -2, 8, 5, -1, -9, -4, -3, -13, -12, -12, -10, -3, 6, 1, 12, 3, -3, 12, 11, 11, 10}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        ArrayList<List<Integer>> allResult = new ArrayList<>();
        // 先排序，有助于减少计算量
//        this.sort(nums);
        Arrays.sort(nums);

        // 优化解法
        int tempSum2;
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; // 终止后续不合法计算
            if (k > 0 && nums[k - 1] == nums[k]) continue; // 跳过重复元素

            for (int i = k + 1; i < nums.length - 1; i++) {
                tempSum2 = nums[k] + nums[i];
                if (tempSum2 > 0) break; // 终止后续不合法计算
                if (i > k + 1 && nums[i - 1] == nums[i]) continue; // 跳过重复元素

                // 通过二分法快速定位
                int start = i + 1;
                int last = nums.length - 1;
                while (start <= last) {
                    int mid = start + (last - start) / 2;
                    int tempSumMid = nums[mid] + tempSum2;
                    if (tempSumMid == 0) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[mid]);
                        result.add(nums[k]);
                        allResult.add(result);
                        break;
                    } else if (tempSumMid > 0) {
                        last = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return allResult;
    }

//    public void sort(int[] nums) {
//        // 简单排序，将负数和正数分开
//        int i = 0, j = nums.length - 1;
//        while (i < j) {
//            while (i < j && nums[i] < 0) {
//                i++;
//            }
//            while (i < j && nums[j] > 0) {
//                j--;
//            }
//
//            if (i < j) {
//                // 交换
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                i++;
//                j--;
//            }
//        }
//    }
}
