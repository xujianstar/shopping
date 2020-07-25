package Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2000)+"-->"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2000)+"-->"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2000)+"-->"+atomicInteger.get());

    }
}
