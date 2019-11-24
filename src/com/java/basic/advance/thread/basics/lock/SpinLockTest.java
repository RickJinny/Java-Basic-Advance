package com.java.basic.advance.thread.basics.lock;

import java.util.Random;

/**
 * 自旋锁
 * 多个线程执行完毕之后，打印一句话，结束
 */
public class SpinLockTest {

    public static void main(String[] args) {
        /**
         * 第1个线程
         */
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行...");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 线程执行完毕...");
        }).start();

        /**
         * 第2个线程
         */
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行...");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 线程执行完毕...");
        }).start();

        /**
         * 第3个线程
         */
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行...");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 线程执行完毕...");
        }).start();

        /**
         * Thread.activeCount()
         * 当前活动线程的数量
         */
        while (Thread.activeCount() != 1) {
            // 自旋
        }
        System.out.println("所有的线程执行完毕了...");
    }
}
