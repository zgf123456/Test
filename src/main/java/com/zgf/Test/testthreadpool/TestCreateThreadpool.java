package com.zgf.Test.testthreadpool;

import java.util.concurrent.*;

public class TestCreateThreadpool {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);

        TestCreateThreadpool testCreateThreadpool = new TestCreateThreadpool();
//        testCreateThreadpool.testScheduledThreadPool();
//        testCreateThreadpool.testCachedThreadPool();
        testCreateThreadpool.testCustomerThreadPool();
    }

    /**
     * 自定义线程池
     */
    private void testCustomerThreadPool() {
//        new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS //
                , new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.AbortPolicy());

        // 测试拒绝策略
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    private void testCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
                }
            });
        }
    }

    private void testScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("FixedDelay-" + Thread.currentThread().getName());
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
