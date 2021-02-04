package com.zgf.Test.aligorthm.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class RotateImage {
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] image = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(image);
        System.out.println(JSON.toJSONString(image));
    }

    /**
     * 两次翻转
     * 先沿右上 - 左下的对角线翻转（270° +270°+ 一次镜像），再沿水平中线上下翻转（-180° +−180°+ 一次镜像），可以实现顺时针 9090 度的旋转效果
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i) {
            for (int j = 0; j < nums - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }
        for (int i = 0; i < (nums >> 1); ++i) {
            for (int j = 0; j < nums; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }
}

