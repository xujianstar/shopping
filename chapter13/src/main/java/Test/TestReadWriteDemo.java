package Test;

import java.util.HashMap;
import java.util.Map;

public class TestReadWriteDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int number = 0; number < 10; number++) {
            final int temp = number;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            }).start();
        }

        for (int num = 0; num <10 ; num++) {
            final int temp = num;
            new Thread(()->{
                myCache.get(temp+"");
            }).start();
        }

    }
}

class MyCache{
    private volatile Map cache = new HashMap<String,String>();

    public void put(String key,String value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        cache.put(key, value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
    }

    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object result = cache.get(key);
        System.out.println(Thread.currentThread().getName()+"读取结果："+result);
    }
}
