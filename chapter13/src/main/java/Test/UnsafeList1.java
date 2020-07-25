package Test;

import java.util.Arrays;
import java.util.List;

public class UnsafeList1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
    }
}
