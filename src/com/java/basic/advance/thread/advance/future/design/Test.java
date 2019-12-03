package com.java.basic.advance.thread.advance.future.design;

public class Test {

    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        // 下单，交钱
        Future future = factory.createProduct("蛋糕");
        System.out.println("去上班了，等下班了来取蛋糕...");
        // 拿着订单去获取产品
        System.out.println("我拿着蛋糕回家." + future.getProduct());
    }
}
