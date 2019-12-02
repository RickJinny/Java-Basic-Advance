package com.java.basic.advance.thread.advance.exchanger;

import java.util.concurrent.Exchanger;

/**
 * 线程之间的通信：Exchanger（交换者）
 */
public class ExchangerDemo {

    public void aa(Exchanger<String> exchanger) {
        System.out.println("aa 方法执行...");
        try {
            System.out.println("aa 线程正在抓取数据");
            Thread.sleep(2000);
            System.out.println("aa 线程抓取到数据");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String res = "12345";
        try {
            System.out.println("aa 等待对比结果....");
            exchanger.exchange(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bb(Exchanger<String> exchanger) {
        System.out.println("bb 方法，开始执行...");
        try {
            System.out.println("bb 线程正在抓取数据");
            Thread.sleep(4000);
            System.out.println("bb 线程抓取到数据");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "12345";
        try {
            String exchange = exchanger.exchange(res);
            System.out.println("开始进行比对....");
            System.out.println("比对结果为: " + exchange.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExchangerDemo exchangerDemo = new ExchangerDemo();
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            exchangerDemo.aa(exchanger);
        }).start();

        new Thread(() -> {
            exchangerDemo.bb(exchanger);
        }).start();
    }
}
