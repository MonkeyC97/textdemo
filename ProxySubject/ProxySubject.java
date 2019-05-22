package com.monkeyc.ProxySubject;

public class ProxySubject implements ISubject {
    private ISubject subject;
    public ProxySubject(ISubject subject){
        this.subject = subject;
    }
    public void produceComputer(){
        System.out.println("生产苹果电脑");
    }
    public void afterSale(){
        System.out.println("售后服务");
    }

    @Override
    public void buyComputer() {
        this.produceComputer();
        RealSubject subject = new RealSubject();
        subject.buyComputer();
        this.afterSale();
    }
}
