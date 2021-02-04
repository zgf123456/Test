package com.zgf.Test.aligorthm.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class UfGroupAnagrams {
    public static void main(String[] args) {
        UfGroupAnagrams ufGroupAnagrams = new UfGroupAnagrams();
        System.out.println(ufGroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 并查集的方式超时了，使用更原始的算法
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            //统计字符串中每个字符串出现的次数
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }

            //统计每个字符出现次数的数组转化为字符串
            String keyStr = String.valueOf(ca);

            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }

            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
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

    public List<List<String>> groupAnagrams1(String[] strs) {
        UnionFind unionFind = new UnionFind(strs.length);

        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (unionFind.find(i) != unionFind.find(j)) {
                    // 判断是否异位词
                    if (isSimilar(strs[i], strs[j])) {
                        unionFind.union(i, j);
                    }
                }
            }
        }

        HashMap<Integer, List<String>> stringListHashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int idx = unionFind.find(i);
            List<String> rs = stringListHashMap.get(idx);
            if (rs == null) {
                rs = new ArrayList<>();
            }
            rs.add(strs[i]);
            stringListHashMap.put(idx, rs);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(stringListHashMap.values());
        return result;
    }

    private boolean isSimilar(String str, String str1) {
        if (str.length() != str1.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map1.put(str.charAt(i), map1.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str1.length(); i++) {
            map2.put(str1.charAt(i), map2.getOrDefault(str1.charAt(i), 0) + 1);
        }

        return map1.equals(map2);
    }
}
