package com.java.basic.advance.thread.advance.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 的使用
 *
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(100);
                return 1;
            }
        };

        /**
         * 创建一个 FutureTask 对象, 把它先放到线程中，使用的时候再拿出来。
         */
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        // 将FutureTask对象放入到 Thread 中
        Thread thread = new Thread(futureTask);
        // 开启线程
        thread.start();

        System.out.println(" 干点别的...");

        // 从futureTask中获取值
        Integer value = futureTask.get();

        System.out.println("从 futureTask 中获取值: " + value);
    }
}
