package com.zgf.Test.aligorthm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/reorganize-string/
 * 贪心算法
 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class ChongGouZiFuChuan {
    public static void main(String[] args) {
        ChongGouZiFuChuan chongGouZiFuChuan = new ChongGouZiFuChuan();
        System.out.println(chongGouZiFuChuan.reorganizeString("aab"));
        System.out.println(chongGouZiFuChuan.reorganizeString("abbabbaaab"));
    }

    public String reorganizeString(String S) {
        int len = S.length();
        if (len <= 2) {
            return S;
        }
        int maxNum = (len + 1) / 2;
        int[] counts = new int[26];
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            int idx = c - 'a';
            counts[idx] = counts[idx] + 1;
            if (counts[idx] > maxNum) {
                return "";
            }
        }

        // 构造大顶堆
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return counts[c2 - 'a'] - counts[c1 - 'a'];
            }
        });

        // 构建堆
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                priorityQueue.offer(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (priorityQueue.size() > 1) {
            Character c1 = priorityQueue.poll();
            Character c2 = priorityQueue.poll();
            stringBuilder.append(c1);
            stringBuilder.append(c2);
            int idx1 = c1 - 'a';
            int idx2 = c2 - 'a';
            counts[idx1]--;
            counts[idx2]--;
            if (counts[idx1] > 0) {
                priorityQueue.offer(c1);
            }
            if (counts[idx2] > 0) {
                priorityQueue.offer(c2);
            }
        }

        if (priorityQueue.size() > 0) {
            stringBuilder.append(priorityQueue.poll());
        }
        return stringBuilder.toString();
    }
}
