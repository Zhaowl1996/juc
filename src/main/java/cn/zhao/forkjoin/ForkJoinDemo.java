package cn.zhao.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author zhaowl
 * @Date 2021/1/17 18:59
 * @Version 1.0
 * @Description ForkJoin示例类
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    private final Long MAX = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start < MAX) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            ForkJoinDemo task1 = new ForkJoinDemo(start, (start + end) / 2);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo((start + end) / 2 + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
