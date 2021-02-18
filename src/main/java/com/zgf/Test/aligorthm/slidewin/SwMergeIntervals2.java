package com.zgf.Test.aligorthm.slidewin;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/insert-interval/
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class SwMergeIntervals2 {
    public static void main(String[] args) {
        SwMergeIntervals2 swMergeIntervals = new SwMergeIntervals2();
        System.out.println(JSON.toJSONString(swMergeIntervals.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        boolean startMerge = false;
        boolean newInsert = false;
        for (int i = 0; i < intervals.length; i++) {
            // 判断区间是否相交
            int x1 = intervals[i][0];
            int y1 = intervals[i][1];
            if (x1 > end || y1 < start) {
                if (startMerge && !newInsert) {
                    result.add(new int[]{start, end});
                    newInsert = true;
                }
                result.add(intervals[i]);
            } else {
                startMerge = true;
                start = Math.min(start, x1);
                end = Math.max(end, y1);
            }
        }

        if (!newInsert) {
            result.add(new int[]{start, end});
        }


        int[][] rs = new int[result.size()][];
        return result.toArray(rs);
    }
}
