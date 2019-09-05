package Review.Test.JVM;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails
 * -XX:+UseSerialGC(使用Serial+Serial Old收集器组合)
 * -Xms20M -Xmx20M -Xmn10M(设置新生代大小)
 * -XX:SurvivorRatio=8(Eden:Survivor = 8 : 1) * -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution
 */

/**
 * 有问题
 */
public class Test7 {
    private static final int _1M = 1024 * 1024;
    @SuppressWarnings("unused")
    public static void testAllocaltion(){
        byte[] allocaltion1 = new byte[_1M / 4];
        byte[] allocaltion2 = new byte[4 * _1M];
        byte[] allocaltion3 = new byte[4 * _1M];
        allocaltion3 = null;
        allocaltion3 = new byte[4 * _1M];
    }
    public static void main(String[] args) {
        testAllocaltion();
    }
}
