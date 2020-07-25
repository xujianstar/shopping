import groovy.transform.Synchronized;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread{
    @Override
    public void run() {
        synchronized(this){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"运行");
    }

    public static void main(String[] args) {
/*        MyThread myThread = new MyThread();
        myThread.start();
        MyThread myThread1 = new MyThread();
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();*/

        MyThread thread = new MyThread();
        Thread myThread = new Thread(thread);
        myThread.start();
        Thread myThread1 = new Thread(thread);
        myThread1.start();
        Thread myThread2 = new Thread(thread);
        myThread2.start();

    }
}
