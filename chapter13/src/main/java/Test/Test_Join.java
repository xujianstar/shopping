package Test;

import java.util.concurrent.TimeUnit;

public class Test_Join {
    public static void main(String[] args) {
        System.out.println("【"+Thread.currentThread().getName()+"】开始运行");
        Thread t = new Thread(new JoinThread());
        t.hashCode();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【"+Thread.currentThread().getName()+"】继续执行");
    }

}

class JoinThread implements Runnable{
    @Override
    public void run() {
        System.out.println("线程【"+Thread.currentThread().getName()+"】开始睡眠五分钟");
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
