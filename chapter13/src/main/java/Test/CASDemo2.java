package Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo2 {
    public static AtomicStampedReference reference = new AtomicStampedReference<Integer>(10,1);

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("线程["+Thread.currentThread().getName()+"]第一次获得版本号="+reference.getStamp());
            reference.compareAndSet(10,11,reference.getStamp(),reference.getStamp()+1);
            System.out.println("线程["+Thread.currentThread().getName()+"]第二次获得版本号="+reference.getStamp());
            reference.compareAndSet(11,10,reference.getStamp(),reference.getStamp()+1);
            System.out.println("线程["+Thread.currentThread().getName()+"]第三次获得版本号="+reference.getStamp());
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程["+Thread.currentThread().getName()+"]第一次获得版本号="+reference.getStamp());
            reference.compareAndSet(10,11,1,reference.getStamp()+1);
            System.out.println("线程["+Thread.currentThread().getName()+"]第二次获得版本号="+reference.getStamp());
            reference.compareAndSet(11,12,reference.getStamp(),reference.getStamp()+1);
            System.out.println("线程["+Thread.currentThread().getName()+"]第三次获得版本号="+reference.getStamp());
            System.out.println(reference.getReference());
        }).start();
    }
}
