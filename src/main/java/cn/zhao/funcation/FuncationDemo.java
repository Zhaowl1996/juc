package cn.zhao.funcation;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author zhaowl
 * @Date 2021/1/17 15:26
 * @Version 1.0
 * @Description 函数式接口
 */
public class FuncationDemo {
    public static void main(String[] args) {
       f1();
       f2();
       f3();
       f4();
    }

    /**
     * 消费型接口
     */
    public static void f1() {
        Consumer<String> consumer = (string) -> {
            System.out.println(string);
        };
        consumer.accept("consumer");
    }

    /**
     * 提供型接口
     */
    public static void f2() {
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());
    }

    /**
     * 函数型接口
     */
    public static void f3() {
        Function function = (o) -> {
            return o;
        };
        System.out.println(function.apply("funcation"));
    }

    /**
     * 断言型接口
     */
    public static void f4() {
        Predicate<Integer> predicate = (num) -> {
            return num==1 ? true : false;
        };
        System.out.println(predicate.test(1));
    }
}
