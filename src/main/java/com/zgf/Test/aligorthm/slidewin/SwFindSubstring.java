package com.zgf.Test.aligorthm.slidewin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 */
public class SwFindSubstring {
    public static void main(String[] args) {
        SwFindSubstring swFindSubstring = new SwFindSubstring();
        System.out.println(swFindSubstring.findSubstring("goodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(swFindSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // 计算窗口大小
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            len += words[i].length();
        }

        // 滑动窗口
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + len <= s.length(); i++) {
            int j = i;
            HashSet<Integer> exists = new HashSet<>();
            while (j < i + len) {
                boolean wordMatch = false;
                int wordLen = 0;
                for (int m = 0; m < words.length; m++) {
                    if (exists.contains(m)) {
                        continue;
                    }

                    if (s.indexOf(words[m], j) == j) {
                        exists.add(m);
                        wordMatch = true;
                        wordLen = words[m].length();
                        break;
                    }
                }

                if (wordMatch) {
                    j += wordLen;
                    if(exists.size() == words.length) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
