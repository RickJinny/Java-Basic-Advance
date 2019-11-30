package com.java.basic.advance.thread.advance.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
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
