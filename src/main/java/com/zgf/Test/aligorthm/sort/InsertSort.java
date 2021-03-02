package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ary = new int[]{11, 2, 13, 41, 99, -1, 0, 5, 16, 7, 81, 9, 10};
        System.out.println(Arrays.toString(ary));
        InsertSort insertSort = new InsertSort();
//        insertSort.sort(ary);
        insertSort.sehllSort(ary);
        System.out.println(Arrays.toString(ary));
    }

    /**
     * 默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出
     * 冒泡排序的倒过来？？
     *
     * @param arr
     */
    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序，插入排序的变种
     * 添加步长的概念，逐渐递减步长，最后一次为1
     *
     * @param arr
     */
    private void sehllSort(int[] arr) {
        //希尔排序（插入排序变种版）
        // 步长
        for (int i = arr.length / 2; i > 0; i = i / 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k >= i; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k];
                        arr[k] = arr[k - i];
                        arr[k - i] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
