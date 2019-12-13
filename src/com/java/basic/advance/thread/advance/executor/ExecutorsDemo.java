package com.java.basic.advance.thread.advance.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        /**
         * 10个线程来处理大量的任务
         * 通过工厂类Executors，来创建线程池
         */
        ExecutorService pool = Executors.newFixedThreadPool(10);
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
