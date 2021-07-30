package singleton;

import java.util.concurrent.TimeUnit;

/**
 * lazy loading
 * 也称懒汉式
 * 可以通过synchronized解决，但也带来效率下降
 */

public class Singleton04 {
    private static Singleton04 INSTANCE ;

    private Singleton04() {
        
    }
    public static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> System.out.println(Singleton04.getInstance().hashCode())).start();
        }

    }
}
