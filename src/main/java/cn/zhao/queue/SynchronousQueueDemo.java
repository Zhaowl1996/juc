package cn.zhao.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhaowl
 * @Date 2021/1/17 13:21
 * @Version 1.0
 * @Description SynchronousQueue实例
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // 是一种无缓冲队列
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " put " + i);
                    synchronousQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }, "Thread-put").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " take " + synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-take").start();
    }
}
