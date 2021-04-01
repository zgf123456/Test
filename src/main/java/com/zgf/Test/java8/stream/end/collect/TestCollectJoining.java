package com.zgf.Test.java8.stream.end.collect;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 字符串连接器
 *
 * @author zgf
 * @date 2021-04-01 下午3:16
 */
public class TestCollectJoining {
    public static void main(String[] args) {
        String collect = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
                .collect(Collectors.joining());
        System.out.println(collect);

        // 分隔符
        String collect1 = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
                .collect(Collectors.joining(","));
        System.out.println(collect1);

        // 分隔符，开头，结尾
        String collect2 = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect2);
    }
}
