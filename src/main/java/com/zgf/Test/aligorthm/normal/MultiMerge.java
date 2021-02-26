package com.zgf.Test.aligorthm.normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 多路归并排序
 * <p>
 * 20个有序数组，每个数组里面50个数，取前500个最小的数
 * 基本思路
 * 1. 多路归并排序，将每个数组最小的值放入优先队列（堆），包含数组小标和元素值
 * 2. 每次从堆中取出最小元素，放入结果集，将对应的数组下标后移，取出后面的元素，放入优先队列
 * 3. 循环执行这样的操作，直到取满为止
 */
public class MultiMerge {
    public static void main(String[] args) {
        int lines = 20;
        int len = 50;
        int resultNum = 500;

        // 初始化测试数据
        Random random = new Random();
        int[][] ary = new int[lines][len];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < len; j++) {
                ary[i][j] = random.nextInt(1000);
            }
        }

        for (int i = 0; i < lines; i++) {
            Arrays.sort(ary[i]);
        }

        // 开始取值
        // 定义一个优先队列
        PriorityQueue priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 定义各个队列的下标值
        int[] indexAry = new int[lines];
        // 将每个队列的值放入优先队列
        for (int i = 0; i < lines; i++) {
            priorityQueue.add(new int[]{i, ary[i][0]});
        }

        // 循环从优先队列取值
        int[] resultAry = new int[resultNum];
        int resultIndex = 0;
        while (priorityQueue.size() > 0) {
            // 取出最小元素，加入结果集合
            int[] poll = (int[]) priorityQueue.poll();
            resultAry[resultIndex] = poll[1];
            resultIndex++;

            if(resultIndex >= resultNum) {
                break;
            }

            // 从数组中取出下一个元素加入优先队列
            int idx = poll[0];
            indexAry[idx]++; // 数组小标后移
            if (indexAry[idx] < ary[idx].length) {
                poll[1] = ary[idx][indexAry[idx]];
                priorityQueue.add(poll);
            } else {
                // 小标越界，标识当前数组已经全部读完，继续从队列取值
                continue;
            }
        }
        System.out.println("end");
    }
}
