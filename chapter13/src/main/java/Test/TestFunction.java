package Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunction {
    public static void main(String[] args) {
/*        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                System.out.println("娃哈哈="+s);
                return 2048;
            }
        };
        System.out.println(function.apply("龍門赛神"));*/

        Function<String,Integer> function = (name)->{
            System.out.println("娃哈哈123="+name);
            return 2014;
        };
        System.out.println(function.apply("龍門赛神"));

        Predicate<String> predicate = (name)->{
            System.out.println("断言型函数接口="+name);
            return name.isEmpty();
        };
        System.out.println(predicate.test("龍門赛神"));

        Consumer<String> consumer = (name)->{
            System.out.println("收到的信息:"+name);
        };

        consumer.accept("龍門赛神");

        Supplier<String>  supplier = ()->{
            return "龍門赛神";
        };
        System.out.println(supplier.get());
    }
}
