package com.zgf.Test.aligorthm.DanDiaoStack;

import com.alibaba.fastjson.JSON;

/**
 * 计算最大区间，满足区间和 * 区间最小数 最大
 */
public class DdsAreaMax {
    public static void main(String[] args) {
        DdsAreaMax ddsAreaMax = new DdsAreaMax();
        System.out.println(JSON.toJSONString(ddsAreaMax.getAreaMax(new int[]{1, 3, 2, 5, 6})));
    }

    /**
     * 暴力法
     *
     * @param ints
     * @return
     */
    private int[] getAreaMax(int[] ints) {
        int maxArea = 0;
        int[] idxMax = new int[3];

        for (int i = 0; i < ints.length; i++) {
            int left = -1;
            int right = -1;

            int sum = ints[i];
            // 找最左的值
            for (int m = i - 1; m >= 0; m--) {
                if (ints[m] >= ints[i]) {
                    left = m;
                    sum += ints[m];
                    continue;
                } else {
                    break;
                }
            }
            //找最右的值
            for (int n = i + 1; n < ints.length; n++) {
                if (ints[n] >= ints[i]) {
                    right = n;
                    sum += ints[n];
                    continue;
                } else {
                    break;
                }
            }

            int area = sum * ints[i];
            if (area > maxArea) {
                maxArea = area;
                idxMax[0] = left == -1 ? i : left;
                idxMax[1] = right == -1 ? i : right;
                idxMax[2] = area;
            }
        }

        return idxMax;
    }
}
