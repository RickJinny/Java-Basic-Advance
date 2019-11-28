package com.java.basic.advance.thread.basics.threadlock;

public class MySequence {

    private MyLock myLock = new MyLock();

    private int value;

    public int getNext() {
        myLock.lock();
        value++;
        myLock.unlock();
        return value;
    }

    public static void main(String[] args) {
        MySequence mySequence = new MySequence();

        new Thread(() -> {
            while (true) {
                System.out.println(mySequence.getNext());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(mySequence.getNext());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(mySequence.getNext());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(mySequence.getNext());
            }
        }).start();
    }
}
