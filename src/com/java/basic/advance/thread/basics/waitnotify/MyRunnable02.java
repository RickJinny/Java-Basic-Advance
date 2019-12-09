package com.java.basic.advance.thread.basics.waitnotify;

public class MyRunnable02 implements Runnable {

    private ThreadWaitNotifyDemo3 demo3;

    public MyRunnable02(ThreadWaitNotifyDemo3 demo3) {
        this.demo3 = demo3;
    }

    @Override
    public void run() {
        demo3.getSignal();
    }
}
