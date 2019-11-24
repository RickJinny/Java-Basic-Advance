package com.java.basic.advance.thread.basics.threadvolatile;

/**
 * volatile有用的场景：
 * 有2个线程，在执行一个任务。当第1线程执行完毕之后，才会通知第2个线程执行。这里面使用volatile来实现。
 */
public class MyVolatileVisibilityTest2 {

    private volatile boolean run = false;

    public static void main(String[] args) {
        MyVolatileVisibilityTest2 my = new MyVolatileVisibilityTest2();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("执行了第 " + i + " 次");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            my.run = true;
        }).start();

        new Thread(() -> {
            while (!my.run) {
                // 不执行

            }
            System.err.println("线程2执行了...");
        }).start();
    }
}
