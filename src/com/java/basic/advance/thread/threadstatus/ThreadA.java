package com.java.basic.advance.thread.threadstatus;

public class ThreadA implements Runnable {

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义的线程执行了......");
        }
    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        // 创建线程, 并且指定线程任务，此时线程的状态是初始化状态
        Thread thread = new Thread(threadA);
        // 启动线程
        thread.start();

        while (true) {
            synchronized (threadA) {
                System.out.println("主线程执行了......");
                // 等待 100ms
                try {
                    Thread.sleep(100);
                    System.out.println("主线程中等待100ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                threadA.notifyAll();
            }
        }
    }
}
