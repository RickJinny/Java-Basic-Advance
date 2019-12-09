package com.java.basic.advance.thread.basics.producerconsumer;

public class PushRunnable implements Runnable {

    private Mall mall;

    public PushRunnable(Mall mall) {
        this.mall = mall;
    }

    @Override
    public void run() {
        while (true) {
            mall.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
