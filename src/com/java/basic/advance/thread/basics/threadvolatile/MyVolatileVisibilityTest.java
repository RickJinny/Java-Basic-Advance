package com.java.basic.advance.thread.basics.threadvolatile;

/**
 * 使用 volatile 对多个线程修改变量，来保证变量的可见性
 */
public class MyVolatileVisibilityTest {

    // volatile对多个线程修改变量，来保证变量的可见性
    private volatile int b = 1;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        MyVolatileVisibilityTest myVolatileVisibilityTest = new MyVolatileVisibilityTest();
        new Thread(() -> {
            myVolatileVisibilityTest.setB(10);
        }).start();

        new Thread(() -> {
            System.out.println(myVolatileVisibilityTest.getB());
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的结果是: " + myVolatileVisibilityTest.getB());
    }
}
