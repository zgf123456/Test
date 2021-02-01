package com.zgf.Test.aligorthm.unionfind;


/**
 * 并查集模板 - 数组
 */
// 并查集模板
public class UnionFind {
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
