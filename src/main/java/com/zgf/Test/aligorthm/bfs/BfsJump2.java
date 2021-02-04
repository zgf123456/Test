package com.zgf.Test.aligorthm.bfs;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class BfsJump2 {
    public static void main(String[] args) {
        BfsJump2 bfsJump2 = new BfsJump2();
        System.out.println(bfsJump2.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
        System.out.println(bfsJump2.jump(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * 区间滚动判断
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums.length == 2) return 1;

        int step = 0; // 需要的步数
        int end = nums.length - 1;

        int maxLen = 0;
        int areaMaxLen = 0;
        for (int i = 0; i < end; i++) {
            int len = i + nums[i]; // 当前位置能到达的最大区间
            areaMaxLen = Math.max(areaMaxLen, len);

            // 判断是否在上个区间范围内
            if (i < maxLen) {
                // 还在上个区间内，累计下个区间最大值
                continue;
            } else {
                maxLen = areaMaxLen;
            }

            step++;
            // 判端是否可以到达终点
            if (maxLen >= end) {
                break;
            }
        }
        return step;
    }

    /**
     * 超时了
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums.length == 2) return 1;

        int step = 0; // 需要的步数
        int end = nums.length - 1;
        Queue<Integer> q = new ArrayBlockingQueue<Integer>(nums.length);
        q.add(0);

        while (q.size() > 0) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                Integer idx = q.poll();
                int len = nums[idx];
                // 判断是否能到达终点
                if (idx + len >= end) {
                    return step;
                }

                // 将范围内的节点加入队列
                for (int j = idx + 1; j <= idx + len; j++) {
                    if (!q.contains(j)) {
                        q.add(j);
                    }
                }
            }
        }
        return step;
    }
}
