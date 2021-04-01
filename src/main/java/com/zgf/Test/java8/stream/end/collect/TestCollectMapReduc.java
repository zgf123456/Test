package com.zgf.Test.java8.stream.end.collect;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * mapping reducing
 *
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestCollectMapReduc {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.mapping(x -> x * x, Collectors.partitioningBy(x -> x > 10)));
        System.out.println(collect);

        Optional<Integer> collect1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.reducing((x, y) -> x + y));
        System.out.println(collect1.get());
    }
}
