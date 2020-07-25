package Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestPrintABCbyThread {
    public static void main(String[] args) {
        PrintABC print = new PrintABC();

        for (int i=0;i<10;i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    print.printA();
                }
            }).start();
        }

        for (int i=0;i<10;i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    print.printB();
                }
            }).start();
        }

        for (int i=0;i<10;i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    print.printC();
                }
            }).start();
        }
    }
}

class PrintABC{
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    String flag = "A";

    public void printA(){
        lock.lock();
        try{
            while(!flag.equals("A")){
                conditionA.await();
            }
            System.out.println("A");
            flag = "B";
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try{
            while(!flag.equals("B")){
                conditionB.await();
            }
            System.out.println("B");
            flag = "C";
            conditionC.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try{
            while(!flag.equals("C")){
                conditionC.await();
            }
            System.out.println("C");
            flag = "A";
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
