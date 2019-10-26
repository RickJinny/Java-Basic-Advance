package com.java.basic.advance.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param nums 有序的数组
     * @param key 要查找的数的索引
     * @return
     */
    public static int binarySearch(int[] nums, int key) {
        // 数组左边的索引：left
        int left = 0;
        // 数组右边的索引：right
        int right = nums.length - 1;
        // 如果左边的索引 <= 右边的索引
        while (left <= right) {
            // 取中间的索引：mid
            int mid = left + (right - left) / 2;
            // 如果中间的数值，正好为查询的数值，直接返回索引mid
            if (nums[mid] == key) {
                return mid;
                // 如果中间的数值 大于 要查的数值，则右边的索引更新为 right = mid - 1
            } else if (nums[mid] > key) {
                right = mid - 1;
                // 如果中间的数值 小于 要查的数值，则右边的索引更新为 left = mid + 1
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 9, 10, 19, 20, 31, 89};
        int search = binarySearch(nums, 20);
        System.out.println("search = " + search);
    }
}
