package com.java.basic.advance.thread.advance.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int MAX_CONNECTIONS = 10;

    public MyDataSource() {


    }

    public Connection getConnect() {
        return null;
    }

    public void release(Connection connection) {

    }
}
