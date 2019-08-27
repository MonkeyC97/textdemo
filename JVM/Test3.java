package Review.Test.JVM;

/**
 * 对象的循环引用问题
 */
public class Test3 {
    public Object instance = null;
    private static int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        Test3 test1 = new Test3();
        Test3 test2 = new Test3();
        test1.instance = test2;
        test2.instance = test1;
        test1 = null;
        test2 = null;
        System.gc();//强制垃圾回收
    }
    public static void main(String[] args) {
        testGC();
    }
}
