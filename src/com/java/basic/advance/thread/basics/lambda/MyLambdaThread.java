package com.java.basic.advance.thread.basics.lambda;

import java.util.Arrays;
import java.util.List;

public class MyLambdaThread {

    public int add(List<Integer> values) {
//        values.stream().forEach(System.out::println);
//        values.parallelStream().forEach(System.out::println);
//        values.parallelStream().forEachOrdered(System.out::println);
        return values.parallelStream().mapToInt(a -> a).sum();
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10, 20, 30, 40);
        int res = new MyLambdaThread().add(values);
        System.out.println("计算结果为：" + res);
    }
}
