package com.java.basic.advance.thread.basics.singleton;

public class HungerSingleton {

    // 私有化构造方法
    private HungerSingleton() {

    }

    private static HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return instance;
    }

    /**
     * 1、多线程的环境下
     * 2、必须有共享资源
     * 3、对资源进行非原子性操作
     */
}
