package com.monkeyc.factory;

public class Client{
   public void buyComputer(Computer computer){
       computer.printComputer();
   }

    public static void main(String[] args) {
        Client houchang = new Client();
        MacbookComputer macbookComputer = new MacbookComputer();
        houchang.buyComputer(macbookComputer);
    }
}
