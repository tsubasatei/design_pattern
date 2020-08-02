package com.xt.designpattern.singletom;

/**
 * 单例模式：饿汉式2, 静态代码块初始化
 */
public class Singleton02 {
    private static final Singleton02 instance;
    private Singleton02() {}
    static {
        instance = new Singleton02();
    }
    public static Singleton02 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton02 instance1 = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();
        System.out.println("instance1 == instance2: " + (instance1 == instance2));
    }
}
