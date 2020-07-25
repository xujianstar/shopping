package Test;

public class TestComsumerAndProduct {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
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
class Data{
    int number=5;
    Object lock = new Object();
    public void add() throws InterruptedException {
        synchronized (lock){
            while(number>=5){
                lock.wait();
            }
            number = number + 1;
            System.out.println("add 之后="+number);
            lock.notifyAll();
        }
    }

    public void delete() throws InterruptedException {
        synchronized (lock){
            while(number<=0){
                lock.wait();
            }
            number = number - 1;
            System.out.println("delete 之后="+number);
            lock.notifyAll();
        }
    }

    public void getData(){
        System.out.println("结果="+number);
    }
}
