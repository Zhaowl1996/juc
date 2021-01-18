package cn.zhao.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author zhaowl
 * @Date 2021/1/18 14:23
 * @Version 1.0
 * @Description CompletableFuture示例
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        f1();
        f2();
    }

    // 无返回值
    private static void f1() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        completableFuture.get();
        System.out.println(Thread.currentThread().getName());
    }

    // 有返回值
    private static void f2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
//            int i = 1 / 0;
            return "0000";
        }).whenComplete((u, v) -> {
            System.out.println(u);  // u为返回值
            System.out.println(v);  // v为异常
        }).exceptionally(e -> { // e为异常
            e.printStackTrace();
            return "0001";
        });
        System.out.println(Thread.currentThread().getName());
        // 获取异步执行的结果
        System.out.println(completableFuture.get());

    }
}
