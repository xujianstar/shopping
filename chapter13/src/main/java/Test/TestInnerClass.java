package Test;

public class TestInnerClass {
    private TestInnerClass(){
        System.out.println("线程嘻嘻["+Thread.currentThread().getName()+"]在运行");
    }
    public static TestInnerClass getInstance(){
        return InnerCLass.TEST_INNER_CLASS;
    }
    private static class  InnerCLass {
        private static final  TestInnerClass TEST_INNER_CLASS = new TestInnerClass();
    }
    public static void main(String[] args) {
        for (int number= 0; number <20000 ; number++) {
            new Thread(()->{
                TestInnerClass.getInstance();
            }).start();
        }
    }
}
