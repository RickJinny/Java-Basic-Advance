package com.java.basic.advance.thread.basics.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性解决线程安全性问题
 * AtomicInteger
 */
public class Sequence {

    private AtomicInteger value = new AtomicInteger(0);

    public int getNext() {
        return value.getAndDecrement();
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
    }
}
