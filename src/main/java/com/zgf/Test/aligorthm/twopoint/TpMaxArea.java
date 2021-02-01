package com.zgf.Test.aligorthm.twopoint;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class TpMaxArea {
    public static void main(String[] args) {
        TpMaxArea tpMaxArea = new TpMaxArea();
        System.out.println(tpMaxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(tpMaxArea.maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 简单粗暴
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int len = j - i;
                max = Math.max(max, minHeight * len);
            }
        }
        return max;
    }

    /**
     * 双指针向中间逼近
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int x = 0;
        int y = height.length - 1;
        int len = height.length - 1;
        int max = Math.min(height[y], height[x]) * len;

        while (x < y) {
            if (height[x] < height[y]) {
                x++;
            } else {
                y--;
            }
            len--;
            max = Math.max(max, Math.min(height[y], height[x]) * len);
        }
        return max;
    }

}
