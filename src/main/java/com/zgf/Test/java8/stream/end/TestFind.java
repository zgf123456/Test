package com.zgf.Test.java8.stream.end;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestFind {
    public static void main(String[] args) {
        Optional<Integer> any = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .findAny();
        System.out.println(any.get());

        Optional<Integer> any1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .parallel()
                .findAny();
        System.out.println(any1.get());

        Optional<Integer> first = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .findFirst();
        System.out.println(first.get());

        Optional<Integer> first1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .parallel()
                .findFirst();
        System.out.println(first1.get());
    }
}
