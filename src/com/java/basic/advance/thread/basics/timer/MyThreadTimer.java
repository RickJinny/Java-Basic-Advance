package com.java.basic.advance.thread.basics.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MyThreadTimer {

    public static void main(String[] args) {
        // 执行定时任务
        Timer timer = new Timer();

        /**
         * timer.schedule(TimerTask task, long delay, long period)
         * 参数1：定时执行的任务
         * 参数2：延时多长时间执行
         * 参数3：每隔多少秒执行
         *
         * 缺点：可控性不好，不是很方便。
         * 当任务没有执行完毕或者每次都要提交不同的任务时，没法进行持久化。
         * 如果使用 Quartz 这个框架，它就帮我们都实现好了，非常方便
         */
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 实现定时任务
                System.out.println("timer task is run");
            }
        }, 0, 1000);
    }
}
