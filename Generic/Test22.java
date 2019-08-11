package Review.Test.Generic;

/**
 * 内建函数式接口
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.Predicate;

public class Test22 {
    //功能型接口
    public static void main1(String[] args) {
        Function<Integer,String> function = String::valueOf;
        String str = function.apply(100);
        System.out.println(str.length());
    }

    public static void main2(String[] args) {
        IntFunction<String> function = String::valueOf;
        String str = function.apply(111);
        System.out.println(str.length());
    }
    //供给型接口
    public static void main3(String[] args) {
        Supplier<String> stringSupplier = "hello"::toUpperCase;
        System.out.println(stringSupplier.get());
    }
    //消费型接口
    public static void main4(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("hehe");
    }
    //断言型接口


    public static void main(String[] args){
            Predicate<String> pre = "###123shdsb" ::startsWith;
            System.out.println(pre.test("##"));
    }
}
