package com.zgf.Test.java8.stream.end.collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分区收集
 *
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestCollectPartitioningBy {
    public static void main(String[] args) {
        // 分区收集 - 结果key只有两个true,false。可以看做一个简化版的groupingBy
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.partitioningBy(x -> x % 3 == 0));
        System.out.println(collect);

        // 分区收集 - 统计
        Map<Boolean, Long> collect1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.partitioningBy(x -> x % 3 == 0, Collectors.counting()));
        System.out.println(collect1);

        // 分区收集 - 嵌套-层级收集，可以无限嵌套
        Map<Boolean, Map<Boolean, List<Integer>>> collect2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.partitioningBy(x -> x % 3 == 0, Collectors.partitioningBy(x -> x % 2 == 0)));
        System.out.println(collect2);
    }
}
