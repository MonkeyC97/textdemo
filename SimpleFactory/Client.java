package com.monkeyc.SimpleFactory;

import com.monkeyc.factory.MacbookComputer;

import java.util.Scanner;

class ComputerFactory{
   public static Computer product(String type){
       Computer computer = null;
       if(type.equals("mac")){
           MacBookCompter macBookCompter = new MacBookCompter();
        computer = macBookCompter;
       }
       if(type.equals("surface")){
           SurfaceBook surfaceBook = new SurfaceBook();
           computer = surfaceBook;
       }
        return computer;
   }
}


public class Client {
    public void buyComputer(Computer computer){
        computer.print();
    }
    public static void main(String[] args) {
        System.out.println("请输入你要买的电脑型号");
        String type = null;
        Scanner scanner = new Scanner(System.in);
        type = scanner.nextLine();
        Client houchang = new Client();
        Computer computer = ComputerFactory.product(type);
        houchang.buyComputer(computer);
    }
}
