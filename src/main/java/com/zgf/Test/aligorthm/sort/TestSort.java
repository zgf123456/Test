package com.zgf.Test.aligorthm.sort;

import java.util.Arrays;

/**
 * Created by zgf on 16/11/26.
 */
public class TestSort {
    public static void main(String[] args) {
        int[] ary = new int[]{11, 2, 13, 41, 99, -1, 0, 5, 16, 7, 81, 9, 10};
        System.out.println(Arrays.toString(ary));
        FastSort.sort(ary);
        System.out.println(Arrays.toString(ary));
    }
}
