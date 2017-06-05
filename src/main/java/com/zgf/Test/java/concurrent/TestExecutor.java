package com.zgf.Test.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zgf on 16/11/26.
 */
public class TestExecutor {
    public static void main(String[] args) throws InterruptedException {
//        Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Executors.newSingleThreadExecutor();

// 带定时器功能的 线程执行器
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("isInterrupted");
                } else {
                    System.out.println("test");
                }
            }
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(5000);

        scheduledExecutorService.shutdownNow();
        System.out.println("shutdown");


    }
}
