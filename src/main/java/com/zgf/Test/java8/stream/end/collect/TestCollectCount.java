package com.zgf.Test.java8.stream.end.collect;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 计算
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestCollectCount {
    public static void main(String[] args) {
        // counting
        Long collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.counting());
        System.out.println(collect);

        // maxBy,minBy
        Optional<Integer> collect1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(collect1.get());

        // summingXXX
        Integer collect2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.summingInt(x -> x));
        System.out.println(collect2);

        // averagingXXX
        Double collect4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.averagingInt(x -> x));
        System.out.println(collect4);

        // summarizingXXX
        IntSummaryStatistics collect3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.summarizingInt(x -> x));
        System.out.println(collect3);
    }
}
