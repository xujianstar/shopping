import groovy.transform.Synchronized;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized(this){
                try {
                    System.out.println("线程["+Thread.currentThread().getName()+"]开始睡眠");
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"运行");
        }
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
