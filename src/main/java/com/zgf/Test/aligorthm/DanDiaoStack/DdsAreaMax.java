package com.zgf.Test.aligorthm.DanDiaoStack;

import java.util.Stack;

/**
 * 计算最大区间，满足区间和 * 区间最小数 最大
 */
public class DdsAreaMax {
    public static void main(String[] args) {
        DdsAreaMax ddsAreaMax = new DdsAreaMax();
        System.out.println(ddsAreaMax.getAreaMax(new int[]{1, 3, 2, 5, 6}));
    }

    private boolean getAreaMax(int[] ints) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<ints.length; i++) {
            if(stack.isEmpty()) {
                stack.push(ints[i]);
            } else {
                Integer peek = stack.peek();
                if(ints[i] > peek) {
                    stack.push(ints[i]);
                } else {
                    // 计算和
                }
            }
        }
        return false;
    }
}
