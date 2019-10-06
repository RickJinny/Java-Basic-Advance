package com.java.basic.advance.thread.basics;

import java.util.concurrent.Callable;

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
