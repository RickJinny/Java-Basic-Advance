package com.java.basic.advance.algorithm.string;

/**
 * 字符串的基本操作，主要包括以下几个方面：
 * 1、字符串的基本操作方法
 * 2、字符串的比较
 * 3、字符串与其他数据类型之间的转换
 * 4、字符串与字符的查找
 * 5、字符串的截取与拆分
 * 6、字符串的修改与替换
 */
public class StringBasicOperation {

    public static void main(String[] args) {
        /**
         * 1、字符串的基本操作方法
         */
        stringBasicOperationMethod();
    }

    private static void stringBasicOperationMethod() {
        String myString = "我是一个字符串.";
        System.out.println(myString); // 输入字符串，输出结果是：我是一个字符串

        /**
         * 1、获取字符串的长度方法：length()
         * 格式：int length = myString.length()
         */
        int length = myString.length();
        System.out.println("字符串的长度为: " + length); // 字符串的长度为: 7

        /**
         * 2、获取字符串中的第 i 个字符串方法 charAt(i)
         * 格式：char ch = myString.charAt(i)
         */
        char ch = myString.charAt(5);
        System.out.println("字符串中的第5个字符为: " + ch); // 字符串中的第5个字符为: 符

        /**
         * 3、获取指定位置的字符方法 getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
         * 格式：char[] dst = new char[100]; 定义一个char类型的数组
         *      myString.getChars(srcBegin, srcEnd, dst, dstBegin)
         *
         * srcBegin: 需要复制的字符串的开始索引
         * srcEnd:  需要复制的字符串的结束索引, srcEnd - 1
         * dest: 定义的char类型的数组
         * dstBegin: 数组 dest 开始存储的位置索引号
         */
        char[] dest = new char[100]; // 定义容量为100的字符数组，用于存储从字符串中提取出的一串字符
        myString.getChars(0, 5, dest, 0);
        System.out.println("dest中存放的内容为: " + dest); // 这句话打印出来是编码，错误，括号中不能带其他的字符串
        System.out.println(dest); // 括号中不能带有其他的字符
    }
}
