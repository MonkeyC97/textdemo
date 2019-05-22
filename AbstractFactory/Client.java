package com.monkeyc.AbstractFactory;

public class Client {
    public void buyComputer(Computer computer){
        computer.print();
    }
    public void useSystem(OperatingSystem system){
        system.printSystem();
    }
    public static void main(String[] args) {
        Client client = new Client();
        ProductionFactory factory = new AppleFactory();
        client.buyComputer(factory.createComputer());
        client.useSystem(factory.createSystem());
    }
}


