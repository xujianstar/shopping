package Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int number = 0; number < 5; number++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"在运行...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"在运行完成...");
                countDownLatch.countDown();
            }).start();
        }
        System.out.println("主线程等待");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程唤醒，程序结束");
    }
}
