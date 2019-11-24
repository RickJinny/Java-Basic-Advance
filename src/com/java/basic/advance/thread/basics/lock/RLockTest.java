package com.java.basic.advance.thread.basics.lock;

/**
 * 重入锁例子
 */
public class RLockTest {

    public synchronized void fun1() {
        System.out.println("fun1");
        fun2();
    }

    public synchronized void fun2() {
        System.out.println("fun2");
    }

    public static void main(String[] args) {
        RLockTest rLockTest1 = new RLockTest();
        new Thread(() -> {
            rLockTest1.fun1();
        }).start();
    }
}
