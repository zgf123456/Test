package com.zgf.Test.java8.stream.middle;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 下午2:54
 */
public class TestDistintLimitSorted {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 4, 3, 2, 1)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(x -> System.out.println(x));

        System.out.println("=====");
        Stream.of(1, 2, 3, 4, 5, 6, 4, 3, 2, 1)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(x -> System.out.println(x));
    }
}
