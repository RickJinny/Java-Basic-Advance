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

        /**
         * 2、字符串的比较
         */
        stringCompareMethod();

        /**
         * 3、字符串与其他数据类型之间的转换
         */
        stringConvertMethod();

        /**
         * 4、字符串与字符的查找
         */
        stringSearchCharMethod();

        /**
         * 5、字符串的截取与拆分
         */
        stringCutAndSplit();
    }

    /**
     * 1、字符串的基本操作方法
     */
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

    /**
     * 2、字符串的比较
     */
    private static void stringCompareMethod() {
        /**
         * 字符串比较，可以分为两类：
         * 第一类：字符串大小的比较，有三种结果：大于、等于、小于。
         * 第二类：比较两个字符串是否相等，有两种结果：true和false。
         */

        String str1 = "Hello";
        String str2 = "hello";

        /**
         * 第一种比较：字符串大小的比较，有三种结果：大于、等于、小于。
         * 1、不忽略字符串字符大小写
         * 2、忽略字符串字符大小写
         */
        /* 1、不忽略字符串字符大小写: compareTo方法 */
        if (str1.compareTo(str2) > 0) {
            System.out.println(str1 + " > " + str2);
        } else if (str1.compareTo(str2) == 0) {
            System.out.println(str1 + " = " + str2);
        } else {
            System.out.println(str1 + " < " + str2);
        }

        /* 2、忽略字符串字符大小写: compareToIgnoreCase */
        if (str1.compareToIgnoreCase(str2) > 0) {
            System.out.println(str1 + " > " + str2);
        } else if (str1.compareToIgnoreCase(str2) == 0) {
            System.out.println(str1 + " = " + str2);
        } else {
            System.out.println(str1 + " < " + str2);
        }


        /**
         * 第二类：比较两个字符串是否相等，有两种结果：true和false。
         * 1、不忽略字符串大小写的情况下，判断字符串相等的方法
         * 2、忽略字符串大小写的情况下，判断字符串相等的方法
         */
        /* 1、不忽略字符串大小写的情况下，判断字符串相等的方法: equals()方法 */
        if (str1.equals(str2)) {
            System.out.println(str1 + " = " + str2);
        } else {
            System.out.println(str1 + " != " + str2);
        }

        /* 2、忽略字符串大小写的情况下，判断字符串相等的方法: equalsIgnoreCase()方法 */
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println(str1 + " = " + str2);
        } else {
            System.out.println(str1 + " != " + str2);
        }
    }

    /**
     * 3、字符串与其他数据类型之间的转换
     */
    private static void stringConvertMethod() {
        /**
         * 第一、将字符串转换为其他类型
         */
        int i = Integer.parseInt("100"); // 将字符串转换为整形
        long l = Long.parseLong("2048"); // 将字符串转换为长整型
        float f = Float.parseFloat("1.234"); // 将字符串转换为单精度浮点型
        double d = Double.parseDouble("1.229098"); // 将字符串转换为双精度浮点型
        boolean b = Boolean.parseBoolean("false"); // 将字符串转换为布尔型
        byte bt = Byte.parseByte("100"); // 将字符串转换为 byte 类型
        char ch = "Hello".charAt(1);

        /**
         * 第二、将其他类型转换为字符串类型
         */
        String str1 = String.valueOf(i);
        String str2 = String.valueOf(l);
        String str3 = String.valueOf(f);
        String str4 = String.valueOf(d);
        String str5 = String.valueOf(b);
        String str6 = String.valueOf(bt);
        String str7 = String.valueOf(ch);
    }

    /**
     * 4、字符串与字符的查找
     */
    private static void stringSearchCharMethod() {
        String str = "Hello, my name is string, my name is string, my name is string, my name is string";
        System.out.println("该字符串是: " + str);

        /**
         * 第一、indexOf()方法查找字符首个出现的位置
         */
        int index1 = str.indexOf(" "); // 查找第一个空格，所在的索引
        int index2 = str.indexOf(" ", 3);// 找到索引3以后的第一个空格所在索引
        System.out.println("查找第一个空格，所在的索引是: " + index1);
        System.out.println("找到索引3以后的第一个空格所在索引是: " + index2);

        /**
         * 第二、lastIndexOf()方法查找字符最后出现位置
         */
        int index3 = str.lastIndexOf(" ");  // 查找到最后一个空格，所在的索引
        int index4 = str.lastIndexOf(" ",12);// 查找到索引12以后，第一个空格所在索引
        System.out.println("查找到最后一个空格，所在的索引: "+index3);
        System.out.println("查到索引12以后，第一个空格所在索引是: "+index4);

        /**
         * 第三、indexOf()方法查找子字符串第一次出现位置
         */
        int index5 = str.indexOf("my"); // 查找到"my"子字符串, 第一次出现位置的索引
        int index6 = str.indexOf("my",8);// 查找到索引8以后子字符串"my"第一个出现位置所在索引
        System.out.println("查找到\"my\"子字符串, 第一次出现位置的索引是: "+index5);
        System.out.println("查找到索引8以后子字符串\"my\"第一个出现位置所在索引是: "+index6);

        /**
         * 第四、lastIndexOf()方法查找子字符串最后一次出现位置
         */
        int index7 = str.lastIndexOf("my"); // 查找子字符串"my"最后一次出现位置的索引号
        int index8 = str.lastIndexOf("my",8); // 查找到索引8以后子字符串"my"最后一次出现位置所在索引
        System.out.println("查找子字符串\"my\"最后一次出现位置的索引号是: "+index7);
        System.out.println("查找到索引8以后子字符串\"my\"最后一次出现位置所在索引是: " + index8);
    }

    /**
     * 5、字符串截取与拆分
     */
    private static void stringCutAndSplit() {
        String str = "Hello, my name is string, my name is string, my name is string, my name is string";
        System.out.println("该字符串是: " + str);
        int length = str.length();
        System.out.println("字符串长度是: " + length);

        /**
         * 1、substring()方法截取出第一个单词和最后一个单词
         * 用indexOf()和lastIndexOf()方法找到第一个单词和最后一个单词前后空格的索引号;
         * 第一个单词的左范围索引为0，最后一个单词的右范围索引为 length - 1
         */
        int firstIndex = str.indexOf(" "); // 查找第一个空格所在的索引
        int lastIndex = str.lastIndexOf(" "); // 查找最后一个空格所在的索引
        System.out.println("第一个空格的索引是：" + firstIndex);
        System.out.println("最后一个空格的索引是：" + lastIndex);

        // 利用substring()方法根据第一个和最后一个单词的索引范围截取出第一个和最后一个单词
        String firstWord = str.substring(0, firstIndex); // 截取出第一个单词
        String lastWord = str.substring(lastIndex + 1, length); // 截取出最后一个单词
        System.out.println("第一个单词是: " + firstWord);
        System.out.println("最后一个单词是: " + lastWord);

        /**
         * 2、split()方法拆分出所有单词
         */
        String[] array = str.split(" ");  // 根据空格拆分出所有单词, 保存到字符串数组中
        System.out.println("拆分之后的各个词汇为: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
