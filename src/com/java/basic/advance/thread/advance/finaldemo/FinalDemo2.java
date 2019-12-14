package com.java.basic.advance.thread.advance.finaldemo;

/**
 * final域
 */
public class FinalDemo2 {

    private final Object obj;

    private int a;

    private FinalDemo2 demo;

    public FinalDemo2() {
        obj = new Object();
    }

    public void writer() {
        demo = new FinalDemo2();
    }

    public void read() {
        FinalDemo2 demo2 = demo;
        if (demo2 != null) {

        }
    }
}
