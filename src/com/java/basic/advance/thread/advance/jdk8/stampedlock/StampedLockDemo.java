package com.java.basic.advance.thread.advance.jdk8.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock
 * ReadWriteLock 写锁是互斥的: 读-写
 *                           写-写
 */
public class StampedLockDemo {

    private int balance;

    private StampedLock stampedLock = new StampedLock();

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

    public void conditionReadWrite(int value) {
        // 首先判断 balance 的值是否符合更新的条件
        long stamp = stampedLock.readLock();
        if (balance > 0) {
            long writerStampedLock = stampedLock.tryConvertToWriteLock(stamp);
            if (writerStampedLock != 0) {
                // 成功转换为写锁
                stamp = writerStampedLock;
                balance += value;
            } else {
                // 没有转换成写锁，这里需要首先释放读锁，然后再拿到写锁
                stampedLock.unlockRead(stamp);
                // 获取写锁
                stamp = stampedLock.writeLock();
            }
        }
        stampedLock.unlock(stamp);
    }

    public static void main(String[] args) {

    }
}
