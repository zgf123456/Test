package com.zgf.Test.java8.stream.end.collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分类收集
 *
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestCollectGroupingBy {
    public static void main(String[] args) {
        // 分类收集
        Map<Integer, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.groupingBy(x -> x % 2));
        System.out.println(collect);

        // 分类二次收集 - 统计
        Map<Integer, Long> collect1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.groupingBy(x -> x % 2, Collectors.counting()));
        System.out.println(collect1);

        // 分类二次收集 - 嵌套-层级收集，可以无限嵌套
        Map<Integer, Map<Integer, List<Integer>>> collect2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.groupingBy(x -> x % 5, Collectors.groupingBy(x -> x % 2)));
        System.out.println(collect2);

        // 第三个重载里面的 Supplier<M> mapFactory, 这里的作用用于自定义结果集合类型
    }
}
