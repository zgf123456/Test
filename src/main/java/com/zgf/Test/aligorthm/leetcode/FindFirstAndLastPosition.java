package com.zgf.Test.aligorthm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        FindFirstAndLastPosition findFirstAndLastPosition = new FindFirstAndLastPosition();
//        System.out.println(Arrays.toString(findFirstAndLastPosition.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(findFirstAndLastPosition.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
//        System.out.println(Arrays.toString(findFirstAndLastPosition.searchRange(new int[]{5}, 6)));
//        System.out.println(Arrays.toString(findFirstAndLastPosition.searchRange(new int[]{}, 6)));
//        System.out.println(Arrays.toString(findFirstAndLastPosition.searchRange(new int[]{1,2,3}, 3)));
        System.out.println(Arrays.toString(findFirstAndLastPosition.searchRange(new int[]{2, 2}, 3)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int min = 0;
        int max = nums.length - 1;
        int mid = nums.length / 2;
        // 二分
        for (; ; ) {
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                min = mid + 1 > max ? max : mid + 1;
                mid = (max + min) / 2;
            } else {
                max = mid - 1 < min ? min : mid - 1;
                mid = (max + min) / 2;
            }
            if (min == max) {
                break;
            }
        }

        if (nums[mid] == target) {
            int i = mid, j = mid;
            for (; i >= 0; i--) {
                if (nums[i] != target) break;
            }
            for (; j < nums.length; j++) {
                if (nums[j] != target) break;
            }
            return new int[]{i + 1, j - 1};
        } else {
            return new int[]{-1, -1};
        }
    }
}
