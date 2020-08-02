package com.xt.designpattern.singletom;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式：懒汉式2
 * 加锁同步，效率低
 */
public class Singleton04 {
    private static Singleton04 instance;
    private Singleton04() {}
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            instance = new Singleton04();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Singleton04.getInstance())).start();
        }
    }
}
