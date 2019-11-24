package com.java.basic.advance.thread.basics.lock;

/**
 * 死锁问题
 */
public class DeadLockTest {
    private Object object1 = new Object();
    private Object object2 = new Object();

    public void fun1() {
        synchronized (object1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println("fun1");
            }
        }
    }

    public void fun2() {
        synchronized (object2) {
            synchronized (object1) {
                System.out.println("fun2");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        new Thread(() -> {
            deadLockTest.fun1();
        }).start();
        new Thread(() -> {
            deadLockTest.fun2();
        }).start();
    }
}
