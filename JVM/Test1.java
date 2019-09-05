package Review.Test.JVM;

import java.util.ArrayList;

public class Test1 {
    static class OOMObject{

    }
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory() /1024/1024);
    }
}
