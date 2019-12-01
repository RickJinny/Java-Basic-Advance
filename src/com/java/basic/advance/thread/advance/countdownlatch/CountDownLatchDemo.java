package com.java.basic.advance.thread.advance.countdownlatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch的使用
 * 举例：计算一个txt文件中，每一行数值的求和
 */
public class CountDownLatchDemo {

    private int[] nums;

    public CountDownLatchDemo(int line) {
        this.nums = new int[line];
    }

    public void calc(String line, int index, CountDownLatch countDownLatch) {
        // 切分出每一个值
        String[] nums = line.split(",");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        // 把计算的结果放到数组中指定的位置
        nums[index] = String.valueOf(total);
        System.out.println(Thread.currentThread().getName() + " 开始执行计算任务..." + line
                + " 结果为：" + total);
        /**
         * 计数减1
         */
        countDownLatch.countDown();
    }

    public void sum() {
        System.out.println("汇总线程开始执行...");
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("最终的结果为：" + total);
    }

    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = null;
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/jinny/github/Java-Basic-Advance/src/com/java/basic/advance/thread/advance/countdownlatch/test.txt"));
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("contents: " + contents);

        return contents;
    }

    public static void main(String[] args) {
        List<String> contents = readFile();
        int lineCount = contents.size();
        CountDownLatch countDownLatch = new CountDownLatch(lineCount);
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo(lineCount);
        for (int i = 0; i < lineCount; i++) {
            final int j = i;
            new Thread(() -> {
                countDownLatchDemo.calc(contents.get(j), j, countDownLatch);
            }).start();
        }

        try {
            /**
             * 当其他的线程还没有执行完的时候，主线程要等待。
             * 当主线程还没有减为0的时候，主线程会一直等待，直到计算达到0的时候，就唤醒了。继续往下面走，就到了countDownLatchDemo.sum()
             */
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatchDemo.sum();
    }
}
