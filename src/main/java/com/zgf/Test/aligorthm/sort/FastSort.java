package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

public class FastSort {

    public static void main(String[] args) {
        int[] ary = new int[]{11, 2, 13, 41, 99, -1, 0, 5, 16, 7, 81, 9, 10};
        System.out.println(Arrays.toString(ary));
        FastSort fastSort = new FastSort();
        fastSort.sort(ary);
        System.out.println(Arrays.toString(ary));
    }

    private void sort(int[] ary) {
        doFastSort(ary, 0, ary.length - 1);
    }

    /**
     * @param ary
     * @param start
     * @param end
     */
    private void doFastSort(int[] ary, int start, int end) {
        if (end <= start) {
            return;
        }

        int low = start;
        int high = end;
        int midValue = ary[low];
        boolean flag = true; // 默认低位为标识位，从高位开始排查
        while (true) {
            if (flag) {
                if (ary[high] < midValue) {
                    ary[low] = ary[high];
                    low++;
                    flag = false;
                } else {
                    high--;
                }
            } else {
                if (ary[low] > midValue) {
                    ary[high] = ary[low];
                    high--;
                    flag = true;
                } else {
                    low++;
                }
            }
            if (low == high) {
                break;
            }
        }
        ary[low] = midValue;
        doFastSort(ary, start, low);
        doFastSort(ary, low + 1, end);
    }
}
