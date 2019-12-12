package com.java.basic.advance.thread.basics.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a1", 10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int tmp = map.get("a1") + 1;
                    map.put("a1", tmp);
                }
            });
        }
        Thread.sleep(1000);
        System.out.println("----" + map.get("a1") + "----");
        executorService.shutdown();
    }
}
