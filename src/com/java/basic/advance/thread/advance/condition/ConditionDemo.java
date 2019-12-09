package com.java.basic.advance.thread.advance.condition;

/**
 * Condition的使用
 */
public class ConditionDemo {

    private int signal;

    public synchronized void aa() {
        while (signal != 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("aa");
        signal++;
        notifyAll();
    }

    public synchronized void bb() {
        while (signal != 1) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("bb");
        signal++;
        notifyAll();
    }

    public synchronized void cc() {
        while (signal != 2) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("cc");
        signal = 0;
        notifyAll();
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
