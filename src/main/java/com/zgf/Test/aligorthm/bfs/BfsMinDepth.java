package com.zgf.Test.aligorthm.bfs;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * BFS广度优先，求完全二叉树最小高度
 */
public class BfsMinDepth {
    public static void main(String[] args) {
        BfsMinDepth bfsMinDepth = new BfsMinDepth();
        System.out.println(bfsMinDepth.find(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(bfsMinDepth.find(new Integer[]{3, 9, 20, 3, 4, 15, 7}));
    }

    private int find(Integer[] integers) {
        if (integers.length == 0) return 0;
        if (integers[0] == null) return 0;

        Queue<Integer> q = new ArrayBlockingQueue<Integer>(integers.length);
        q.add(0);
        int depth = 1;

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer idx = q.poll();
                int left = idx * 2 + 1;
                int right = idx * 2 + 2;
                if (left < integers.length && integers[left] == null && right < integers.length && integers[right] == null) {
                    return depth;
                }
                if (left < integers.length && integers[left] != null) {
                    q.add(left);
                }
                if (right < integers.length && integers[right] != null) {
                    q.add(right);
                }
            }
            depth++;
        }
        return depth;
    }
}
