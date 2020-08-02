package com.xt.designpattern.singletom;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式：懒汉式1
 * 单线程没问题
 * 多线程：有线程安全问题
 */
public class Singleton03 {
    private static Singleton03 instance;
    private Singleton03() {}
    public static Singleton03 getInstance() {
        if (instance == null) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            instance = new Singleton03();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Singleton03.getInstance())).start();
        }
    }
}
