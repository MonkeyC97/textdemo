package Review.Test.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 */
public class TestOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while(true){
            list.add(new Object());
        }
    }
}
