package com.zgf.Test.TestFunny;

import java.util.Arrays;
import java.util.Random;

public class TestMoney {
    public static void main(String[] args) {
        int maxMoney = 100;
        int min = 10, max = 20;
        int peopleNum = 8;

        // base
        int sendMoney = 0;
        int[] peopleMoneyArray = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            peopleMoneyArray[i] = min;
            sendMoney += min;
        }

        Random random = new Random();
        for (int m = sendMoney + 1; m <= maxMoney; m++) {
            boolean isSend = false;
            while (!isSend) {
                int rnd = random.nextInt(peopleNum);
                if (peopleMoneyArray[rnd] >= max) {
                    continue;
                }

                peopleMoneyArray[rnd] = peopleMoneyArray[rnd] + 1;
                isSend = true;
            }
        }

        System.out.println(Arrays.toString(peopleMoneyArray));
    }
}
