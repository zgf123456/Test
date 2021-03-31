package com.zgf.Test.java8.func;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * Supplier  函数接口，内容提供者，无输入，返回T
 *
 * @author zgf
 * @date 2021-03-31 下午6:03
 */
public class TestSupplier {
    public static void main(String[] args) {
        // 基本用法
        AtomicInteger x = new AtomicInteger();
        Supplier<Integer> p = () -> {
            return x.incrementAndGet();
        };

        System.out.println(p.get());
        System.out.println(p.get());
        System.out.println(p.get());
    }
}
