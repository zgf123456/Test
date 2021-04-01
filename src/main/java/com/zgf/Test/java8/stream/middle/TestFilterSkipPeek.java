package com.zgf.Test.java8.stream.middle;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 下午2:54
 */
public class TestFilterSkipPeek {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 4, 3, 2, 1)
                .skip(4)
                .filter(x -> x > 3)
//                .skip(1)
                .forEach(x -> System.out.println(x));

        System.out.println("=====");
        Stream.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{4, 3, 2, 1})
                .peek(x -> x[0] += 1)
                .forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
