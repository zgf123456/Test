package com.zgf.Test.nio.selector;

import java.nio.channels.Selector;

/**
 * Created by zgf on 17/6/6.
 */
public class TestSelector {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        System.out.println(selector.keys());
        System.out.println(selector.selectedKeys());
        System.out.println(selector.isOpen());
    }
}
