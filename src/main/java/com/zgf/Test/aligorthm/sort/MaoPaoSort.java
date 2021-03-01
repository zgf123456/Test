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
        //冒泡
        for (int i = 0; i < ary.length; i++) {
            //外层循环，遍历次数
            boolean swap = false;
            for (int j = 0; j < ary.length - i - 1; j++) {
                // 大数沉底
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (ary[j] > ary[j + 1]) {
                    int temp = ary[j + 1];
                    ary[j + 1] = ary[j];
                    ary[j] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }
}
