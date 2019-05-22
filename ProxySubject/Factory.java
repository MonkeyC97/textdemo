package com.monkeyc.ProxySubject;

public class Factory {
    public static ISubject getInstance(){
        return  new ProxySubject(new RealSubject());
    }
}
