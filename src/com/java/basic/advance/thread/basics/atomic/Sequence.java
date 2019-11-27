package com.java.basic.advance.thread.basics.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子性解决线程安全性问题
 * AtomicInteger
 */
public class Sequence {

    private AtomicInteger value = new AtomicInteger(0);

    private int[] arr = {2, 1, 4, 6};

    /**
     * 原子更新数组
     */
    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);

    /**
     * 原子更新对象
     */
    AtomicReference<Student> studentAtomicReference = new AtomicReference<>();

    /**
     * 原子更新，对象里面的某个字段
     */
    AtomicIntegerFieldUpdater<Student> age = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");

    public int getNext() {
        Student student = new Student();
        System.out.println(age.getAndIncrement(student));
        System.out.println(age.getAndIncrement(student));
        System.out.println(age.getAndIncrement(student));


        atomicIntegerArray.getAndIncrement(2);
        atomicIntegerArray.getAndAdd(2, 10);
        return value.getAndDecrement();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + sequence.getNext());
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
