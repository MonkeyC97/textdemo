package Review.Test.collection;
/**
 * ArrayList的使用
 */

import java.util.ArrayList;
import java.util.List;


public class Test1 {
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.size()+"、"+list.isEmpty());
        list.add("hello");
        list.add("hello");
        list.add("world");
        System.out.println(list.size()+"、"+list.isEmpty());
        System.out.println(list.remove("hello"));
        System.out.println(list.contains("world"));
        System.out.println(list);
    }
}
