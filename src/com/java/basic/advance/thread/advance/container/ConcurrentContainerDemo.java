package com.java.basic.advance.thread.advance.container;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 并发容器
 * 1、CopyOnWriteArrayList
 * 2、ConcurrentHashMap
 */
public class ConcurrentContainerDemo {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("aa");
        copyOnWriteArrayList.add("bb");
        copyOnWriteArrayList.add("cc");
        copyOnWriteArrayList.add("dd");
        System.out.println(copyOnWriteArrayList);
    }
}
