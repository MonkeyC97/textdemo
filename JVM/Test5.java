package Review.Test.JVM;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC(使用Serial+Serial Old收集器组合)
 * -Xms20M -Xmx20M -Xmn10M(设置新生代大小)
 * -XX:SurvivorRatio=8(Eden:Survivor = 8 : 1 : 1)
 *
 */
public class Test5 {
    private static final int _1MB = 1024 * 1024;
    public static void testAllocation(){
        byte[] Allocation1 = new byte[2*_1MB];
        byte[] Allocation2 = new byte[2*_1MB];
        byte[] Allocation3 = new byte[2*_1MB];
        byte[] Allocation4 = new byte[4*_1MB];

    }
    public static void main(String[] args) {
        testAllocation();
    }
}
