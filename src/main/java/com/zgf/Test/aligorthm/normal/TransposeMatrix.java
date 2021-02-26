package com.zgf.Test.aligorthm.normal;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/transpose-matrix/
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        System.out.println(JSON.toJSONString(transposeMatrix.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[][] transpose(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] matrixNew = new int[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrixNew[j][i] = matrix[i][j];
            }
        }
        return matrixNew;
    }
}
