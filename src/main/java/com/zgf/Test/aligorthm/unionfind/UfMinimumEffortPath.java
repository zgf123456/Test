package com.zgf.Test.aligorthm.unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 */
public class UfMinimumEffortPath {
    public static void main(String[] args) {
        UfMinimumEffortPath bfsMinimumEffortPath = new UfMinimumEffortPath();
        System.out.println(bfsMinimumEffortPath.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println(bfsMinimumEffortPath.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    // 并查集模板
    class UnionFind {
        private int[] roots;

        /**
         * 初始化时，所有的根节点都是自己
         *
         * @param n
         */
        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        /**
         * 返回根节点，如果值等于自己，则是跟节点，非根节点存的是路径，可以通过递归查询得到根节点。
         *
         * @param n
         * @return
         */
        public int find(int n) {
            if (roots[n] == n) {
                return n;
            }
            return roots[n] = find(roots[n]);
        }

        /**
         * 将a 合并到b，以b的根节点为主
         * 将a节点的根节点的值，设置为b节点根节点的值
         *
         * @param a
         * @param b
         */
        public void union(int a, int b) {
            roots[find(a)] = find(b);
        }
    }

    // 边类
    class Edge {
        int a, b, d; //起点、终点、权值

        public Edge(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // 初始化并查集
        UnionFind unionFind = new UnionFind(m * n);

        // 初始化边的集合，用于判断连通性
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 用i * n + j作为点(i, j)的唯一标识
                // 从左上角开始，每个点有左和下两条边，边界点，可能没有
                if (i + 1 < m) {
                    edges.add(new Edge(i * n + j, (i + 1) * n + j, Math.abs(heights[i][j] - heights[i + 1][j])));
                }
                if (j + 1 < n) {
                    edges.add(new Edge(i * n + j, i * n + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])));
                }
            }
        }

        // 对边按权值进行排序，保证获取的路径未最小
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.d - o2.d;
            }
        });

        // 开始进行并查集查询操作
        int max = 0;
        for (Edge edge : edges) {
            // 判断开始点和目标点是否连通，即根节点相同
            if (unionFind.find(0) != unionFind.find(m * n - 1)) {
                // 不连通，将当前边合并集合，这时不代表连通，需要进行多次合并，才能使用开始节点和目标节点连通
                unionFind.union(edge.a, edge.b);
                max = Math.max(max, edge.d); // 更新最大值
            }
        }
        return max;
    }
}
