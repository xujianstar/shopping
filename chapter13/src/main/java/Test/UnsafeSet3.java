package Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class UnsafeSet3 {
    private static final Logger logger = LoggerFactory.getLogger(UnsafeSet3.class);
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int number = 0; number < 10; number++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            }).start();
        }
    }
}
