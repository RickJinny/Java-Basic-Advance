package com.java.basic.advance.thread.advance.condition;

public class RunnableC implements Runnable {

    private ConditionDemo conditionDemo;

    public RunnableC(ConditionDemo conditionDemo) {
        this.conditionDemo = conditionDemo;
    }

    @Override
    public void run() {
        while (true) {
            conditionDemo.cc();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
