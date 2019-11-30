package com.java.basic.advance.thread.advance.reentrantlock;

public class QueueObject {

    private boolean isNotified = false;

    /**
     * 等待方法：只要没有被叫醒，就一直等待。
     * @throws InterruptedException
     */
    public synchronized void doWait() throws InterruptedException {
        // 如果没有被唤醒，那么就继续等待
        while (!isNotified) {
            this.wait();
        }
        // 将isNotified设置为false
        this.isNotified = false;
    }

    /**
     * 唤醒方法
     */
    public synchronized void doNotify() {
        // 将isNotified设置为true
        this.isNotified = true;
        // 唤醒
        this.notify();
    }

    public boolean equals(Object object) {
        return this == object;
    }
}
