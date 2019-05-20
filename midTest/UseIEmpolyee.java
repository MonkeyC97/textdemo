package com.monkeyc.midTest;

public class UseIEmpolyee {

    public UseIEmpolyee(){
        Employee e1 = new Employee("HouChang",3300.00,"2019-09-01");
        Employee e2 = new Employee("YaoYihuan",13300,"2019-09-02");
        e1.addSalary(2);
        System.out.println("name:"+e1.getName());
        e1.getInfo();
        System.out.println("Salary:"+e1.getSalary());
        System.out.println("hireDay:"+e1.getHireDay()+"\n");

        //e2
        e2.addSalary(1);
        System.out.println("name:"+e2.getName());
        e2.getInfo();
        System.out.println("salary:"+e2.getSalary());
        System.out.println("hireday:"+e2.getHireDay());
    }

    public static void main(String[] args) {
        new UseIEmpolyee();
    }
}
