package com.java.basic.advance.thread.basics.producerconsumer;


public class MallTest {

    public static void main(String[] args) {
        Mall mall = new Mall();
        PushRunnable pushRunnable = new PushRunnable(mall);
        TakeRunnable takeRunnable = new TakeRunnable(mall);

        new Thread(pushRunnable).start();
        new Thread(pushRunnable).start();
        new Thread(pushRunnable).start();
        new Thread(pushRunnable).start();

        new Thread(takeRunnable).start();
        new Thread(takeRunnable).start();
        new Thread(takeRunnable).start();
        new Thread(takeRunnable).start();
    }
}
