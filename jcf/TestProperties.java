package com.monkeyc.jcf;

import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("java","java is the best");
        properties.setProperty("PHP","PHP天下第一");
        System.out.println(properties.getProperty("java"));
        System.out.println(properties.getProperty("C++"));
        System.out.println(properties.getProperty("C++","C++ is the best too"));
    }
}
