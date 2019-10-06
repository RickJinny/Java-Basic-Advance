package com.java.basic.advance.thread.basics;

public class MyRunnableTest {

    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable("Runnable1");
        MyRunnable mr2 = new MyRunnable("Runnable2");
        MyRunnable mr3 = new MyRunnable("Runnable3");
        MyRunnable mr4 = new MyRunnable("Runnable4");

        Thread thread1 = new Thread(mr1);
        Thread thread2 = new Thread(mr2);
        Thread thread3 = new Thread(mr3);
        Thread thread4 = new Thread(mr4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
