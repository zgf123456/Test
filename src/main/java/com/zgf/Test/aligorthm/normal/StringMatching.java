package com.zgf.Test.aligorthm.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/string-matching-in-an-array/
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * <p>
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 *
 * @author zgf
 * @date 2021-04-16 上午11:42
 */
public class StringMatching {
    public static void main(String[] args) {
        StringMatching stringMatching = new StringMatching();
        System.out.println(stringMatching.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
    }

    public List<String> stringMatching(String[] words) {
        HashSet<String> rs = new HashSet<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    if (words[i].indexOf(words[j]) != -1) {
                        rs.add(words[j]);
                    }
                } else {
                    if (words[j].indexOf(words[i]) != -1) {
                        rs.add(words[i]);
                    }
                }
            }
        }
        return new ArrayList<>(rs);
    }
}
