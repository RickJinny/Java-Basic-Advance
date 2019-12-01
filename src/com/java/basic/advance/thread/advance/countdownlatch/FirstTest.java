package com.java.basic.advance.thread.advance.countdownlatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 计算一个txt文件中，每一行数值的求和
 * 第一种比较普通的方法：创建3个线程进行分别的求和
 */
public class FirstTest {

    private int[] nums;

    public FirstTest(int line) {
        this.nums = new int[line];
    }

    public void calc(String line, int index) {
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
        FirstTest firstTest = new FirstTest(lineCount);
        for (int i = 0; i < lineCount; i++) {
            final int j = i;
            new Thread(() -> {
                firstTest.calc(contents.get(j), j);
            }).start();
        }

        while (Thread.activeCount() > 1) {

        }

        firstTest.sum();
    }
}
