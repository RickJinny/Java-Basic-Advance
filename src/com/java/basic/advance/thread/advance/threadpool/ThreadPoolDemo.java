package com.java.basic.advance.thread.advance.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,
                                                            20,
                                                               10,
                                                                TimeUnit.SECONDS,
                                            new ArrayBlockingQueue<>(10));

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    atomicInteger.getAndDecrement();
                }
            });
        }
        threadPool.shutdown();

        while (Thread.activeCount() > 1) {

        }
        System.out.println(atomicInteger.get());
    }
}
