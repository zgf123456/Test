package com.zgf.Test.aligorthm.bfs;

import java.util.Arrays;

/**
 * 回溯法解决数独问题
 * https://leetcode-cn.com/problems/sudoku-solver/solution/
 */
public class BfsShuDu {
    public static void main(String[] args) {
        BfsShuDu bfsShuDu = new BfsShuDu();
        int len = 9;
        char[][] map = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = '.';
            }
        }

        // 固定选项的解法
        map[1][1] = '1';
        map[5][5] = '1';
        map[8][8] = '8';


        bfsShuDu.solveSudoku(map);
        bfsShuDu.print(map);
    }

    private void print(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        doSudoku(board, 0, 0);
    }

    private boolean doSudoku(char[][] board, int i, int j) {
        // 跳过非空格子
        while (board[i][j] != '.') {
            j = j + 1;
            if (j >= board.length) {
                i = i + 1;
                j = 0;
                // 结束条件
                if (i >= board.length) {
                    return true;
                }
            }
        }

        for (char c : Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')) {
            char temp = board[i][j];

            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                int targetJ = j + 1;
                int targetI = i;
                if (targetJ >= board.length) {
                    targetI = targetI + 1;
                    targetJ = 0;
                    // 结束条件
                    if (targetI >= board.length) {
                        return true;
                    }
                }

                boolean rs = doSudoku(board, targetI, targetJ);
                if (rs) {
                    // 中断后续搜索
                    return rs;
                }
            }

            // 回溯
            board[i][j] = temp;
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        // 1. 判断同行
        for (int m = 0; m < board.length; m++) {
            if (m != j && board[i][m] == c) {
                return false;
            }
        }

        // 2. 判断同列
        for (int n = 0; n < board.length; n++) {
            if (n != i && board[n][j] == c) {
                return false;
            }
        }

        // 3. 判断同一方格
        int startI = (i / 3) * 3;
        int startJ = (j / 3) * 3;
        for (int m = 0; m < 3; m++) {
            int targetI = startI + m;
            for (int n = 0; n < 3; n++) {
                int targetJ = startJ + n;
                if (targetI != i && targetJ != j && board[targetI][targetJ] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
