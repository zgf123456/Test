package com.zgf.Test.java8.stream.end;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * 规约化操作，合并成一个值
 *
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestReduce {
    public static void main(String[] args) {
        // 最大值
        Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .reduce(BinaryOperator.maxBy(Comparator.naturalOrder()));
        System.out.println(reduce.get());

        // 累加
        Optional<Integer> reduce1 = Stream.iterate(1, x -> x + 1).limit(100)
                .reduce((x, y) -> x + y);
        System.out.println(reduce1.get());

        // 累加1
        Integer reduce2 = Stream.iterate(1, x -> x + 1).limit(100)
                .reduce(100, (x, y) -> x + y);
        System.out.println(reduce2);

        // 累加2，combiner的作用在于并行时，再每一个并行里面，提前计算结果
        Integer reduce3 = Stream.iterate(1, x -> x + 1).limit(10000)
                .parallel()
                .reduce(100, (x, y) -> x + y, (x, y) -> x + y);
        System.out.println(reduce3);

        // 分析内部的执行信息，使用了ForkJoinPool
        Integer reduce4 = Stream.iterate(1, x -> x + 1).limit(10000)
                .parallel()  // 这个如果注释掉，是没有走combiner过程的
                .reduce(100, (x, y) -> x + y, (x, y) -> {
                    System.out.println(String.format("x=%s,y=%s,thread=%s", x, y, Thread.currentThread()));
                    return x + y;
                });
        System.out.println(reduce4);
    }
}
