package Review.Test.collection;

import java.util.List;
import java.util.Vector;

public class Test4 {
    public static void main(String[] args) {
        List<String> list  = new Vector<>();
        list.add("hehe");
        list.add("hah");
        list.clear();
        System.out.println(list);
    }
}
