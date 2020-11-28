package Test;

public class M23_2_DoubleCheckSingleton {
    // 在这里 volatile 变量的目的是防止指令重排序：
/*  memory=allocate();//1:初始化内存空间
    ctorInstance(memory);//2:初始化对象
    instance=memory();//3:设置instance指向刚分配的内存地址*/

    private static volatile M23_2_DoubleCheckSingleton singleton = null;
    private M23_2_DoubleCheckSingleton(){
    }

    public static synchronized M23_2_DoubleCheckSingleton getInstance(){
        if(singleton==null){
            synchronized (M23_2_DoubleCheckSingleton.class){
                if(singleton==null){
                    singleton = new M23_2_DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int number = 0; number < 3000; number++) {
            new Thread(()->{
                M23_2_DoubleCheckSingleton singleton = M23_2_DoubleCheckSingleton.getInstance();
                System.out.println(singleton);
            }).start();
        }
    }


}
