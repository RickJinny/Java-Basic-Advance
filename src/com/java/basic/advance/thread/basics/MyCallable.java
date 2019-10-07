package com.java.basic.advance.thread.basics;

import java.util.concurrent.Callable;

/**
 * 在Java5之前，线程是没有返回值;
 * 在Java5之后，Java有了可返回值的任务，即实现了Callable接口的任务，
 * 执行Callable的任务之后可获取一个Future的对象，用该对象调用get方法，就可以获取到Callable任务返回的Object。
 *
 * 通过Callable接口的方式获取线程的返回值，主要有两种方式去实现：
 * 第一种方式：通过FutureTask这个类去获取；
 * 第二种方式：通过线程池去获取。
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "我是call方法的返回值";
        System.out.println("start work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
