package com.zgf.Test.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zgf on 16/11/26.
 * 中断测试
 */
public class TestInterrupt {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            private AtomicInteger index = new AtomicInteger();

            @Override
            public void run() {
                while (true) {
//                  中断处理方法1，中断判断
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupt");
                        break;
                    }
                    System.out.println(index.getAndIncrement());
//                  中断处理方法2，捕获异常
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        System.out.println("interrupt");
//                        break;
//                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
