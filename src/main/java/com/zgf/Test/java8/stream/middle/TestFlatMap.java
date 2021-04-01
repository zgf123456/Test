package com.zgf.Test.java8.stream.middle;

import java.util.stream.Stream;

/**
 * 扁平化，将二维降为一维
 *
 * @author zgf
 * @date 2021-04-01 下午2:54
 */
public class TestFlatMap {
    public static void main(String[] args) {
        Stream.of("a-b-c-d", "e-f-i-g-h")
                .flatMap(e -> Stream.of(e.split("-")))
                .forEach(e -> System.out.println(e));
    }
}
