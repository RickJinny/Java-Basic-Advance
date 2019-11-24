package com.java.basic.advance.thread.basics.createthread;

import java.util.concurrent.*;

/**
 *  * 通过Callable接口的方式获取线程的返回值，主要有两种方式去实现：
 *  * 第一种方式：通过FutureTask这个类去获取；
 *  * 第二种方式：通过线程池去获取。
 */
public class MyCallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *  第一种方式：通过FutureTask这个类去获取；
         */
        // 创建 MyCallable 对象
        MyCallable callable = new MyCallable();
        // 使用 FutureTask 类来包装 Callable 对象，因为 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 执行线程
        new Thread(futureTask,"线程futureTask").start();
        // 如果task子线程任务没有执行完成，则打印task has not finish, please wait !
        if (!futureTask.isDone()) {
            System.out.println("FutureTask: task has not finish, please wait !");
        }
        // task子线程任务执行完成之后，调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值
        System.out.println("通过FutureTask获取线程的返回值是: " + futureTask.get());


        /**
         * 第二种方式：通过线程池去获取。
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<String> future = threadPool.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("ExecutorService: task has not finish , please wait!");
        }

        try {
            System.out.println("通过线程池ExecutorService获取线程的返回值是: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭掉线程池
            threadPool.shutdown();
        }
    }
}
