package com.zgf.Test.java8.stream.end.collect;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestCollect {
    public static void main(String[] args) {
        // 预定义收集器
//        Collectors.toList();
//        Collectors.toSet();
//        Collectors.toCollection(ArrayList::new); // 自定义结果结合
//        Collectors.toCollection(PriorityQueue::new); // 自定义结果结合
//        Collectors.toMap() 有三个重载方法：
//        toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper);
//        toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper,
//                BinaryOperator<U> mergeFunction);
//        toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper,
//                BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier);

//        参数含义分别是：
//        keyMapper：Key 的映射函数
//        valueMapper：Value 的映射函数
//        mergeFunction：当 Key 冲突时，调用的合并方法
//        mapSupplier：Map 构造器，在需要返回特定的 Map 时使用


        // 按5的倍数分组
        Map<Integer, Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .collect(Collectors.toMap((Integer x) -> x % 5, x -> x, (x, y) -> x + y));
        collect.entrySet().stream()
                .forEach(x -> System.out.println(x.getKey() + "=" + x.getValue()));
//        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    }
}
