package com.java.basic.advance.thread.advance.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    private Random random = new Random();

    public void learning(CyclicBarrier cyclicBarrier) {
        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 时间到了，开始学习吧");

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 汇报一下学习的内容");
    }

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("现在开始学习了");
        });

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                test.learning(cyclicBarrier);
            }).start();
        }
    }
}
