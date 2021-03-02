package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] ary = new int[]{11, 2, 13, 41, 99, -1, 0, 5, 16, 7, 81, 9, 10};
        System.out.println(Arrays.toString(ary));
        MaoPaoSort maoPaoSort = new MaoPaoSort();
        maoPaoSort.sort(ary);
        System.out.println(Arrays.toString(ary));
    }

    /**
     * 冒泡排序思路
     * 每次比较相邻两个，将大的沉底，这样每次循环后，内循环会减少一次查询，当某次循环没有发生交换时，则是有序，提前结束
     *
     * @param ary
     */
    private void sort(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            // 用于判断提前结束
            boolean swap = false;
            // 每一个循环，沉底一个最大数
            for (int j = 0; j < ary.length - i - 1; j++) {
                if (ary[j] > ary[j + 1]) {
                    // 下沉
                    int temp = ary[j];
                    ary[j] = ary[j + 1];
                    ary[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }
}
