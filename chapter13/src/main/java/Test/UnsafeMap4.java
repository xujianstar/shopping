package Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UnsafeMap4 {
    public static void main(String[] args) {
        Map<String,String> hashmap = new ConcurrentHashMap<String,String>();
        for (int number = 0; number < 30; number++) {
            new Thread(() -> {

                hashmap.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,20));
                System.out.println(hashmap);
            }).start();
        }

    }
}
