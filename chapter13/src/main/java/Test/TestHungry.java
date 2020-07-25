package Test;

public class TestHungry {
    private static TestHungry man = new TestHungry();
    private TestHungry(){
        System.out.println("线程哈哈["+Thread.currentThread().getName()+"]在运行");
    }
    public static TestHungry getInstance(){
        return man;
    }

    public static void main(String[] args) {
        for (int number= 0; number <20000 ; number++) {
            new Thread(()->{
                TestHungry.getInstance();
            }).start();
        }
    }
}
