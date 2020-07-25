package Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutors {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3));
        for (int number = 0; number < 20; number++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"在运行...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"在运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            
        }

    }
}

