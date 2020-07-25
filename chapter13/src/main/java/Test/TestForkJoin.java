package Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class TestForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0L, 10_0000_0000L); // 计算任务
        ForkJoinTask<Long> task = pool.submit(forkJoinDemo);
        System.out.println(task.get());
        System.out.println("耗时="+(System.currentTimeMillis()-begin));



        begin = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        System.out.println(sum);
        System.out.println("耗时="+(System.currentTimeMillis()-begin));


    }
}


class ForkJoinDemo extends RecursiveTask<Long> {
    public Long begin;
    public Long end;
    public Long len = 10000L;
    public ForkJoinDemo(Long begin,Long end){
        this.begin = begin;
        this.end   = end;
    }
    @Override
    protected Long compute() {
        if((end-begin)<len){
            Long sum = 0L;
            for (Long i = begin; i <=end ; i++) {
                sum = sum + i;
            }
            return sum;
        }else{
            Long middle = (begin + end)/2 ;
            ForkJoinDemo task1 = new ForkJoinDemo(begin,middle);
            // fork： 安排任务异步执行，白话：创建一个子任务
            task1.fork();  // 将拆分后的任务，压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1,end);
            task2.fork(); // 将拆分后的任务，压入线程队列
            // join 当任务完成后互殴去返回的计算结果！
            // invoke：开始执行！如果计算没有完毕，就会等待！
            return task1.join()+task2.join(); // 获取计算结果，并汇总

        }
    }
}