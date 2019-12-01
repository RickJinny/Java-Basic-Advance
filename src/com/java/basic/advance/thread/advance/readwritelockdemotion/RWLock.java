package com.java.basic.advance.thread.advance.readwritelockdemotion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级：将写锁降级为读锁
 * 在写锁没有释放的时候，获取到读锁，再释放写锁
 *
 * 锁升级
 * 把读锁升级为写锁。
 * 如何把读锁升级为写锁？在读锁没有释放的时候，获取到写锁，再释放读锁。
 */
public class RWLock {

    private Map<String, Object> map = new HashMap<>();

    /**
     * 创建一个读写锁对象
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 获取到读锁
     */
    private Lock readLock = readWriteLock.readLock();

    /**
     * 获取到写锁
     */
    private Lock writeLock = readWriteLock.writeLock();

    private volatile boolean isUpdate;

    public void readWrite() {
        // 加读锁 为了保证isUpdate能够拿到最新的值
        readLock.lock();
        // 当要进行更新的时候
        if (isUpdate) {
            // 把读写给释放掉
            readLock.unlock();
            // 要写了，所以要加写锁
            writeLock.lock();
            map.put("aaa", "aaa");
            // 在释放写锁之前，先给它加一个读锁，把锁进行降级，降级为读锁
            readLock.lock();
            // 把写锁给释放掉
            writeLock.unlock();
        }

        Object object = map.get("aaa");
        System.out.println(object);
        // 最后再把读锁释放
        readLock.unlock();
    }

    public Object get(String key) {
        // 读操作，要加读锁
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            // 释放读锁
            readLock.unlock();
        }
    }

    public void put(String key, Object value) {
        // 写操作，要加写锁
        writeLock.lock();
        try {
            map.put(key, value);
        }finally {
            // 释放写锁
            writeLock.unlock();
        }
    }
}
