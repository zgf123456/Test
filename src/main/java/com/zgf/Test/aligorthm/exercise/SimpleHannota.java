package com.zgf.Test.aligorthm.exercise;

import java.util.Stack;

/**
 * Created by zgf on 16/11/27.
 */
public class SimpleHannota {
    private Stack<Integer> taStrat = new Stack<>();
    private Stack<Integer> taMiddle = new Stack<>();
    private Stack<Integer> taTarget = new Stack<>();
    private int step = 0;

    public SimpleHannota(int level) {
        if (level < 3) {
            throw new IllegalArgumentException("level");
        }

        for (int i = level; i > 0; i--) {
            taStrat.push(i);
        }
    }

    public static void main(String[] args) {
        SimpleHannota simpleHannota = new SimpleHannota(5);
        System.out.println("start: " + simpleHannota.toString());
        simpleHannota.move();
        System.out.println("result: " + simpleHannota.toString());
    }

    private void move() {
        this.move(taStrat, taMiddle, taTarget, taStrat.size());
    }

    private void move(Stack<Integer> src, Stack<Integer> mid, Stack<Integer> target, int nums) {
        if (nums > 0) {
            if (nums == 1) {
                target.push(src.pop());
                System.out.println("move" + (++step) + ": s" + taStrat + ",m" + taMiddle + ",t" + taTarget);
            } else {
                move(src, target, mid, nums - 1);
                target.push(src.pop());
                System.out.println("move" + (++step) + ": s" + taStrat + ",m" + taMiddle + ",t" + taTarget);
                move(mid, src, target, nums - 1);
            }
        }
    }

    @Override
    public String toString() {
        return "SimpleHannota{" +
                "taStrat=" + taStrat +
                ", taMiddle=" + taMiddle +
                ", taTarget=" + taTarget +
                '}';
    }
}
