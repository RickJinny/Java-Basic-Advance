package com.java.basic.advance.thread.advance.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private AsyncHelper asyncHelper = new AsyncHelper();

    /**
     * 将子类定义为非公共内部帮助器类，可用它来实现其封闭类的同步属性。
     * 在适当的时候，可以通过具体的锁和相关同步器来调用他们，以实现其公共方法。
     */
    private class AsyncHelper extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            // 如果第一个线程进来，可以拿到锁，因此我们可以返回true
            // 如果第二个线程进来，拿不到锁，返回false
            // 如何判断是第一个线程，还是第二线程进来
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    // 把当前的线程set进来
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }

            int state = getState() - arg;
            boolean flag = false;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        asyncHelper.acquire(1);
    }

    @Override
    public void unlock() {
        asyncHelper.release(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        asyncHelper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return asyncHelper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return asyncHelper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public Condition newCondition() {
        return asyncHelper.newCondition();
    }
}
