package com.zgf.Test.aligorthm.normal;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/flipping-an-image/
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        System.out.println(JSON.toJSONString(flippingAnImage.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] line = A[i];
            int start = 0;
            int end = line.length - 1;
            while (start < end) {
                // swap
                if(line[start] == line[end]) {
                    if(line[start] == 0) {
                        line[start] = 1;
                        line[end] = 1;
                    } else {
                        line[start] = 0;
                        line[end] = 0;
                    }
                }
                start++;
                end--;
            }

            if(start == end) {
                if(line[start] == 0) {
                    line[start] = 1;
                } else {
                    line[start] = 0;
                }
            }
        }
        return A;
    }
}
