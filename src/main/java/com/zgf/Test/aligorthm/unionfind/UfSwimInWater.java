package com.zgf.Test.aligorthm.unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/swim-in-rising-water/
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * <p>
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 */
public class UfSwimInWater {
    public static void main(String[] args) {
        UfSwimInWater ufSwimInWater = new UfSwimInWater();
        System.out.println(ufSwimInWater.swimInWater(new int[][]{{0, 2}, {1, 3}}));
        System.out.println(ufSwimInWater.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
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

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind unionFind = new UnionFind(m * n);
        int start = 0;
        int end = m * n - 1;

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    // 到达节点需要的水位
                    int h = Math.max(grid[i][j], grid[i + 1][j]);
                    edges.add(new Edge(i * n + j, (i + 1) * n + j, h));
                }
                if (j + 1 < n) {
                    // 到达节点需要的水位
                    int h = Math.max(grid[i][j], grid[i][j + 1]);
                    edges.add(new Edge(i * n + j, i * n + j + 1, h));
                }
            }
        }

        // 按边的权值进行排序
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.d - o2.d;
            }
        });

        int res = 0;
        for (Edge e : edges) {
            if (unionFind.find(start) != unionFind.find(end)) {
                unionFind.union(e.a, e.b);
                res = Math.max(res, e.d);
            } else {
                break;
            }
        }
        return res;
    }
}
