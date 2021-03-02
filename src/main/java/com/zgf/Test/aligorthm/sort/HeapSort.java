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

    /**
     * 从某个节点，递归往下调整
     *
     * @param ary
     */
    private void sort(int[] ary) {
        // 从最后一个非叶子节点开始，构建大顶堆
        for (int i = ary.length / 2; i >= 0; i--) {
            doHeadSort(ary, i, ary.length);
        }

        // 循环将队首元素，与队尾元素交换
        int temp;
        for (int i = ary.length - 1; i >= 0; i--) {
            temp = ary[i];
            ary[i] = ary[0];
            ary[0] = temp;
            doHeadSort(ary, 0, i - 1);
        }
    }

    private void doHeadSort(int[] ary, int i, int end) {
        int left = i * 2 + 1;
        int right = left + 1;
        int k = left;
        if (left < end) {
            if (right < end && ary[right] > ary[left]) {
                k = right;
            }

            // 交换父子节点
            if (ary[k] > ary[i]) {
                int temp = ary[k];
                ary[k] = ary[i];
                ary[i] = temp;
                // 递归调整子节点
                doHeadSort(ary, k, end);
            }
        }
    }
}
