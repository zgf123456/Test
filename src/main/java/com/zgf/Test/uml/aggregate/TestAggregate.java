package com.zgf.Test.uml.aggregate;

/**
 * Created by zgf on 17/6/16.
 * <p>
 * 聚合
 * UML表现形式为聚合类实线指向被聚合类，实线在被聚合类边使用箭头，在聚合类边使用空心菱形
 * JAVA表现形式为被聚合类作为聚合类的成员变量
 */
public class TestAggregate {

    private Aggregate1 aggregate1;
    private Aggregate2 aggregate2;
    private Aggregate3 aggregate3;

    public TestAggregate(Aggregate1 aggregate1, Aggregate2 aggregate2, Aggregate3 aggregate3) {
        this.aggregate1 = aggregate1;
        this.aggregate2 = aggregate2;
        this.aggregate3 = aggregate3;
    }


    public static void main(String[] args) {
        Aggregate1 aggregate1 = new Aggregate1();
        Aggregate2 aggregate2 = new Aggregate2();
        Aggregate3 aggregate3 = new Aggregate3();
        TestAggregate testAggregate = new TestAggregate(aggregate1, aggregate2, aggregate3);
    }
}

class Aggregate1 {

}

class Aggregate2 {

}

class Aggregate3 {

}


