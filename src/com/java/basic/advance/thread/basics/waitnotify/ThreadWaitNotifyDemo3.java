package com.java.basic.advance.thread.basics.waitnotify;

import java.util.concurrent.TimeUnit;

public class ThreadWaitNotifyDemo3 {

    private volatile int signal;

    public synchronized int getSignal() {
        System.out.println(Thread.currentThread().getName() + " 方法执行了...");
        if (signal != 1) {
            try {
                // 调用wait的时候，会释放掉锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 方法执行完毕...");
        return signal;
    }

    public synchronized void setSignal() {
        this.signal = 1;
        // notify会随机叫醒一个处于wait状态的线程，会拿到锁
        notify();
        // notifyAll叫醒所有的处于wait的线程，争夺时间片的线程只有一个
//        notifyAll();

        System.out.println("叫醒线程，叫醒之后休眠开始...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadWaitNotifyDemo3 demo = new ThreadWaitNotifyDemo3();
        MyRunnable01 myRunnable01 = new MyRunnable01(demo);
        MyRunnable02 myRunnable02 = new MyRunnable02(demo);

        new Thread(myRunnable02).start();
        new Thread(myRunnable02).start();
        new Thread(myRunnable02).start();
        new Thread(myRunnable02).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(myRunnable01).start();
    }
}
