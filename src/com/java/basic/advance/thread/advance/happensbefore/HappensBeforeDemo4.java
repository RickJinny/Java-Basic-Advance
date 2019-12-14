package com.java.basic.advance.thread.advance.happensbefore;

/**
 * 一、锁的内存语义
 *    锁的释放与获取所建立的 happens - before 关系。
 *    锁的释放和获取的内存语义。
 *
 * 程序次序规则：监视器规则、传递性
 *
 */
public class HappensBeforeDemo4 {

    private int value;

    public synchronized void aa() { // 1 获取锁
        value++; // 2
    } // 3 释放锁

    public synchronized void bb() { // 4 获取锁
        int a = value; //
        // 处理其他的操作
    } // 6 释放锁
}
