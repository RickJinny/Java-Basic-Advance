package com.java.basic.advance.thread.basics.lock;

public class RLockTest {

    public synchronized void fun1() {
        System.out.println("fun1");
//        fun2();
    }

    public synchronized void fun2() {
        System.out.println("fun2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RLockTest rLockTest1 = new RLockTest();
        RLockTest rLockTest2 = new RLockTest();
        new Thread(() -> {
            rLockTest1.fun1();
        }).start();

        new Thread(() -> {
            rLockTest2.fun2();
        }).start();
    }
}
