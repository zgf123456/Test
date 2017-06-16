package com.zgf.Test.uml.compose;

/**
 * Created by zgf on 17/6/16.
 * <p>
 * 组合
 * UML表现形式为组合类实线指向被组合类，实线在被聚合类边使用箭头，在聚合类边使用实心菱形
 * JAVA表现形式为被组合类作为组合类的成员变量
 *
 *
 * 注意区分组合与聚合的区别
 */
public class TestCompose {
    private Compose1 compose1;
    private Compose2 compose2;

    public TestCompose() {
        compose1 = new Compose1();
        compose2 = new Compose2();
    }
}

class Compose1 {

}

class Compose2 {

}
