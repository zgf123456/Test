package com.zgf.Test.aligorthm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * <p>
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int i;
//        i = nonOverlappingIntervals.eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});
//        i = nonOverlappingIntervals.eraseOverlapIntervals(new int[][]{{-2, 42}, {-1, 49}, {0, 7}, {1, 104}, {2, 79}, {3, 37}, {4, 47}, {5, 69}, {6, 89}, {7, 110}, {8, 108}, {9, 19}});
        i = nonOverlappingIntervals.eraseOverlapIntervals(new int[][]{{-100, -87}, {-99, -44}, {-98, -19}, {-97, -33}, {-96, -60}, {-95, -17}, {-94, -44}, {-93, -9}, {-92, -63}, {-91, -76}, {-90, -44}, {-89, -18}, {-88, 10}, {-87, -39}, {-86, 7}, {-85, -76}, {-84, -51}, {-83, -48}, {-82, -36}, {-81, -63}, {-80, -71}, {-79, -4}, {-78, -63}, {-77, -14}, {-76, -10}, {-75, -36}, {-74, 31}, {-73, 11}, {-72, -50}, {-71, -30}, {-70, 33}, {-69, -37}, {-68, -50}, {-67, 6}, {-66, -50}, {-65, -26}, {-64, 21}, {-63, -8}, {-62, 23}, {-61, -34}, {-60, 13}, {-59, 19}, {-58, 41}, {-57, -15}, {-56, 35}, {-55, -4}, {-54, -20}, {-53, 44}, {-52, 48}, {-51, 12}, {-50, -43}, {-49, 10}, {-48, -34}, {-47, 3}, {-46, 28}, {-45, 51}, {-44, -14}, {-43, 59}, {-42, -6}, {-41, -32}, {-40, -12}, {-39, 33}, {-38, 17}, {-37, -7}, {-36, -29}, {-35, 24}, {-34, 49}, {-33, -19}, {-32, 2}, {-31, 8}, {-30, 74}, {-29, 58}, {-28, 13}, {-27, -8}, {-26, 45}, {-25, -5}, {-24, 45}, {-23, 19}, {-22, 9}, {-21, 54}, {-20, 1}, {-19, 81}, {-18, 17}, {-17, -10}, {-16, 7}, {-15, 86}, {-14, -3}, {-13, -3}, {-12, 45}, {-11, 93}, {-10, 84}, {-9, 20}, {-8, 3}, {-7, 81}, {-6, 52}, {-5, 67}, {-4, 18}, {-3, 40}, {-2, 42}, {-1, 49}, {0, 7}, {1, 104}, {2, 79}, {3, 37}, {4, 47}, {5, 69}, {6, 89}, {7, 110}, {8, 108}, {9, 19}, {10, 25}, {11, 48}, {12, 63}, {13, 94}, {14, 55}, {15, 119}, {16, 64}, {17, 122}, {18, 92}, {19, 37}, {20, 86}, {21, 84}, {22, 122}, {23, 37}, {24, 125}, {25, 99}, {26, 45}, {27, 63}, {28, 40}, {29, 97}, {30, 78}, {31, 102}, {32, 120}, {33, 91}, {34, 107}, {35, 62}, {36, 137}, {37, 55}, {38, 115}, {39, 46}, {40, 136}, {41, 78}, {42, 86}, {43, 106}, {44, 66}, {45, 141}, {46, 92}, {47, 132}, {48, 89}, {49, 61}, {50, 128}, {51, 155}, {52, 153}, {53, 78}, {54, 114}, {55, 84}, {56, 151}, {57, 123}, {58, 69}, {59, 91}, {60, 89}, {61, 73}, {62, 81}, {63, 139}, {64, 108}, {65, 165}, {66, 92}, {67, 117}, {68, 140}, {69, 109}, {70, 102}, {71, 171}, {72, 141}, {73, 117}, {74, 124}, {75, 171}, {76, 132}, {77, 142}, {78, 107}, {79, 132}, {80, 171}, {81, 104}, {82, 160}, {83, 128}, {84, 137}, {85, 176}, {86, 188}, {87, 178}, {88, 117}, {89, 115}, {90, 140}, {91, 165}, {92, 133}, {93, 114}, {94, 125}, {95, 135}, {96, 144}, {97, 114}, {98, 183}, {99, 157}});
        System.out.println(i);
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{1, 3}, new int[]{3, 5}));
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{1, 3}, new int[]{2, 5}));
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{1, 3}, new int[]{1, 5}));
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{1, 3}, new int[]{0, 5}));
//
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{3, 5}, new int[]{1, 3}));
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{2, 5}, new int[]{1, 3}));
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{1, 5}, new int[]{1, 3}));
//        System.out.println(nonOverlappingIntervals.isOver(new int[]{0, 5}, new int[]{1, 3}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        System.out.println(intervals.length);
        if (intervals == null || intervals.length < 2) {
            return 0;
        }

        if (intervals.length == 2) {
            if (isOver(intervals[0], intervals[1])) {
                return 1;
            }

            return 0;
        }

        // 使用开始下标排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        System.out.println(JSON.toJSONString(intervals));

        // 使用移动窗口算法
        int count = 0;
        int i = 0, j = 1;
        for (; j < intervals.length; ) {
            if (isOver(intervals[i], intervals[j])) {
                // 优先移除右边界更大的
                if (intervals[i][1] < intervals[j][1]) {
                    count++;
                    j++;
                } else {
                    count++;
                    i = j;
                    j = i + 1;
                }
            } else {
                i = j;
                j++;
            }
        }

        return count;
    }

    public boolean isOver(int[] ary1, int[] ary2) {
        if (ary1[1] > ary2[0] && (ary1[0] < ary2[1] || ary1[0] <= ary2[0])) {
            return true;
        }
        if (ary2[1] > ary1[0] && (ary2[0] < ary1[1] || ary2[0] <= ary1[0])) {
            return true;
        }
        return false;
    }
}
