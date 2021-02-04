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
        System.out.println(swBusiestServers.busiestServers(6, new int[]{1, 2, 3, 9, 11, 12, 14}, new int[]{12, 3, 8, 13, 6, 10, 14}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{1, 2, 3, 4, 8, 9, 10}, new int[]{5, 2, 10, 3, 1, 2, 2}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{2, 6, 7, 8}, new int[]{1, 3, 1, 4}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{2, 3, 4, 5, 6, 9, 14, 15, 22, 23, 24, 25, 26, 27, 29, 30}, new int[]{2, 10, 11, 13, 8, 6, 15, 15, 7, 1, 16, 8, 9, 9, 6, 5}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{5, 2, 3, 3, 3}));
//        System.out.println(swBusiestServers.busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2}));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] taskNum = new int[k];
        int maxTaskNum = 0;

        // 使用优先级队列优化服务器选择速度
        // 0表示空闲时间点，1表示服务器ID
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

        // 服务器入队列
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new int[]{0, i});
        }

        for (int i = 0; i < arrival.length; i++) {
            // 判断第一个服务器时间
            int[] peek = priorityQueue.peek();
            if (peek[0] > arrival[i]) {
                // 无空闲服务器，放弃任务
                continue;
            } else {
                int targetId = i % k;
                int minServerId = Integer.MAX_VALUE;
                int largeMinServerId = Integer.MAX_VALUE;
                int[] targetMin = null;
                int[] targetLargerMin = null;

                // 遍历服务器 - 选取大于等于targetId的空闲服务器
                ArrayList<int[]> servers = new ArrayList<>();
                while (true) {
                    int[] poll = priorityQueue.poll();
                    if (poll == null) {
                        break;
                    }
                    servers.add(poll);
                    if (poll[0] <= arrival[i]) {
                        if (poll[1] == targetId) {
                            largeMinServerId = poll[1];
                            targetLargerMin = poll;
                            break;
                        } else if (poll[1] > targetId) {
                            if (poll[1] < largeMinServerId) {
                                largeMinServerId = poll[1];
                                targetLargerMin = poll;
                            }
                        } else {
                            if (poll[1] < minServerId) {
                                minServerId = poll[1];
                                targetMin = poll;
                            }
                        }
                    } else {
                        break;
                    }
                }

                if (largeMinServerId != Integer.MAX_VALUE) {
                    int id = targetLargerMin[1];
                    taskNum[id] += 1;
                    maxTaskNum = Math.max(maxTaskNum, taskNum[id]);
                    targetLargerMin[0] = arrival[i] + load[i];
                } else {
                    int id = targetMin[1];
                    taskNum[id] += 1;
                    maxTaskNum = Math.max(maxTaskNum, taskNum[id]);
                    targetMin[0] = arrival[i] + load[i];
                }
                priorityQueue.addAll(servers);
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
