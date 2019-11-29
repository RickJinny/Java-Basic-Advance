package com.java.basic.advance.thread.advance.aqs;

public class MyLockTest {

    private int value;

    private MyLock myLock = new MyLock();

    public int next() {
        myLock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }finally {
            myLock.unlock();
        }
    }

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
        MyLockTest myLockTest = new MyLockTest();
        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getId() + " " + myLockTest.next());
//            }
            myLockTest.aa();
        }).start();

//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getId() + " " + myLockTest.next());
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getId() + " " + myLockTest.next());
//            }
//        }).start();
    }
}
