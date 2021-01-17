package cn.zhao.utils;

import java.util.concurrent.Semaphore;

/**
 * @Author zhaowl
 * @Date 2021/1/15 20:20
 * @Version 1.0
 * @Description Semaphore示例
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 相当于令牌数，用于限流
        Semaphore semaphore = new Semaphore(2);

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                try {
                    // 获取令牌
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "run");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放令牌
                    semaphore.release();
                }
            }, "Thread-" + i).start();
        }
    }
}
