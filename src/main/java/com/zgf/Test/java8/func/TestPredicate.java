package com.zgf.Test.java8.func;

import java.util.function.Predicate;

/**
 * Predicate 函数接口，断言，输入T，返回boolean
 *
 * @author zgf
 * @date 2021-03-31 下午6:03
 */
public class TestPredicate {
    public static void main(String[] args) {
        // 基本用法
        Predicate<Integer> p = (x) -> x > 5;
        System.out.println(p.test(1));
        System.out.println(p.test(2));
        System.out.println(p.test(5));
        System.out.println(p.test(6));

        // p.negate() 获得一个取反的函数
        System.out.println(p.negate().test(3));

        // p.or 获得一个新函数，并集
        System.out.println(p.or((x) -> x < 3).test(3));

        // p.and 获得一个新函数，交集
        System.out.println(p.and(x -> x < 10).test(9));
    }
}
