package Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int number = 1; number < 18 ; number++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("线程【"+Thread.currentThread().getName()+"】占领一个车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("线程【"+Thread.currentThread().getName()+"】离开车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
