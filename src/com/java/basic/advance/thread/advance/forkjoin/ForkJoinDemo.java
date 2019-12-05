package com.java.basic.advance.thread.advance.forkjoin;

import java.util.concurrent.*;

/**
 * Fork/Join框架
 * 使用ForkJoinTask 或者 RecursiveTask
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private int begin;

    private int end;

    public ForkJoinDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 拆分任务
        if (end - begin <= 2) {
            // 计算
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
        } else {
            // 拆分
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(begin, (begin + end) / 2);
            ForkJoinDemo forkJoinDemo2 = new ForkJoinDemo((begin + end) / 2 + 1, end);
            // 执行任务
            forkJoinDemo1.fork();
            forkJoinDemo2.fork();

            Integer a = forkJoinDemo1.join();
            Integer b = forkJoinDemo2.join();
            sum = a + b;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new ForkJoinDemo(1, 100));
        System.out.println("....");
        System.out.println("计算的值为: " + future.get());
    }
}
