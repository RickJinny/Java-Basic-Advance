package com.java.basic.advance.thread.advance.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition的使用
 */
public class ConditionDemo {

    private int signal;

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public synchronized void aa() {
        lock.lock();
        while (signal != 0) {
            try {
                // 将A进入等待
                conditionA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("aa");
        signal++;
        // 叫醒B
        conditionB.signal();
        lock.unlock();
    }

    public void bb() {
        lock.lock();
        while (signal != 1) {
            try {
                conditionB.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("bb");
        signal++;
        conditionC.signal();
        lock.unlock();
    }

    public void cc() {
        lock.lock();
        while (signal != 2) {
            try {
                conditionC.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("cc");
        signal = 0;
        conditionA.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        RunnableA runnableA = new RunnableA(conditionDemo);
        RunnableB runnableB = new RunnableB(conditionDemo);
        RunnableC runnableC = new RunnableC(conditionDemo);

        new Thread(runnableA).start();
        new Thread(runnableB).start();
        new Thread(runnableC).start();
    }
}
