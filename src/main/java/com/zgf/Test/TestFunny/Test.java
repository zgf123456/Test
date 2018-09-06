package com.zgf.Test.TestFunny;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int s1 = 0;
        int s2 = 0;
        for (int i = 1; i <= 14; i++) {
            int s = i * i * 100;
            list.add(i * i * 100);

            if(i <= 11) {
                s1 += s;
            } else {
                s2 += s;
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(s1);
        System.out.println(s2);
    }
}
