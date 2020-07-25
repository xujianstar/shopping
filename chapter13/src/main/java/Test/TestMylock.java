package Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestMylock {
    private static AtomicReference<Thread> ref = new AtomicReference<>();
    public static void lock(){
        System.out.println(Thread.currentThread().getName()+"试图加锁");
        while(ref.compareAndSet(null, Thread.currentThread())){

        }
        System.out.println(Thread.currentThread().getName()+"成功加锁");
    }
    public static void unLock(){
        System.out.println(Thread.currentThread().getName()+"试图释放锁");
        ref.compareAndSet(Thread.currentThread(),null );
        System.out.println(Thread.currentThread().getName()+"成功释放锁");
    }

    public static void main(String[] args) throws InterruptedException {
        TestMylock  testMylock = new TestMylock ();
        AtomicInteger num = new AtomicInteger(0);
        for (int number = 0; number < 10000; number++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testMylock.lock();
                    num.set(num.get()+1);
                    testMylock.unLock();
                }
            }).start();
        }
        Thread.currentThread().sleep(1000*20);
        System.out.println(num.get());

    }
}
