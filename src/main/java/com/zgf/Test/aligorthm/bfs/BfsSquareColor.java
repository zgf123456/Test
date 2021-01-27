package com.zgf.Test.aligorthm.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 正方形涂色，给定N种颜色，给出全部涂色方案，可重复/相邻的面不可重复
 */
public class BfsSquareColor {
    public static void main(String[] args) {
        BfsSquareColor squareColor = new BfsSquareColor();
        List<List<Character>> lists = squareColor.makeColor(new char[]{'r', 'g', 'b'});
        System.out.println(lists.size() + "," + lists);
        lists = squareColor.makeColor(new char[]{'r', 'g', 'b', 'f'});
        System.out.println(lists.size() + "," + lists);
    }

    private List<List<Character>> makeColor(char[] colors) {
        List<List<Character>> allResult = new ArrayList<List<Character>>();
        List<Character> result = new ArrayList<>();
        doMakeColor(colors, 1, result, allResult);
        return allResult;
    }

    private void doMakeColor(char[] colors, int i, List<Character> result, List<List<Character>> allResult) {
        if (i > 6) {
            ArrayList<Character> rs = new ArrayList<>();
            rs.addAll(result);
            allResult.add(rs);
            return;
        }

        for (char c : colors) {
            if (isValid(c, i, result)) {
                result.add(c);
                doMakeColor(colors, i + 1, result, allResult);
                result.remove(result.size() - 1);
            }
        }
    }

    /**
     * 判断相邻面，不重复
     *
     * @param c
     * @param i
     * @param result
     * @return
     */
    private boolean isValid(char c, int i, List<Character> result) {
        if (i >= 2) {
            if (i == 2) {
                // 相邻面第1
                if (result.get(0) == c) {
                    return false;
                }
            } else if (i == 3) {
                // 相邻面第1、2
                if (result.get(0) == c || result.get(1) == c) {
                    return false;
                }
            } else if (i == 4) {
                // 相邻面第1、3
                if (result.get(0) == c || result.get(2) == c) {
                    return false;
                }
            } else if (i == 5) {
                // 相邻面第1、4、2
                if (result.get(0) == c || result.get(1) == c || result.get(3) == c) {
                    return false;
                }
            } else if (i == 6) {
                // 相邻面第2、3、4、5
                if (result.get(1) == c || result.get(2) == c || result.get(3) == c || result.get(4) == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
