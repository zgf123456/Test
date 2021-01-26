package com.zgf.Test.aligorthm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 括号生成，生成所有合法的括号对
 */
public class BfsGenerateParenthesis {
    public static void main(String[] args) {
        BfsGenerateParenthesis bfsGenerateParenthesis = new BfsGenerateParenthesis();
        List<String> result = bfsGenerateParenthesis.generateP(1);
        System.out.println(result);
        result = bfsGenerateParenthesis.generateP(2);
        System.out.println(result);
        result = bfsGenerateParenthesis.generateP(3);
        System.out.println(result);
        result = bfsGenerateParenthesis.generateP(4);
        System.out.println(result);
        result = bfsGenerateParenthesis.generateP(5);
        System.out.println(result);
    }

    private List<String> generateP(int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        doGenerateP(stringBuilder, result, 0, 0, n);
        return result;
    }

    private boolean doGenerateP(StringBuilder stringBuilder, ArrayList<String> result, int leftUse, int rightUse, int n) {
        if (leftUse + rightUse >= n * 2) {
            result.add(stringBuilder.toString());
            return true;
        }

        for (char c : Arrays.asList('(', ')')) {
            if (isValid(leftUse, rightUse, n, c)) {
                stringBuilder.append(c);
                boolean rs;
                if (c == '(') {
                    rs = doGenerateP(stringBuilder, result, leftUse + 1, rightUse, n);
                } else {
                    rs = doGenerateP(stringBuilder, result, leftUse, rightUse + 1, n);
                }

//                // 只需要一种解法时
//                if (result.size() > 0) {
//                    break;
//                }

                // 回溯
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        return false;
    }

    private boolean isValid(int leftUse, int rightUse, int n, char c) {
        if (c == '(') {
            leftUse = leftUse + 1;
            if (leftUse <= n && leftUse >= rightUse) {
                return true;
            }
        } else {
            rightUse = rightUse + 1;
            if (rightUse <= n && leftUse >= rightUse) {
                return true;
            }
        }
        return false;
    }
}