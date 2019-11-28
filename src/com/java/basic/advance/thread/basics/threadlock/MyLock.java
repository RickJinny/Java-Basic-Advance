package com.java.basic.advance.thread.basics.threadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 */
public class MyLock implements Lock {

    /**
     * 定义一个标志位，判断是否已经拿到锁了
     */
    private boolean isLocked = false;

    private Thread lockBy = null;

    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        //
        Thread currentThread = Thread.currentThread();

        while (isLocked && currentThread != lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0) {
                notify();
                isLocked = false;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
