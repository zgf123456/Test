package com.zgf.Test.aligorthm.slidewin;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class SwMergeIntervals {
    public static void main(String[] args) {
        SwMergeIntervals swMergeIntervals = new SwMergeIntervals();
        System.out.println(JSON.toJSONString(swMergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> result = new ArrayList<>();
        int area = -1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; ) {
            if (area == -1) {
                start = intervals[i][0];
                end = intervals[i][1];
                area = 0;
                i++;
                continue;
            }

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            } else {
                result.add(new int[]{start, end});
                area = -1;
            }
        }
        if (area == 0) {
            result.add(new int[]{start, end});
        }

        int[][] rs = new int[result.size()][];
        return result.toArray(rs);
    }
}
