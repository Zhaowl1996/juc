package cn.zhao.threadpool;

import java.util.concurrent.*;

/**
 * @Author zhaowl
 * @Date 2021/1/17 14:34
 * @Version 1.0
 * @Description 自定义线程池
 */
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                5,  // 核心线程数
                10, // 最大线程数
                10, // 线程保持活跃时间
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),    // 请求线程缓存队列
                Executors.defaultThreadFactory(),   // 线程工厂
                new ThreadPoolExecutor.AbortPolicy()    // 请求线程拒绝策略
        );
        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            threadPool.shutdown();
        }
    }
}
