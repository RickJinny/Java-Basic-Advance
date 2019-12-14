package com.java.basic.advance.thread.advance.happensbefore;

/**
 * 一、happens-before
 * Happens-before是用来指定两个操作之间的执行顺序。提供跨线程的内存可见性。
 * 在Java内存模型中，如果一个操作执行的结果需要对另外一个操作可见，那么这两个操作之间必然存在 happens-before关系。
 * Happens-before规则如下:
 * 程序顺序规则
 * 监视器锁规则
 * volatile变量规则
 * 传递性
 * Start规则
 * Join规则
 */
public class HappensBeforeDemo {

    private int a;
    private int b;
    private int c;

    /**
     * 1 happens-before 2
     * 2 happens-before 3
     * 3 happens-before 4
     */
    public void aa() {
        a = 2;  // 1
        b = 10; // 2
        c = a + b; // 3
        System.out.println(c); // 4
    }

    public static void main(String[] args) {
        new HappensBeforeDemo().aa();
    }
}
