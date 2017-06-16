package com.zgf.Test.uml.relate;

/**
 * Created by zgf on 17/6/16.
 * <p>
 * 关联-自关联
 * UML表现形式为类使用实线箭头指向自身
 * JAVA表现形式为持有自身为成员变量
 */
public class TestSelfRelate {
    private TestSelfRelate nextRelate;
}
