package com.zgf.Test.aligorthm.unionfind;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 */
public class FindCircleNum {
    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        System.out.println(findCircleNum.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // 初始化并查集
        UnionFind unionFind = new UnionFind(n);

        // 判断连通性，合并连通的城市
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind.roots[i] == i) {
                num++;
            }
        }
        return num;
    }
}
