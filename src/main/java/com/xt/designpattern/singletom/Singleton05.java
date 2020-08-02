package com.xt.designpattern.singletom;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式：懒汉式3
 * 试图用同步代码块，降低锁的范围，但是有问题，不可行
 */
public class Singleton05 {
    private static Singleton05 instance;
    private Singleton05() {}
    public static Singleton05 getInstance() {
        if (instance == null) {
            synchronized (Singleton05.class) {
                // 暂停一会儿线程
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                instance = new Singleton05();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Singleton05.getInstance())).start();
        }
    }
}
