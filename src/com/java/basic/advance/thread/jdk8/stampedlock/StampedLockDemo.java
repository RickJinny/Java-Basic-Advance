package com.java.basic.advance.thread.jdk8.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock
 * ReadWriteLock 写锁是互斥的: 读-写
 *                           写-写
 */
public class StampedLockDemo {

    private int balance;

    private StampedLock stampedLock = new StampedLock();

    public void optimisticRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int c = balance;
        // 这里可能会出现写操作, 因此要进行判断
        if (!stampedLock.validate(stamp)) {
            // 要从新读取
            long readStamp = stampedLock.readLock();
            c = balance;
            stamp = readStamp;
        }
        // 释放锁
        stampedLock.unlockRead(stamp);
    }

    private void read() {
        long stamp = stampedLock.readLock();
        // 拿到乐观锁
        long tryOptimisticRead = stampedLock.tryOptimisticRead();

        int b = balance;
        // ...
        stampedLock.unlockWrite(stamp);
    }

    private void write(int value) {
        long stamp = stampedLock.writeLock();
        balance += value;
        stampedLock.unlockWrite(stamp);
    }

    public static void main(String[] args) {

    }
}
