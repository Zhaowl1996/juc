package cn.zhao.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author zhaowl
 * @Date 2021/1/15 15:36
 * @Version 1.0
 * @Description CyclicBarrier示例
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 创建一个大小为3的栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            // 当线程等待数到达3的时候，执行此代码块
            System.out.println(Thread.currentThread().getName() + "运行");
        });

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "运行");
                try {
                    // 将线程等待
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i).start();
        }

    }
}
