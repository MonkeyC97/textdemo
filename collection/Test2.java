package Review.Test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * List的get()方法
 */
public class Test2 {
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        list.add("heihei");
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
