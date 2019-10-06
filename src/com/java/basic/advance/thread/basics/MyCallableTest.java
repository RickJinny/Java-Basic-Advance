package com.java.basic.advance.thread.basics;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建 MyCallable 对象
        MyCallable callable = new MyCallable();
        // 使用 FutureTask 类来包装 Callable 对象，因为 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 执行线程
        new Thread(futureTask,"线程futureTask").start();
        // 如果task子线程任务没有执行完成，则打印task has not finish, please wait !
        if (!futureTask.isDone()) {
            System.out.println("task has not finish, please wait !");
        }
        // task子线程任务执行完成之后，调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值
        System.out.println("task return : " + futureTask.get());
    }
}
