package com.java.basic.advance.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {

    public static void main(String[] args) {
        // 创建带有10个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            // 执行线程
            threadPool.execute(() ->
                    System.out.println(Thread.currentThread().getName())
            );
        }

        // 将线程销毁，执行完就会停掉线程池
        threadPool.shutdown();
    }
}
