package Test;

public class TestLazyMan {
    private static TestLazyMan testLazyMan =  null;
    private TestLazyMan(){
        System.out.println("线程"+Thread.currentThread().getName()+"在运行");
    }

    public static TestLazyMan getInstance(){
        if(testLazyMan == null){
            synchronized (TestLazyMan.class){
                if(testLazyMan == null){
                    testLazyMan = new TestLazyMan();
                }
            }
        }
        return testLazyMan;
    }

    public static void main(String[] args) {
        for (int number= 0; number <20000 ; number++) {
            new Thread(()->{
                TestLazyMan.getInstance();
            }).start();
        }
    }


}
