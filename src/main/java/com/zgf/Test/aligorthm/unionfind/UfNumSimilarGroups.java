package com.zgf.Test.aligorthm.unionfind;

/**
 * https://leetcode-cn.com/problems/similar-string-groups/
 * <p>
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * <p>
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * <p>
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * <p>
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 */
public class UfNumSimilarGroups {
    public static void main(String[] args) {
        UfNumSimilarGroups ufNumSimilarGroups = new UfNumSimilarGroups();
        System.out.println(ufNumSimilarGroups.numSimilarGroups(new String[]{"nmiwx", "mniwx", "wminx", "mnixw", "xnmwi"}));
//        System.out.println(ufNumSimilarGroups.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
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


    public int numSimilarGroups(String[] strs) {
        UnionFind unionFind = new UnionFind(strs.length);
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    unionFind.union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < unionFind.roots.length; i++) {
            if (unionFind.find(i) != i) {
                count++;
            }
        }
        return strs.length - count;
    }

    /**
     * 前提，都是字符异位词
     * 判断字符串是否相似，判断不同的字符不同小于2处
     *
     * @param str
     * @param str1
     * @return
     */
    private boolean isSimilar(String str, String str1) {
        if (str.length() != str1.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str1.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
