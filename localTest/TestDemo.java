package localTest;

 //this关键字的用法
//class Person1 {
//    private String name;
//    private int age;
//    private int k = 1;
//    private double salary = 1000;
//    public Person1(String n,int a){
//        this.name = n;
//        this.age = a;
//    }
//    public double getSalary(){
//        int k = 2000;
//        return salary+this.k;//this关键字表示对本类属性的引用k=1
//    }
//}
//
//public class TestDemo{
//    public static void main(String[] args) {
//        Person1 person1 = new Person1("houchang",-100);
//                System.out.println(person1.getSalary());
//    }
//}
//打印结果1001.0
//
//class Person1{
//    private String name;
//    public void print(){
//        System.out.println("print方法"+this);
//    }
//}
//
//public class TestDemo{
//    public static void main(String[] args) {
//        Person1 person1 = new Person1();
//        System.out.println("main方法"+person1);
//        person1.print();
//        System.out.println("====================================");
//        Person1 person2 = new Person1();
//        System.out.println("main方法"+person2);
//        person2.print();
//    }
//}
//class Willc{
//     {
//         System.out.println("构造代码块");
//     }
//     public Willc(){
//         System.out.println("构造方法");
//     }
// }
//  public class TestDemo{
//      public static void main(String[] args) {
//          new Willc();
//          new Willc();
//      }
//  }





//代码块测试
class Code{
     {
         System.out.println("555非主类中的构造代码块");
     }
     static {
         System.out.println("666非主类中的静态代码块");
     }
     public Code(){
         System.out.println("777非主类中的构造函数");
     }
 }
public class TestDemo{
     public TestDemo(){
         System.out.println("333主类中的构造函数");
     }

     {
         System.out.println("111主类中的构造代码块");
     }
     static {
         System.out.println("222主类中的静态代码块");
     }

     public static void main(String[] args) {
         {
             System.out.println("444主类中的普通代码块");
         }
         new TestDemo();
         new TestDemo();
         new Code();
         new Code();
     }
 }

