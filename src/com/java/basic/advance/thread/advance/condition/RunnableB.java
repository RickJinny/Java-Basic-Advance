package com.java.basic.advance.thread.advance.condition;

public class RunnableB implements Runnable {

    private ConditionDemo conditionDemo;

    public RunnableB(ConditionDemo conditionDemo) {
        this.conditionDemo = conditionDemo;
    }

    @Override
    public void run() {
        while (true) {
            conditionDemo.bb();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
