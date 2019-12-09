package com.java.basic.advance.thread.basics.waitnotify;

public class ThreadWaitNotifyDemo {

    private volatile int signal;

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public static void main(String[] args) {
        ThreadWaitNotifyDemo demo = new ThreadWaitNotifyDemo();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 修改状态的线程执行...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.setSignal(1);
            System.out.println(Thread.currentThread().getName() + " 状态值修改成功了...");
        }).start();

        new Thread(() -> {
            // 等待信号signal为1时，开始执行，否则不执行
            while (demo.getSignal() != 1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 当信号为1时，执行代码
            System.out.println(Thread.currentThread().getName() + " 模拟代码的执行...");
        }).start();
    }
}
