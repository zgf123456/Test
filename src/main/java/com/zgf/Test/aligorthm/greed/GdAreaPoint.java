package com.zgf.Test.aligorthm.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间取点
 * 输入：
 * <p>
 * n个闭区间，
 * <p>
 * 输出：
 * <p>
 * 最少用几个点，把每个区间都包含一个点
 */
public class GdAreaPoint {
    public static void main(String[] args) {
        GdAreaPoint gdAreaPoint = new GdAreaPoint();
        System.out.println(gdAreaPoint.findPoint(new int[][]{{1, 4}, {0, 3}, {2, 4}, {5, 7}}));
    }

    /**
     * 思路，按右边的点排序
     *
     * @param ints
     * @return
     */
    private int findPoint(int[][] ints) {
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int sum = 1;
        int rightPoint = ints[0][1];

        for (int i = 1; i < ints.length; i++) {
            if (ints[i][0] <= rightPoint) {
                continue;
            } else {
                sum++;
                rightPoint = ints[i][1];
            }
        }

        return sum;
    }
}
