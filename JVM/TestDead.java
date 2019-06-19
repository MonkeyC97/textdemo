package com.monkeyc.JVM;

public class TestDead {
    public Object instance = null;
    private static int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];
    public static  void testGC(){
        TestDead testDead1  = new TestDead();
        TestDead testDead2 = new TestDead();
        testDead1.instance = new TestDead();
        testDead2.instance = new TestDead();
        testDead1 = null;
        testDead2 = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }

}
