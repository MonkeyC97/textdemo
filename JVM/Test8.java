package Review.Test.JVM;

/**
 * 动态对象年龄判定
 */
/**
 * JVM参数如下:
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC(使用Serial+Serial Old收集器组合)
 * -Xms20M -Xmx20M -Xmn10M(设置新生代大小)
 * -XX:SurvivorRatio=8(Eden:Survivor = 8 : 1) * -XX:MaxTenuringThreshold=15
 * @author 38134
 *
 */

public class Test8 {
    private static final int _1M = 1024*1024;
    public static void testAllocation(){
        byte[] Allocation1,Allocation2,Allocation3,Allocation4;
        Allocation1 = new byte[_1M/4];
        Allocation2 = new byte[_1M/4];
        Allocation3 = new byte[4*_1M];
        Allocation4 = new byte[4*_1M];
        Allocation4 = null;
        Allocation4 = new byte[4*_1M];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
