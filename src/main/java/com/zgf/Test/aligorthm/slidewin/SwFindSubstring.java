package com.zgf.Test.aligorthm.slidewin;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 */
public class SwFindSubstring {
    public static void main(String[] args) {
        SwFindSubstring swFindSubstring = new SwFindSubstring();
//        System.out.println(swFindSubstring.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(swFindSubstring.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(swFindSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    /**
     * 滑动窗口 - 重复计算太多需优化
     * 超时了，逻辑没有啥问题
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        // 计算窗口大小
        int len = 0;
        int wordLen = words[0].length();
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            len += words[i].length();
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }

        // 滑动窗口
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = i + len; j <= s.length(); ) {
            String substr = s.substring(i, j);
            TreeMap<String, Integer> wordMapTemp = new TreeMap<>();
            for (int m = 0; m < substr.length(); m += wordLen) {
                String sub = substr.substring(m, m + wordLen);
                if(wordMap.containsKey(sub)) {
                    wordMapTemp.put(sub, wordMapTemp.getOrDefault(sub, 0) + 1);
                } else {
                    break;
                }
            }

            if (wordMap.equals(wordMapTemp)) {
                result.add(i);
            }

            i++;
            j = i + len;
        }
        return result;
    }
}
