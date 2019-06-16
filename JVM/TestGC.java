package com.monkeyc.JVM;

public class TestGC {
    private TestGC instance;
    private byte[] data = new byte[4 * 1024 * 1024];

    public static void main(String[] args) {
        TestGC t1 = new TestGC();
        TestGC t2 = new TestGC();
        t1.instance = t2;
        t2.instance = t1;
        //强制内存回收
        //Edit Configuration
        System.gc();
    }
}
