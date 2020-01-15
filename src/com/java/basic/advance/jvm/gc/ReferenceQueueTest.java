package com.java.basic.advance.jvm.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ReferenceQueueTest {

    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<NormalObject> ref;
        while ((ref = (Reference<NormalObject>) rq.poll()) != null) {
            if (ref != null) {
                System.out.println("In queue: " + ((NormalObjectWeakReference) ref).name);
                System.out.println("reference object : " + ref.get());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<WeakReference<NormalObject>> weakReferenceList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            weakReferenceList.add(new NormalObjectWeakReference(new NormalObject("Weak" + i), rq));
            System.out.println("Created weak: " + weakReferenceList.get(i));
        }
        System.out.println("first time = " + System.currentTimeMillis());
        checkQueue();
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            //
        }
        System.out.println("second time = " + System.currentTimeMillis());
        checkQueue();
    }
}
