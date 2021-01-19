package cn.zhao.singleton;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author zhaowl
 * @Date 2021/1/19 12:17
 * @Version 1.0
 * @Description DCL单例
 */
public class Singleton1 {
    private static volatile Singleton1 singleton1 = null;

    private static AtomicBoolean lock = new AtomicBoolean(false);

    private Singleton1() throws Exception {
        synchronized (Singleton1.class) {
            if (lock.get() == true) {
                throw new Exception("不能再创建对象");
            }
            lock.compareAndSet(false, true);
        }
    }


    public static Singleton1 getInstance() throws Exception {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
