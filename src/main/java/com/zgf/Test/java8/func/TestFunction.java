package com.zgf.Test.java8.func;

import java.util.function.Function;

/**
 * Function  函数接口，函数，输入T，返回V
 *
 * @author zgf
 * @date 2021-03-31 下午6:03
 */
public class TestFunction {
    public static void main(String[] args) {
        // 基本用法
        Function<Integer, Integer> p = (x) -> x * x;
        Function<Integer, Integer> p1 = (x) -> x + 1;

        // compose - 前面执行
        Function<Integer, Integer> compose = p.compose(p1);
        System.out.println(compose.apply(3));

        // andThen 连续执行
        Function<Integer, Integer> andThen = p.andThen(p1);
        System.out.println(andThen.apply(3));

        // identity,用于快捷的构建起始function函数
        Function<Object, Object> identity = Function.identity();
        System.out.println(identity.apply(1));
    }
}
