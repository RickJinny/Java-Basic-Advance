package com.java.basic.advance.thread.advance.finaldemo;

/**
 * final域
 */
public class FinalDemo {

    private int a;
    private final int b;

    private FinalDemo() {
        a = 2;
        b = 8;
    }

    private FinalDemo demo;

    public void writer() {
        demo = new FinalDemo();
    }

    public void read() {
        int aa = demo.a;
        int bb = demo.b;
    }
}
