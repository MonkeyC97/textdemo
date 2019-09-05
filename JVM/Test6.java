package Review.Test.JVM;

/**
 * 大对象直接进入老年代
 */

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC(使用Serial+Serial Old收集器组合)
 * -Xms20M -Xmx20M -Xmn10M(设置新生代大小)
 * -XX:SurvivorRatio=8(Eden:Survivor = 8 : 1)
 * -XX:PretenureSizeThreshold = 3145728(此时不能写3MB)
 *
 */

public class Test6 {
    private static final int _1MB = 1024 * 1024;
    public static void testAllocation(){
        byte[] Allocation1 = new byte[4 * _1MB];
    }
    public static void main(String[] args) {
        testAllocation();
    }
}
