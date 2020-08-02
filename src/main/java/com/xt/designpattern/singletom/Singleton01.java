package com.xt.designpattern.singletom;

/**
 * 单例模式：饿汉式1
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class Singleton01 {
    private static final Singleton01 instance = new Singleton01();
    private Singleton01() {}
    public static Singleton01 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println("instance1 == instance2: " + (instance1 == instance2));
    }
}
