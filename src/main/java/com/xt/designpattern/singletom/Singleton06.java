package com.xt.designpattern.singletom;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式：懒汉式4
 * volatile + DCL(Double Check Lock)
 */
public class Singleton06 {
    private static volatile Singleton06 instance;
    private Singleton06() {}
    public static Singleton06 getInstance() {
        if (instance == null) {
            synchronized (Singleton06.class) {
                if (instance == null) {
                    // 暂停一会儿线程
                    try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Singleton06.getInstance())).start();
        }
    }
}
