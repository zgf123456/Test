package com.zgf.Test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream创建
 *
 * @author zgf
 * @date 2021-03-30 下午4:18
 */
public class TestStreamCteate {
    public static void main(String[] args) {
        // 1. 通过 java.util.Collection.stream() 方法用集合创建流
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        // 非并行和并行
        Stream<Integer> stream = integerList.stream();
        Stream<Integer> stream1 = integerList.parallelStream();
        // 非并行转并行
        Stream<Integer> parallel = integerList.stream().parallel();

        // 2. 使用java.util.Arrays.stream(T[] array)方法用数组创建流
        IntStream stream2 = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});

        // 3. 使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        // 遍历器
        Stream<Integer> limit = Stream.iterate(0, (x) -> {
            return x + 1;
        }).limit(10);
        System.out.println(Arrays.toString(limit.toArray()));

        Stream<Double> limit1 = Stream.generate(Math::random).limit(10);
        System.out.println(Arrays.toString(limit1.toArray()));
    }

}
