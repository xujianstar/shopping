package Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnsafeList2 {
    public static void main(String[] args) {
        // ArrayList<Object> list = new ArrayList<>();
        // Vector list = new Vector();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{ // 3个结果
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
                },String.valueOf(i)).start();
        }
    }
}
