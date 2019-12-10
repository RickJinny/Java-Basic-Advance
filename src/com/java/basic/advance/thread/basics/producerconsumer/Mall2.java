package com.java.basic.advance.thread.basics.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mall2 {

    private int count;

    private Lock lock = new ReentrantLock();
    Condition pCondition = lock.newCondition();
    Condition tCondition = lock.newCondition();

    public final int MAX_COUNT = 10;

    public void push() {
        lock.lock();
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存数量达到上限，生产者停止生产。");
                pCondition.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产，当前库存为: " + count);
        tCondition.signal();
        lock.unlock();
    }

    public void take() {
        lock.lock();
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存数量为零，消费者等待。");
                tCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + " 消费者消费，当前库存为: " + count);
        pCondition.signal();
        lock.unlock();
    }
}
