package com.zgf.Test.nio;

import java.nio.CharBuffer;

/**
 * Created by zgf on 17/6/5.
 */
public class TestBuffer {
    /**
     * 待显示的字符串
     */
    private static String[] strs =
            {
                    "A random string value",
                    "The product of an infinite number of monkeys",
                    "Hey hey we're the monkees",
                    "Opening act for the Monkees:Jimi Hendrix",
                    "Scuse me while I kiss this fly",
                    "Help Me! Help Me!"
            };

    /**
     * 标识strs的下标索引
     */
    private static int index = 0;

    /**
     * 向Buffer内放置数据
     */
    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strs.length)
            return false;

        String str = strs[index++];
//        for (int i = 0; i < str.length(); i++) {
//            buffer.put(str.charAt(i));
//        }
        buffer.put(str);

        return true;
    }

    /**
     * 从Buffer内把数据拿出来
     */
    private static void drainBuffer(CharBuffer buffer) {
//        while (buffer.hasRemaining()) {
//            System.out.print(buffer.get());
//        }
//        System.out.println("");

        char[] chars = new char[buffer.length()];
        buffer.get(chars, buffer.position(), buffer.limit());
        System.out.println(chars);
    }

    public static void main(String[] args) {
        CharBuffer cb = CharBuffer.allocate(100);
        while (fillBuffer(cb)) {
            // flip()方法将一个能够继续添加数据元素的填充状态的缓冲区翻转成一个准备读出元素的释放状态，因此每次准备读出元素前，都必须调用一次filp()方法
            // flip 设置 position, limit, mark;
            cb.flip();
            drainBuffer(cb);
            // 调用clear()方法将所有属性回归原位，但是clear()方法并不会改变缓冲区中的任何数据
            // clear 只还原 position, limit, mark 成初始状态;
            cb.clear();
        }
    }
}
