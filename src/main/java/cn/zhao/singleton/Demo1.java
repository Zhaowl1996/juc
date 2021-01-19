package cn.zhao.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author zhaowl
 * @Date 2021/1/19 12:20
 * @Version 1.0
 * @Description
 */
public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /**
         * 反射破坏DCL单例
         */
//        Field field = Singleton1.class.getDeclaredField("lock");
//        field.setAccessible(true);
//
//        Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//
//        Singleton1 singleton1 = constructor.newInstance();
//        System.out.println(singleton1);
//        field.set(Singleton1.class, new AtomicBoolean(false));
//        System.out.println(constructor.newInstance());


        /**
         * Cannot reflectively create enum objects
         */
        Constructor<Singleton3> constructor = Singleton3.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());
        System.out.println(Singleton3.INSTANCE);
    }
}
