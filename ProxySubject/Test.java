package com.monkeyc.ProxySubject;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance();
        subject.buyComputer();
    }
}
