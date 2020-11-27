package com.zgf.Test.aligorthm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/comments/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 */
public class Letter {
    public static void main(String[] args) {
        Letter letter = new Letter();
        List<String> strings = letter.letterCombinations("234");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        return appendLetter(digits, 0);
    }

    public List<String> appendLetter(String digits, int index) {
        String s = letterMap.get(digits.charAt(index));

        List<String> let = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            let.add(String.valueOf(s.charAt(i)));
        }

        int next = index + 1;
        if (next < digits.length()) {
            List<String> result = new ArrayList<>();
            List<String> letNext = appendLetter(digits, next);
            for (int i = 0; i < let.size(); i++) {
                for (int j = 0; j < letNext.size(); j++) {
                    result.add(let.get(i) + letNext.get(j));
                }
            }
            return result;
        } else {
            return let;
        }
    }

    static HashMap<Character, String> letterMap = new HashMap<>();

    static {
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
    }
}
