package com.java.basic.advance.thread.basics.bytecode;

public class Sequence {

    private int value;

    /**
     * synchronized 放在普通方法上，内置锁就是当前类的实例
     */
    public synchronized int getNext() {
        return value++;
    }

    /**
     * synchronized 修饰静态方法，还能是当前类的实例吗？显然不能
     * 内置锁是当前类的Class字节码对象 Sequence.class
     */
    public static synchronized int getPrevious() {
        return 0;
    }

    public int get() {
        // 这里只要是一个对象，就可以作为一般锁
        // 可以使用 this、Integer.valueOf(value)、Sequence.class
        synchronized (Sequence.class) {
            if (value > 0) {
                return value;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        Sequence sequence = new Sequence();

        // 单线程的情况下，是没有问题的
//        while (true) {
//            System.out.println(sequence.getNext());
//        }

        /**
         * 在多线程的情况下，会出现不可预期的效果
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
