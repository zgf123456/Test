package com.zgf.Test.java8.stream.middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 上午11:40
 */
public class TestMap {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        List<Integer> collect = integerStream.map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(collect);

        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        double[] doubles = integerStream1.mapToDouble(x -> x * 2)
                .toArray();
        System.out.println(Arrays.toString(doubles));

        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        integerStream2.map(x -> x * x)
                .forEach(x -> System.out.println(x));

        // forEachOrdered，用于并行的场景，使得结果有序
        Stream<Integer> integerStream3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        integerStream3.parallel().map(x -> x * x)
                .forEachOrdered(x -> System.out.println(x));
    }
}
