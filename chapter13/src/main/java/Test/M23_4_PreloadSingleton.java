package Test;

public class M23_4_PreloadSingleton {
    public static void main(String[] args) {
        for (int number = 0; number < 3000; number++) {
            new Thread(()->{
                PreloadSingleton singleton = PreloadSingleton.getInstance();
                System.out.println(singleton);
            }).start();
        }
    }
}

class PreloadSingleton{
    private static volatile PreloadSingleton  singleton = new PreloadSingleton();
    public static PreloadSingleton getInstance(){
        return singleton;
    }
}

