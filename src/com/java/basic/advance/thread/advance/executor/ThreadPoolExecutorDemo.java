package com.java.basic.advance.thread.advance.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        // 10个线程来处理大量的任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<>());

        while (true) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
