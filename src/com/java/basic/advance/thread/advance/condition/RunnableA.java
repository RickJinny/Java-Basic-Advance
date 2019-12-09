package com.java.basic.advance.thread.advance.condition;

public class RunnableA implements Runnable {

    private ConditionDemo conditionDemo;

    public RunnableA(ConditionDemo conditionDemo) {
        this.conditionDemo = conditionDemo;
    }

    @Override
    public void run() {
        while (true) {
            conditionDemo.aa();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
