package com.zgf.Test.aligorthm.normal;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 红包，固定金额
 * 基本思路
 * 1. 按金额和比例计算出每个红包的个数
 * 2. 按总个数，做随机数，看随机数在哪个区间，就发哪个红包，同时对应的红包数量减1
 */
public class RedPack {
    public static void main(String[] args) {
        int remainMoney = 10000;
        RedPackConfig[] redPackConfigAry = new RedPackConfig[5];
        redPackConfigAry[0] = new RedPackConfig(new BigDecimal("188"), 0.01);
        redPackConfigAry[1] = new RedPackConfig(new BigDecimal("18.8"), 0.1);
        redPackConfigAry[2] = new RedPackConfig(new BigDecimal("1.88"), 0.3);
        redPackConfigAry[3] = new RedPackConfig(new BigDecimal("0.18"), 0.5);
        redPackConfigAry[4] = new RedPackConfig(new BigDecimal("0.01"), 0.09); // 可通过计算得出

        countRedPacNum(remainMoney, redPackConfigAry);
        System.out.println(JSON.toJSONString(redPackConfigAry));
        int redNum = 0;
        for (int i = 0; i < redPackConfigAry.length; i++) {
            redNum += redPackConfigAry[i].getNum();
        }

        int maxRedNum = redNum;
        double totalRedPackVal = 0;
        for (int i = 0; i < maxRedNum; i++) {
            double redPackVal = randomRedPack(redNum, redPackConfigAry);
            System.out.println(i + " = " + redPackVal);
            totalRedPackVal += redPackVal;
            redNum--;
        }
        System.out.println(totalRedPackVal);
    }

    /**
     * 随机发红包
     *
     * @param redPackConfigAry
     */
    private static double randomRedPack(int redNum, RedPackConfig[] redPackConfigAry) {
        Random random = new Random();
        int r = random.nextInt(redNum) + 1;
        // 判断r所在的区间
        int area = 0;
        for (int i = 0; i < redPackConfigAry.length; i++) {
            if (r <= area + redPackConfigAry[i].getNum()) {
                redPackConfigAry[i].setNum(redPackConfigAry[i].getNum() - 1);
                return redPackConfigAry[i].getAmount().doubleValue();
            }
            area += redPackConfigAry[i].getNum();
        }
        return 0;
    }

    /**
     * 计算红包数量
     *
     * @param remainMoney
     * @param redPackConfigAry
     */
    private static void countRedPacNum(int remainMoney, RedPackConfig[] redPackConfigAry) {
        BigDecimal amountBase = new BigDecimal("0");
        for (int i = 0; i < redPackConfigAry.length; i++) {
            BigDecimal rs = redPackConfigAry[i].getAmount()
                    .multiply(new BigDecimal("100") //
                            .multiply(new BigDecimal(redPackConfigAry[i].getRate())));
            amountBase = amountBase.add(rs);
        }

        int baseNum = (int) (remainMoney / amountBase.doubleValue());
        for (int i = 0; i < redPackConfigAry.length; i++) {
            int num = (int) (baseNum * 100 * redPackConfigAry[i].getRate());
            redPackConfigAry[i].setNum(num);
        }

        BigDecimal moneryTotal = new BigDecimal("0");
        for (int i = 0; i < redPackConfigAry.length; i++) {
            moneryTotal = moneryTotal.add(redPackConfigAry[i].getAmount().multiply(new BigDecimal(redPackConfigAry[i].getNum())));
        }
        System.out.println(moneryTotal);

        double monryLess = Math.floor((remainMoney - moneryTotal.doubleValue()) * 100) / 100;
        while (monryLess > 0) {
            for (int i = 0; i < redPackConfigAry.length; i++) {
                if (monryLess >= redPackConfigAry[i].getAmount().doubleValue()) {
                    redPackConfigAry[i].setNum(redPackConfigAry[i].getNum() + 1);
                    monryLess = Math.floor((monryLess - redPackConfigAry[i].getAmount().doubleValue()) * 100) / 100;
                }
            }
        }
    }

}

class RedPackConfig {
    BigDecimal amount;
    double rate;
    int num;

    public RedPackConfig(BigDecimal amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
