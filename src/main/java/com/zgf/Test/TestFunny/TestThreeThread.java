package com.zgf.Test.TestFunny;

import java.util.concurrent.Semaphore;

public class TestThreeThread {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(1);
        new Thread(new Worker(semaphore1, semaphore3, "1", 10)).start();
        new Thread(new Worker(semaphore2, semaphore1, "2", 10)).start();
        new Thread(new Worker(semaphore3, semaphore2, "3", 10)).start();
    }
}

class Worker implements Runnable {
    private Semaphore semaphore;
    private Semaphore preSemaphore;
    private String var;
    private int count;

    public Worker(Semaphore semaphore, Semaphore preSemaphore, String var, int count) {
        this.semaphore = semaphore;
        this.preSemaphore = preSemaphore;
        this.var = var;
        this.count = count;
    }

    @Override
    public void run() {
        while (count > 0) {
            try {
                preSemaphore.acquire();
                System.out.println(var);
                count--;
                semaphore.release(1);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}


