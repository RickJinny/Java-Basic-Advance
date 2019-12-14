package com.java.basic.advance.thread.advance.happensbefore;

public class VolatileDemo {

    private int a;

    private volatile boolean flag;

    public void writer() {
        a = 1; // 1
        flag = true; // 2 当写一个volatile变量时，Java内存模型会把该线程对应的本地内存中的共享变量值刷新到内存中
    }

    public void reader() {
        if (flag) { // 3
            int b = a + 1; // 4
            System.out.println(b); //5
        }
    }
}
