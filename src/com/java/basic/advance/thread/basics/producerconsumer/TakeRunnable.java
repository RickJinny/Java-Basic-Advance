package com.java.basic.advance.thread.basics.producerconsumer;

public class TakeRunnable implements Runnable {

    private Mall mall;

    public TakeRunnable(Mall mall) {
        this.mall = mall;
    }

    @Override
    public void run() {
        while (true) {
            mall.take();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
