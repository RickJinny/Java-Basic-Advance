package com.java.basic.advance.thread.advance.sort;

/**
 * 重排序的问题
 */
public class SortDemo {

    private int a;
    private int b;
    private int c;

    public void aa() {
        // 写后读
        // 读后写
        // 写后写
        a = 1; // 写操作
        b = 2; // 写操作
        c = a; // 读操作
        b = c + a;
        System.out.println(b);
    }

    public static void main(String[] args) {
        new SortDemo().aa();
    }
}
