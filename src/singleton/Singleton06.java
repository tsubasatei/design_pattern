package singleton;

import java.util.concurrent.TimeUnit;

/**
 * DCL + volatile
 */
public class Singleton06 {
    private static volatile Singleton06 INSTANCE ;

    private Singleton06() {
        
    }
    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton06.class) {
                if (INSTANCE == null) {
                    // 暂停一会儿线程
                    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                    INSTANCE = new Singleton06();
                }

            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> System.out.println(Singleton06.getInstance().hashCode())).start();
        }

    }
}
