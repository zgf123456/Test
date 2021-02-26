package com.zgf.Test.aligorthm.normal;

import java.util.Random;

/**
 * 微信红包，随机策略
 */
public class WxRedPack {
    public static void main(String[] args) {
        int size  = 20;
        int remainSize = size;
        double remainMoney = 100;
        for (int i = 0; i < size; i++) {
            double randomMoney = getRandomMoney(remainSize, remainMoney);
            System.out.println(randomMoney);
            remainSize--;
            remainMoney -= randomMoney;
        }
    }

    /**
     * @param remainSize  剩余的红包数量
     * @param remainMoney 剩余的钱
     * @return
     */
    public static double getRandomMoney(int remainSize, double remainMoney) {
        if (remainSize == 1) {
            return (double) Math.round(remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01; //
        double max = remainMoney / remainSize * 2; // 最大不能超过剩余平均数的一倍
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        return money;
    }
}
