package com.java.basic.advance.thread.basics.threadvolatile;

/**
 * 保证可见性的前提
 * 多个线程拿到的是同一把锁，否则是保证不了的
 */
public class MySynchronizedVisibilityTest {

    private int a = 1;

    public synchronized int getA() {
        return a;
    }

    public synchronized void setA(int a) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a = a;
    }

    public static void main(String[] args) {
        MySynchronizedVisibilityTest my = new MySynchronizedVisibilityTest();
        new Thread(() -> {
            my.setA(10);
        }).start();

        new Thread(() -> {
            System.out.println(my.getA());
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的结果是: " + my.getA());
    }
}
