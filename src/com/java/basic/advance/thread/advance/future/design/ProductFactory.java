package com.java.basic.advance.thread.advance.future.design;

import java.util.Random;

public class ProductFactory {

    public Future createProduct(String name) {
        // 创建一个订单
        Future future = new Future();
        System.out.println("订单创建成功");
        // 生产产品
        new Thread(() -> {
            Product product = new Product(new Random().nextInt(), name);
            future.setProduct(product);
        }).start();
        return future;
    }
}
