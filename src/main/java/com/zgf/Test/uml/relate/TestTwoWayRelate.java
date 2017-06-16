package com.zgf.Test.uml.relate;

/**
 * Created by zgf on 17/6/16.
 * <p>
 * 关联-双向关联
 * UML表现形式为实线连接两个类，实线在两边都使用箭头
 * JAVA表现形式为两个类互为对方的成员变量
 */
public class TestTwoWayRelate {
    private TwoWayRelate twoWayRelate;
}

class TwoWayRelate {
    private TestTwoWayRelate testTwoWayRelate;
}