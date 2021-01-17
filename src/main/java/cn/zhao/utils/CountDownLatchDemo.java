package cn.zhao.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhaowl
 * @Date 2021/1/15 15:25
 * @Version 1.0
 * @Description CountDownLatch示例
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个3的计数器
        CountDownLatch count = new CountDownLatch(3);
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                // 计数器减一
                count.countDown();

                System.out.println(Thread.currentThread().getName() + " stop");
            }, "Thread-" + i).start();
        }
        // 计数器未清零时等待
        count.await();
        System.out.println("main stop");
    }
}
