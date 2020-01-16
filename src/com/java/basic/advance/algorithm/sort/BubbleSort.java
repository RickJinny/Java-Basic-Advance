package com.java.basic.advance.algorithm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arr 输入数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 外循环只需要比较 arr.length - 1 次就可以了
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // -1为了防止索引越界, -i为了提高效率
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 打印数组
     * @param arr 输入数组
     */
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 33, 11, 29, 67, 17};
        print(arr);
        bubbleSort(arr);
        System.out.println();
        print(arr);
    }
}
