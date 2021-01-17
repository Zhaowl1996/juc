package cn.zhao.threadpool;

import java.util.concurrent.*;

/**
 * @Author zhaowl
 * @Date 2021/1/17 14:08
 * @Version 1.0
 * @Description 4种线程池示例
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.pool();
    }

    public void pool() {
        // 单条线程的线程池
        ExecutorService service1 = Executors.newSingleThreadExecutor();
        // 定长线程池
        ExecutorService service2 = Executors.newFixedThreadPool(5);
        // 可缓存线程池
        ExecutorService service3 = Executors.newCachedThreadPool();
        // 可执行定时任务的定长线程池
        ScheduledExecutorService service4 = Executors.newScheduledThreadPool(5);
        try {
            service4.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName());
            }, 5, 1, TimeUnit.SECONDS);
        } finally {
            service1.shutdown();
            service2.shutdown();
            service3.shutdown();
            service4.shutdown();
        }
    }
}
