package com.java.basic.advance.thread.advance.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简易的数据库连接池
 */
public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNECTIONS = 10;

    private static final String DRIVER_CLASS = "";

    private static final String USER = "";

    private static final String PASSWORD = "";

    private static final String URL = "";

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {
        for (int i = 0; i < INIT_CONNECTIONS; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.addLast(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnect() {
        Connection result = null;
        lock.lock();
        try {
            // 判断连接的数量, 如果小于等于0, 则释放链接的等待
            synchronized (pool) {
                while (pool.size() <= 0) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
            }
            return result;
        } finally {
            lock.unlock();
        }
    }

    public void release(Connection connection) {
        if (connection != null) {
            lock.lock();
            try {
                pool.addLast(connection);
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
