package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] ary = new int[]{11, 2, 13, 41, 99, -1, 0, 5, 16, 7, 81, 9, 10};
        System.out.println(Arrays.toString(ary));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(ary);
        System.out.println(Arrays.toString(ary));
    }

    public static void sort(int[] arr) {
        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        // 2. 大顶堆，堆顶为最大元素，循环将堆顶元素和队尾元素交换，重新构建堆，即可得到排序
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i - 1);
        }
    }

    /**
     * 从第一个节点开始调整
     *
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < length) {
            int target = left;
            if (right < length && arr[right] > arr[left]) {
                target = right;
            }
            if (arr[target] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[target];
                arr[target] = temp;
            }
            adjustHeap(arr, target, length);
        }
    }
}
