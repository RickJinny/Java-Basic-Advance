package com.java.basic.advance.jvm.gc;

public class NormalObject {

    public String name;

    public NormalObject(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        // 当NormalObject对象被回收，会打印下面的一句话
        System.out.println("Finalizing obj " + name);
    }
}
