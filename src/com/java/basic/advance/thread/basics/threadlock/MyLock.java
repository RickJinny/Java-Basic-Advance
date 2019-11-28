package com.java.basic.advance.thread.basics.threadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 重入锁
 */
public class MyLock implements Lock {

    /**
     * 定义一个标志位，判断是否已经拿到锁了
     */
    private boolean isLocked = false;

    /**
     * 用于记录当前的线程
     */
    private Thread lockBy = null;

    /**
     * 用于记录锁的数量
     */
    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        // 获取当前的Thread
        Thread currentThread = Thread.currentThread();

        /**
         * 判断isLocked是否为true;
         * 还有判断当前访问的线程和存储的线程不一样的话，就要等待。如果要相等了，我们要维护计算器lockCount
         */
        while (isLocked && currentThread != lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 将 isLocked 设置为 true
        isLocked = true;
        // 将 lockBy 设置为当前的线程
        lockBy = currentThread;
        // 锁的数量自增1
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        // 如果 lockBy 和当前的线程是相等的
        if (lockBy == Thread.currentThread()) {
            // 锁的数量自减1
            lockCount--;
            // 当锁的数量等于0的时候
            if (lockCount == 0) {
                // 唤醒线程
                notify();
                // 将 isLocked 设置为 false
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
