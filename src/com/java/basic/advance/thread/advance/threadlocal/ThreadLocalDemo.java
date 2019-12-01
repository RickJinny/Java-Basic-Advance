package com.java.basic.advance.thread.advance.threadlocal;

/**
 * ThreadLocal的使用
 */
public class ThreadLocalDemo {

    private ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    /**
     * 获取下一个值
     * @return
     */
    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        new Thread(() -> {
            while (true) {
                int nextValue = threadLocalDemo.getNext();
                String threadName = Thread.currentThread().getName();
                System.out.println("threadName是" + threadName + " , 下一个值是" + nextValue);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                int nextValue = threadLocalDemo.getNext();
                String threadName = Thread.currentThread().getName();
                System.out.println("threadName是" + threadName + " , 下一个值是" + nextValue);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
