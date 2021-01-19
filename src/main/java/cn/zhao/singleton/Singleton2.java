package cn.zhao.singleton;

/**
 * @Author zhaowl
 * @Date 2021/1/19 12:33
 * @Version 1.0
 * @Description 静态内部类单例
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static class Instance {
        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return Instance.instance;
    }
}
