package com.java.basic.advance.thread.advance.happensbefore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * happens-before
 */
public class HappensBeforeDemo2 {

    private Lock lock = new ReentrantLock();

    public void aa() {
        lock.lock();
        System.out.println("aa");
        lock.unlock(); // 1 解锁
    }

    public void bb() {
        lock.lock(); // 2 加锁
        System.out.println("bb");
        lock.unlock();
    }
}
