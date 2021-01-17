package cn.zhao.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author zhaowl
 * @Date 2021/1/16 20:24
 * @Version 1.0
 * @Description 阻塞队列示例
 */
public class BlockingQueueDemo {


    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);

        // 放入操作
        /**
         * 队列已满 抛异常java.lang.IllegalStateException: Queue full
         */
        System.out.println(blockingQueue.add(1));
        /**
         * 队列已满 返回false
         */
        System.out.println(blockingQueue.offer(1));

        // 取出操作
        /**
         * 队列为空 抛异常java.util.NoSuchElementException
         * extends AbstractQueue
         */
        System.out.println(blockingQueue.remove(1));
        /**
         * 队列为空 返回null
         */
        System.out.println(blockingQueue.poll());

    }
}
