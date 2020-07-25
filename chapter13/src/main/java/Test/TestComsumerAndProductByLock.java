package Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestComsumerAndProductByLock {
    public static void main(String[] args) throws InterruptedException {
        DataByLock data = new DataByLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<300;i++) {
                    try {
                        data.delete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<300;i++) {
                    try {
                        data.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<300;i++) {
                    try {
                        data.delete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<300;i++) {
                    try {
                        data.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.currentThread().sleep(1000*10);
        data.getData();

    }
}

class DataByLock{
    int number=5;
    public ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add() throws InterruptedException {
        try{
            lock.lock();
            while(number>=5){
                condition.await();
            }
            number = number + 1;
            System.out.println("add 之后="+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void delete() throws InterruptedException {
        try {
            lock.lock();
            while(number<=0){
                condition.await();
            }
            number = number - 1;
            System.out.println("delete 之后="+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void getData(){
        System.out.println("结果="+number);
    }
}
