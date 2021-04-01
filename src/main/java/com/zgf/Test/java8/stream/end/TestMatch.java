package com.zgf.Test.java8.stream.end;

import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestMatch {
    public static void main(String[] args) {
        // 全部不匹配
        boolean b = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .noneMatch(x -> x > 10);
        System.out.println(b);

        boolean b1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .noneMatch(x -> x > 5);
        System.out.println(b1);

        // 全部匹配
        boolean b2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .allMatch(x -> x < 10);
        System.out.println(b2);

        boolean b3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .allMatch(x -> x < 5);
        System.out.println(b3);

        // 部分匹配
        boolean b4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .anyMatch(x -> x > 5);
        System.out.println(b4);
    }
}
