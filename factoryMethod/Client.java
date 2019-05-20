package com.monkeyc.factoryMethod;

import com.monkeyc.SimpleFactory.MacBookCompter;

public class Client {
    public void buycomputer(Computer computer){
        computer.print();
    }

    public static void main(String[] args) {
        Client client = new Client();
        AppleFactory factory = new AppleFactory();
        client.buycomputer(factory.createComputer());
    }
}
