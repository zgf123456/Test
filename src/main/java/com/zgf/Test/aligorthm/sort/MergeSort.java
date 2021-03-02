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

    /**
     * 思路，利用临时数组
     *
     * @param ary
     */
    private void sort(int[] ary) {
        int[] temp = new int[ary.length];
        doMergeSort(ary, 0, ary.length - 1, temp);
    }

    private void doMergeSort(int[] ary, int start, int end, int[] temp) {
        if (end <= start) {
            return;
        }
        // 分割
        int mid = start + (end - start) / 2;
        doMergeSort(ary, start, mid, temp);
        doMergeSort(ary, mid + 1, end, temp);
        merge(ary, start, mid, end, temp);
    }

    /**
     * 合并
     *
     * @param ary
     * @param start
     * @param mid
     * @param end
     * @param temp
     */
    private void merge(int[] ary, int start, int mid, int end, int[] temp) {
        int tempIdx = 0;
        int leftIdx = start;
        int rightIdx = mid + 1;
        while (leftIdx <= mid && rightIdx <= end) {
            if (ary[leftIdx] < ary[rightIdx]) {
                temp[tempIdx] = ary[leftIdx];
                leftIdx++;
            } else {
                temp[tempIdx] = ary[rightIdx];
                rightIdx++;
            }
            tempIdx++;
        }

        while (leftIdx <= mid) {
            temp[tempIdx] = ary[leftIdx];
            leftIdx++;
            tempIdx++;
        }

        while (rightIdx <= end) {
            temp[tempIdx] = ary[rightIdx];
            rightIdx++;
            tempIdx++;
        }

        // 复制回原数组
        for (int i = start; i <= end; i++) {
            ary[i] = temp[i - start];
        }
    }
}
