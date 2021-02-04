package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
        System.out.println(searchRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length - 1;
//        int mid = start + (end - start) / 2;
//        // 通过二分法寻找旋转点
//        while (start < end) {
//            if (nums[mid] > nums[start]) {
//                if (nums[mid] > nums[end]) {
//                    // 在左段
//                    start = mid;
//                } else {
//                    end = mid;
//                }
//            } else {
//                end = mid;
//            }
//            mid = start + (end - start) / 2;
//        }
//
//        if (target > nums[0]) {
//            // 左段
//        } else {
//            
//        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
