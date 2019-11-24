package com.java.basic.advance.thread.basics.singleton;

public class LazySingleton {

    private LazySingleton() {

    }

    private static LazySingleton lazySingleton;

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
