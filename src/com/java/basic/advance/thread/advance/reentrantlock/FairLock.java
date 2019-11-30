package com.java.basic.advance.thread.advance.reentrantlock;

import java.util.ArrayList;
import java.util.List;

/**
 * 公平锁：公平是针对锁的获取而言的，如果一个锁是公平的，那么锁的获取顺序就应该符合请求的绝对时间顺序。
 * 如何保证锁，先来的先获取，后来的后获取？这里面我们就需要维护一个线程队列。
 */
public class FairLock {

    private boolean isLocked = false;
    private Thread lockingThread = null;
    /**
     * 维护一个队列，来了线程，加锁，我们就将其放到队列里面。
     */
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        // 创建一个QueueObject对象
        QueueObject queueObject = new QueueObject();
        synchronized (this) {
            // 将queueObject加入到等待队列waitingThreads中
            waitingThreads.add(queueObject);
        }

        try {
            queueObject.doWait();
        } catch (Exception e) {
            synchronized (this) {
                waitingThreads.remove(queueObject);
            }
            throw e;
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock.");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}
