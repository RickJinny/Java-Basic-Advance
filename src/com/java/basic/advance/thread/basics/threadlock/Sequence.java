package com.java.basic.advance.thread.basics.threadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁，解决线程安全性问题
 */
public class Sequence {

    private int value;
    Lock lock = new ReentrantLock();

    public int getNext() {
        lock.lock();
        int n = value++;
        lock.unlock();
        return n;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
