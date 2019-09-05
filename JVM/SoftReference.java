package Review.Test.JVM;

import java.lang.ref.WeakReference;

/**
 * 软引用何时被收集
 * JVM参数：-Xmx200m -XX:PrintGC
 */
public class SoftReference {
    public static void main(String[] args) throws InterruptedException {
        //100M缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];
        //将缓存数据用软引用持有
        java.lang.ref.SoftReference<byte[]> softReference = new java.lang.ref.SoftReference<>(cacheData);
        WeakReference<byte[]> weakReference = new WeakReference<>(cacheData);
        //将缓存数据的强引用去除
        cacheData = null;
        System.out.println("第一次GC前"+cacheData);
        System.out.println("第一次GC前"+softReference.get());
        System.out.println("111"+weakReference.get());
        //进行强制垃圾回收
        System.gc();
        Thread.sleep(500);
        System.out.println("第一次GC之后"+cacheData);
        System.out.println("第一次GC之后"+softReference.get());
        System.out.println("222"+weakReference.get());
        //再分配一个120M的对象，看看回收之后对象的情况
//        byte[] newCacheData = new byte[120 * 1024 * 1024];
        System.out.println("分配之后"+cacheData);
        System.out.println("分配之后"+softReference.get());
        System.out.println("333"+weakReference.get());
    }
}
