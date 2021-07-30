package singleton;

import java.util.concurrent.TimeUnit;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */

public class Singleton03 {
    private static Singleton03 INSTANCE ;

    private Singleton03() {
        
    }

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> System.out.println(Singleton03.getInstance().hashCode())).start();
        }

    }
}
