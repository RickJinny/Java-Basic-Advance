package com.java.basic.advance.thread.basics.join;

public class ThreadJoinDemo1 {

    public void aa(Thread joinThread) {
        System.out.println("方法aa执行了...");
        joinThread.start();
        try {
            // join方法会使当前线程永远地等待下去，直到期间被另外的线程中断
            joinThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("aa方法执行完毕...");
    }

    public void bb() {
        System.out.println("加塞线程开始执行...");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程执行完毕...");
    }

    public static void main(String[] args) {
        ThreadJoinDemo1 demo1 = new ThreadJoinDemo1();
        Thread joinThread = new Thread(() -> {
            demo1.bb();
        });

        new Thread(() -> {
            demo1.aa(joinThread);
        }).start();
    }
}
