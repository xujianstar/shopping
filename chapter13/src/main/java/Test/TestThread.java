package Test;

public class TestThread {
    public static void main(String[] args) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<200;i++){
                        try {
                            System.out.println(i);
                            Thread.currentThread().sleep(100*10);
                            System.out.println(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t.start();
            t.start();
        System.out.println("主线程开始调用t.sleep()");
        try {
            t.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程完成调用t.sleep()");
    }
}
