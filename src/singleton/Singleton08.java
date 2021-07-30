package singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化。
 * 编译生成的是抽象类
 */
public enum  Singleton08 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> System.out.println(Singleton08.INSTANCE.hashCode())).start();
        }
    }
}
