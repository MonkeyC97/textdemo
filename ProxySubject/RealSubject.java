package com.monkeyc.ProxySubject;

public class RealSubject implements ISubject {
    @Override
    public void buyComputer() {
        System.out.println("买一台苹果笔记本");
    }
}

