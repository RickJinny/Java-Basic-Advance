package com.java.basic.advance.thread.advance.condition.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<E> {

    private Object[] obj;
    private int addIndex;
    private int removeIndex;
    private int queueSize;
    private Lock lock = new ReentrantLock();
    Condition addCondition = lock.newCondition();
    Condition removeCondition = lock.newCondition();

    public MyQueue(int count) {
        this.obj = new Object[count];
    }

    public void add(E e) {
        // 加锁
        lock.lock();
        while (queueSize == obj.length) {
            try {
                addCondition.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        obj[addIndex++] = e;

        if (++addIndex == obj.length - 1) {
            addIndex = 0;
        }
        queueSize++;
        removeCondition.signal();
        // 释放锁
        lock.unlock();
    }

    public void remove() {
        lock.lock();
        while (queueSize == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "队列为空, 不进行移除");
                removeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        obj[removeIndex] = null;
        if (++removeIndex == obj.length) {
            removeIndex = 0;
        }
        queueSize--;
        addCondition.signal();
        lock.unlock();
    }
}
