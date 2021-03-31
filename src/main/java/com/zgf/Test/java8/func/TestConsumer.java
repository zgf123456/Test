package com.zgf.Test.java8.func;

import java.util.function.Consumer;

/**
 * Consumer  函数接口，消费者，输入T，无返回值
 *
 * @author zgf
 * @date 2021-03-31 下午6:03
 */
public class TestConsumer {
    public static void main(String[] args) {
        // 基本用法
        Consumer<Integer> p = (x) -> System.out.println(x);
        p.accept(1);

        // andThen 连续执行
        Consumer<Integer> p2 = p.andThen((x) -> System.out.println(x + 1));
        p2.accept(1);
    }
}
