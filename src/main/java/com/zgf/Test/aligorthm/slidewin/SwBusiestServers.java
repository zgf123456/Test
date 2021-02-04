package com.zgf.Test.aligorthm.slidewin;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 * 你有 k 个服务器，编号为 0 到 k-1 ，它们可以同时处理多个请求组。每个服务器有无穷的计算能力但是 不能同时处理超过一个请求 。请求分配到服务器的规则如下：
 * <p>
 * 第 i （序号从 0 开始）个请求到达。
 * 如果所有服务器都已被占据，那么该请求被舍弃（完全不处理）。
 * 如果第 (i % k) 个服务器空闲，那么对应服务器会处理该请求。
 * 否则，将请求安排给下一个空闲的服务器（服务器构成一个环，必要的话可能从第 0 个服务器开始继续找下一个空闲的服务器）。比方说，如果第 i 个服务器在忙，那么会查看第 (i+1) 个服务器，第 (i+2) 个服务器等等。
 * 给你一个 严格递增 的正整数数组 arrival ，表示第 i 个任务的到达时间，和另一个数组 load ，其中 load[i] 表示第 i 个请求的工作量（也就是服务器完成它所需要的时间）。你的任务是找到 最繁忙的服务器 。最繁忙定义为一个服务器处理的请求数是所有服务器里最多的。
 * <p>
 * 请你返回包含所有 最繁忙服务器 序号的列表，你可以以任意顺序返回这个列表。
 */
public class SwBusiestServers {
    public static void main(String[] args) {
        SwBusiestServers swBusiestServers = new SwBusiestServers();
//        System.out.println(swBusiestServers.busiestServers(6, new int[]{1, 2, 3, 9, 11, 12, 14}, new int[]{12, 3, 8, 13, 6, 10, 14}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{1, 2, 3, 4, 8, 9, 10}, new int[]{5, 2, 10, 3, 1, 2, 2}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{2, 6, 7, 8}, new int[]{1, 3, 1, 4}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{2, 3, 4, 5, 6, 9, 14, 15, 22, 23, 24, 25, 26, 27, 29, 30}, new int[]{2, 10, 11, 13, 8, 6, 15, 15, 7, 1, 16, 8, 9, 9, 6, 5}));
        System.out.println(swBusiestServers.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2}));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] taskNum = new int[k];
        int maxTaskNum = 0;

        // 维护工作队列，以时间排序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // 时间相同，再比较服务器ID
                } else {
                    return o1[0] - o2[0]; // 比较时间
                }
            }
        });

        // 维持空闲队列
        TreeSet<Integer> freeServerSet = new TreeSet<>();
        // 服务器入空闲队列
        for (int i = 0; i < k; i++) {
            freeServerSet.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            // 第i个请求到达，将工作队列中已完成的服务器，放入空闲队列
            int[] peek = priorityQueue.peek();
            while (peek != null && peek[0] <= arrival[i]) {
                priorityQueue.poll();
                freeServerSet.add(peek[1]);
                peek = priorityQueue.peek();
            }

            // 从空闲队列中选择服务器
            int target = i % k;
            Integer ceiling = freeServerSet.ceiling(target);
            if (ceiling == null) {
                ceiling = freeServerSet.ceiling(0);
            }

            if (ceiling != null) {
                taskNum[ceiling] += 1;
                maxTaskNum = Math.max(maxTaskNum, taskNum[ceiling]);
                // 移出空闲队列
                freeServerSet.remove(ceiling);
                // 放入工作队列
                priorityQueue.add(new int[]{arrival[i] + load[i], ceiling});
            } else {
                // 放弃
            }
        }

        System.out.println(Arrays.toString(taskNum));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (taskNum[i] == maxTaskNum) {
                result.add(i);
            }
        }
        return result;
    }
}
