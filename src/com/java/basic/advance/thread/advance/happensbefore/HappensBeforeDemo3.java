package com.java.basic.advance.thread.advance.happensbefore;

/**
 * happens-before
 */
public class HappensBeforeDemo3 {

    public void aa() {
        System.out.println("aa");
        // 1、启动另外一个线程的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bb"); // 2
            }
        }).start();
    }

    public static void main(String[] args) {
        new HappensBeforeDemo3().aa();
    }
}
