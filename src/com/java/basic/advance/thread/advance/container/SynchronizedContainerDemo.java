package com.java.basic.advance.thread.advance.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 同步容器
 */
public class SynchronizedContainerDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.synchronizedList(list);

        HashMap<String, Object> hashMap = new HashMap<>();
        Collections.synchronizedMap(hashMap);
    }
}
