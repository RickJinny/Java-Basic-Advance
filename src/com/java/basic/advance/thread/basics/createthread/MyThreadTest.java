package com.java.basic.advance.thread.basics.createthread;

public class MyThreadTest {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Thread1");
        MyThread myThread2 = new MyThread("Thread2");
        MyThread myThread3 = new MyThread("Thread3");
        MyThread myThread4 = new MyThread("Thread4");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
    }
}
