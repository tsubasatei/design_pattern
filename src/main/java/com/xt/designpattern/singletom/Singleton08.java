package com.xt.designpattern.singletom;

/**
 * 单例模式：懒汉式6
 * 枚举: 不仅可以解决线程同步，还可以防止反序列化。
 */
public enum  Singleton08 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Singleton08.INSTANCE)).start();
        }
    }
}
