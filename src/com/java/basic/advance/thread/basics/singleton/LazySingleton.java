package com.java.basic.advance.thread.basics.singleton;

public class LazySingleton {

    private LazySingleton() {

    }

    // 加上volatile可以减少虚拟机的优化，不会再出现指令重排序问题
    private static volatile LazySingleton lazySingleton;

    /**
     * 双层检查加锁
     * @return
     */
    public static LazySingleton getInstance() {
        // 自旋 while(true)
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton(); // 指令重排序

                    // 申请一块内存空间
                    // 在这块空间里实例化对象
                    // lazySingleton的引用指向这块空间地址

                }
            }
        }
        return lazySingleton;
    }
}
