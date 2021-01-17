package cn.zhao.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author zhaowl
 * @Date 2021/1/17 19:10
 * @Version 1.0
 * @Description 求和性能测试类
 */
public class SumTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        f1();   //11254
//        f2();   //10869
//        f3();   //411
    }

    // for
    private static void f1() {
        long startTime = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 0L; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sum : " + sum + " time :" + (endTime - startTime));
    }

    // ForkJoin
    private static void f2() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ForkJoinDemo demo = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(demo);
        Long sum = submit.get();
        long endTime = System.currentTimeMillis();
        System.out.println("sum : " + sum + " time :" + (endTime - startTime));
    }

    // stream
    private static void f3() {
        long startTime = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("sum : " + sum + " time :" + (endTime - startTime));
    }

}
