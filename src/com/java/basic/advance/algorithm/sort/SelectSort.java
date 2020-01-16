package com.java.basic.advance.algorithm.sort;

/**
 * 选择排序
 */
public class SelectSort {

    /**
     * 选择排序
     *
     * 1、返回值类型：void
     * 2、参数列表：int[] arr
     *
     * 第一次:arr[0]分别与arr[1-4]比较,比较4次
     * 第二次:arr[1]分别与arr[2-4]比较,比较3次
     * 第三次:arr[2]分别与arr[3-4]比较,比较2次
     * 第四次:arr[3]与arr[4]比较,比较1次
     *
     */
    public static void selectSort(int[] arr) {
        // 只需要比较arr.length -1 次
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
