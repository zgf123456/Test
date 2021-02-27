package com.zgf.Test.aligorthm.normal;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 * <p>
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 * <p>
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * <p>
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 */
public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        NumberOfValidWordsForEachPuzzle numberOfValidWordsForEachPuzzle = new NumberOfValidWordsForEachPuzzle();
        System.out.println(numberOfValidWordsForEachPuzzle.findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"}, new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}));
    }

    /**
     * 这个解法是正确的，只是会超时
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<String, HashSet<Character>> wordCharMap = new HashMap<>();
        // 先统计字符数
        for (int i = 0; i < words.length; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                hashSet.add(words[i].charAt(j));
            }
            wordCharMap.put(words[i], hashSet);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = 0; j < puzzles[i].length(); j++) {
                hashSet.add(puzzles[i].charAt(j));
            }
            int num = doFind(puzzles[i], hashSet, wordCharMap);
            result.add(num);
        }
        return result;
    }

    /**
     * 执行查询匹配过程
     *
     * @param puzzle
     * @param hashSet
     * @param wordCharMap
     * @return
     */
    private int doFind(String puzzle, HashSet<Character> hashSet, HashMap<String, HashSet<Character>> wordCharMap) {
        char c = puzzle.charAt(0);
        int num = 0;

        Set<Map.Entry<String, HashSet<Character>>> entries = wordCharMap.entrySet();
        for (Map.Entry<String, HashSet<Character>> entry : entries) {
            HashSet<Character> value = entry.getValue();
            // 第一个条件，包含首字母
            if (!value.contains(c)) {
                continue;
            }

            // 第二个条件
            // word 中的每一个字母都可以在谜面 puzzle 中找到
            if (hashSet.containsAll(value)) {
                num++;
            }

        }
        return num;
    }
}
