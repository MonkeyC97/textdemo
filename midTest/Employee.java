package com.monkeyc.midTest;

public class Employee implements IEmployee {
   private String name;
   private double salary;
   private String hireDay;
   public double getSalary(){
       return salary;
   }
   public String getName(){
       return this.name;
   }
   public String getHireDay(){
       return this.hireDay;
   }
    public void addSalary(int n) {
        this.salary = this.salary + prize*n;
    }
    public Employee(String name,double salary,String hireDay){
       this.name = name;
       this.hireDay = hireDay;
       this.salary = salary;
    }
    public void getInfo(){
        System.out.println("I am employee");
    }
}
