package com.zgf.Test.java8.stream.end;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestMinMaxCount {
    public static void main(String[] args) {
        long count = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .count();
        System.out.println(count);

        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        Optional<Integer> min = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .min(Comparator.naturalOrder());
        System.out.println(min.get());
    }
}
