package com.java.basic.advance.thread.basics.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTest {

    public static void main(String[] args) {
//        HungerSingleton hungerSingleton1 = HungerSingleton.getInstance();
//        HungerSingleton hungerSingleton2 = HungerSingleton.getInstance();
//        HungerSingleton hungerSingleton3 = HungerSingleton.getInstance();
//        HungerSingleton hungerSingleton4 = HungerSingleton.getInstance();
//        System.out.println(hungerSingleton1);
//        System.out.println(hungerSingleton2);
//        System.out.println(hungerSingleton3);
//        System.out.println(hungerSingleton4);

//        LazySingleton lazySingleton1 = LazySingleton.getInstance();
//        LazySingleton lazySingleton2 = LazySingleton.getInstance();
//        LazySingleton lazySingleton3 = LazySingleton.getInstance();
//        LazySingleton lazySingleton4 = LazySingleton.getInstance();
//        System.out.println(lazySingleton1);
//        System.out.println(lazySingleton2);
//        System.out.println(lazySingleton3);
//        System.out.println(lazySingleton4);


        /**
         * 验证懒汉式的线程安全性问题
         */
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + LazySingleton.getInstance());
            });
        }

        // 给线程池给停止掉
        threadPool.shutdown();
    }
}
