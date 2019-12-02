package com.java.basic.advance.thread.advance.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量
 */
public class SemaphoreDemo {

    public void sem(Semaphore semaphore) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is run ...");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        semaphore.release();
    }

    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        Semaphore semaphore = new Semaphore(10);
        while (true) {
            new Thread(() -> {
                semaphoreDemo.sem(semaphore);
            }).start();
        }
    }
}
