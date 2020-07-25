package Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int number = 0; number <5 ; number++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("业务员【"+Thread.currentThread().getName()+"】到达会议室,当前已有"+cyclicBarrier.getNumberWaiting()+"人进入回忆室");
                    cyclicBarrier.await();
                    System.out.println("业务员【"+Thread.currentThread().getName()+"】说：人员到齐开会，" + Thread.currentThread().getName() + "开始开会");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
