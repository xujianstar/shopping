package Test;

import java.util.concurrent.*;

public class TestCallable implements Callable<String> {
    int a = 0;
    @Override
    public String call() throws Exception {

        TimeUnit.SECONDS.sleep(10);
        ++a;
        System.out.println(Thread.currentThread().getName() + ",a=" + a);
        return String.valueOf(a);
    }
}

class TestCallableMain {
    public static void main(String[] args) {
/*        TestCallable callable = new TestCallable();
        FutureTask<String> task1 = new FutureTask<String>(callable);
        FutureTask<String> task2 = new FutureTask<String>(callable);
        FutureTask<String> task3 = new FutureTask<String>(callable);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();*/

        TestCallable callable = new TestCallable();
        FutureTask<String> task1 = new FutureTask<String>(callable);

        Thread thread1 = new Thread(task1);
/*        Thread thread2 = new Thread(task1);
        Thread thread3 = new Thread(task1);*/

        thread1.start();
/*        thread2.start();
        thread3.start();*/

        try {
            System.out.println("执行结果="+task1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
