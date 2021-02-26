package com.zgf.Test.aligorthm.backtrack;

import java.util.LinkedHashSet;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
public class BtPermutationSequence {
    public static void main(String[] args) {
        BtPermutationSequence btPermutationSequence = new BtPermutationSequence();
        System.out.println(btPermutationSequence.getPermutation(3, 3));
    }

    /**
     * 1,2,3,...,n
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = i + 1;
        }
        LinkedHashSet<Integer> selected = new LinkedHashSet<>();
        doGetPermutation(ary, selected, 0, 0, k);
        return selected.toString();
    }

    public boolean doGetPermutation(int[] ary, LinkedHashSet<Integer> selected, int len, int count, int target) {

        for (int i = 0; i < ary.length; i++) {
            if (selected.contains(ary[i])) {
                continue;
            }
            selected.add(ary[i]);
            if (len + 1 == ary.length) {
                count++;
                if (count == target) {
                    return true;
                }
            }
            boolean b = doGetPermutation(ary, selected, len + 1, count, target);
            if (b) {
                return b;
            }
            selected.remove(ary[i]);
        }
        return false;
    }
}
