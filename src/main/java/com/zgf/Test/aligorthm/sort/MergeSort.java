package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] ary = new int[]{11, 2, 13, 41, 99, -1, 0, 5, 16, 7, 81, 9, 10};
        System.out.println(Arrays.toString(ary));
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ary);
        System.out.println(Arrays.toString(ary));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param start
     * @param end
     * @param temp
     */
    private static void sort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(arr, start, mid, temp);
            sort(arr, mid + 1, end, temp);
            // 合并
            merge(arr, start, mid, end, temp);
        }
    }

    /**
     * 合并两个区间排序
     *
     * @param arr
     * @param start
     * @param mid
     * @param end
     * @param temp
     */
    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int leftIdx = start;
        int rightIdx = mid + 1;
        int tempIdx = 0;
        while (leftIdx <= mid && rightIdx <= end) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                temp[tempIdx] = arr[leftIdx];
                leftIdx++;
                tempIdx++;
            } else {
                temp[tempIdx] = arr[rightIdx];
                rightIdx++;
                tempIdx++;
            }
        }

        while (leftIdx <= mid) {
            temp[tempIdx] = arr[leftIdx];
            leftIdx++;
            tempIdx++;
        }
        while (rightIdx <= end) {
            temp[tempIdx] = arr[rightIdx];
            rightIdx++;
            tempIdx++;
        }

        // 将数据拷贝回原数组
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }
}
