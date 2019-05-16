package localTest;

//class Father{
//    protected int x;
//    public Father(){}
//    public Father(int x){
//        this.x = x;
//    }
//    public void print(){
//        System.out.println("父类中的x："+x);
//    }
//}
//class Son extends Father{
//    int x;
//    public Son(){}
//    public Son(int x){
//        this.x = x;
//    }
//     public void print(){
//        System.out.println("子类中的x："+x);
//    }
//}

//class Person2{
//    private String name;
//    int age;
//    public void setName(String name){
//        this.name = name;
//    }
//    public String getName(){
//        return name;
//    }
//    public void setAge(int age){
//        this.age = age;
//    }
//    public int getAge(){
//        return age;
//    }
//}
//class Student extends Person2{
//
//    private String school;
//
//    public void setSchool(String school){
//        this.school = school;
//    }
//    public String getSchool(){
//        return school;
//    }
//}


//public class TestExtends {
//    public static void main(String[] args) {
//    Student student = new Student();
//    student.setName("houchang");
//    student.setAge(18);
//    student.setSchool("清华大学");
//    System.out.println(student.getAge());
//    System.out.println(student.getName());
//    System.out.println(student.getSchool());
//    }
//}


//class Person2{
//    public Person2(){
//        System.out.println("父类对象产生");
//    }
//}
//class Student extends Person2{
//    public Student(){
////        super();//此语句在父类构造参数没有参数的时候可以不用写
//        System.out.println("子类对象产生");
//    }
//}
//public class TestExtends{
//    public static void main(String[] args) {
//        new Student();
//    }
//}
//class Person2{
//    private String name;
//    private int age;
//
//    public Person2(String name,int age){
//        this.age = age;
//        this.name = name;
//        System.out.println("name:"+name+"-"+"age:"+age);
//    }
//
//}
//
//class Student extends Person2{
//    public Student(String name,int age){
//        super(name,age);
//    }
//}
//
//
//public class TestExtends{
//    public static void main(String[] args) {
//        new Student("houchang",19);
//    }
//}
class Person2{
    public int a = 10;

}
class Student2 extends  Person2{
    public int a = 20;
    public int  print(){
        return super.a+10;
    }
}
public class TestExtends{
    public static void main(String[] args) {
        Student2 student2 = new Student2();
        System.out.println(student2.print());
    }
}