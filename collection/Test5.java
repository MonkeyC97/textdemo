package Review.Test.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set子类的使用
 */
public class Test5 {
    //HashSet的使用
    public static void main1(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("haha");
        set.add("haha");
        set.add("hehe");
        for(String str :set){
            System.out.println(str);
        }
    }
    //TreeSet的使用
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("C");
        set.add("D");
        set.add("B");
        set.add("D");
        set.add("A");
        set.add("E");
        set.add("Z");
        set.add("a");
        System.out.println(set);
    }
}
