package com.zgf.Test.aligorthm.normal;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.println(toeplitzMatrix.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            int[] matrixLine = matrix[i];
            for (int j = 0; j < matrixLine.length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
