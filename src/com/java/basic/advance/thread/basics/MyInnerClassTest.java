package com.java.basic.advance.thread.basics;

/**
 * 使用匿名内部类的方式创建线程
 */
public class MyInnerClassTest {

    public static void main(String[] args) {

        // 1、采用继承Thread的方式
        // 执行结果是：thread start ....
        new Thread(() ->
                System.out.println("thread start ....")
        ).start();

        // 2、采用Runnable的方式
        // 执行结果是：thread start runnable ...
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start runnable ...");
            }
        }).start();

        // 3、两种方式都采用的话
        // 执行结果是：sub
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("sub");
            }
        }.start();

    }
}
