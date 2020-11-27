package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

public class FastSort {
    public static void sort(int[] ary) {
        doFastSort(ary, 0, ary.length - 1);
    }

    public static void doFastSort(int[] ary, int start, int end) {
        System.out.println(Arrays.toString(ary) + ",start=" + start + ",end=" + end);
        if (start >= end) {
            return;
        }

        if (end - start == 1) {
            if (ary[start] > ary[end]) {
                swap(ary, start, end);
            }
            return;
        }

        int flagValue = ary[start];
        int flagIndex = start;
        int st = start + 1;
        int ed = end;
        while (st < ed) {
            while (ary[ed] > flagValue && st < end) {
                ed--;
            }

            if (ary[ed] < flagValue && ed > flagIndex) {
                swap(ary, flagIndex, ed);
                flagIndex = ed;
            }

            while (ary[st] < flagValue && st < end) {
                st++;
            }

            if (ary[st] > flagValue && st < flagIndex) {
                swap(ary, flagIndex, st);
                flagIndex = st;
            }

        }

        ary[flagIndex] = flagValue;
        // 递归
        doFastSort(ary, start, flagIndex - 1);
        doFastSort(ary, flagIndex + 1, end);
        return;
    }

    public static void swap(int[] ary, int a, int b) {
        int v = ary[a];
        ary[a] = ary[b];
        ary[b] = v;
    }
}
