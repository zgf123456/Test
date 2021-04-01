package com.zgf.Test.java8.stream.end;

import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 上午11:40
 */
public class TestForEach {
    public static void main(String[] args) {
        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        integerStream2.map(x -> x * x)
                .forEach(x -> System.out.println(x));

        // forEachOrdered，用于并行的场景，使得结果有序
        Stream<Integer> integerStream3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        integerStream3.parallel().map(x -> x * x)
                .forEachOrdered(x -> System.out.println(x));
    }
}
