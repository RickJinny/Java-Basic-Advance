package com.java.basic.advance.thread.basics.threadlock;

public class MyLockDemo {

    MyLock myLock = new MyLock();

    public void aa() {
        myLock.lock();
        System.out.println("aa");
        bb();
        myLock.unlock();
    }

    public void bb() {
        myLock.lock();
        System.out.println("bb");
        myLock.unlock();
    }

    public static void main(String[] args) {
        MyLockDemo myLockDemo = new MyLockDemo();
        new Thread(() -> {
            myLockDemo.aa();
        }).start();
    }
}
