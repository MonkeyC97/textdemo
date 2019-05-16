# 6. 面向对象编程—类与对象(下)

## 6.1 继承

继承是指一种类继承另外一种类的成员(成员变量和成员方法)，被继承的类称为父类(超类或者基类)，继承了父类的类被称为子类或者派生类。

##### 6.1.1 子类

在声明类的时候，使用关键字extends继承一个已经定义好的类(父类)，定义一个新的类(子类)。

定义子类的格式

```java
【访问修饰符】 class 子类名 extends 父类名{
  //子类的成员变量和成员方法
}
```

##### 6.1.2继承规则

Java中，类之间的继承原则为：

（1）子类继承父类中的所有非私有成员变量和非私有成员方法

（2）父类中的构造方法不能被继承

（3）子类中可以对父类成员重新定义，即Java允许子类中定义与父类中相同名字的成员，此时，父类中同名的成员变量在子类中被隐藏（Hiding），父类中同名的成员方法在子类中被覆写(override)

（4）如果子类和父类在不同包中，则子类只能继承父类中的protected、public成员

例如：重写父类成员

```java
class Father{
    protected int x;
    public Father(){}
    public Father(int x){
        this.x = x;
    }
    public void print(){
        System.out.println("父类中的x："+x);
    }
}
class Son extends Father{
    int x;
    public Son(int x){
        this.x = x;
    }
     public void print(){//方法的覆写
        System.out.println("子类中的x："+x);
    }
}
public class TestExtends {
    public static void main(String[] args) {
     Father father = new Father(10);
     Son son = new Son(20);
     father.print();
     son.print();
    }
}
//打印结果： 父类中的x：10    子类中的x：20
```

​	Son类中定义的成员变量x与父类中的成员变量x同名，父类中的x在子类中被隐藏，因此子类中的打印结果为子类中成员变量x的值，另外在子类中定义的成员方法覆写了父类中的同名方法，这样在主类中可以通过对象名调用各自的成员方法执行。

​	例如：子类继承父类的基本实现

```java
class Person2{
    private String name;
    int age;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void print(){
        System.out.println("name"+name);
    }
}
class Student extends Person2{
    private String name;
    public void print(){
        System.out.println("name:" + name);
    }
}


public class TestExtends {
    public static void main(String[] args) {
    Student student = new Student();//实例化一个派生类对象
    student.setName("houchang");//用派生类对象直接去调用超类里面的set方法
    student.setAge(18);
    System.out.println(student.getAge());//用派生类对象直接去调用超类里面的get方法
    System.out.println(student.getName());
    student.print();//null
    }
}
//打印结果 houchang 18 name = null；

```

例如：子类进行功能的扩充：

```java
class Person2{
    private String name;
    int age;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
class Student extends Person2{

    private String school;//子类属性的扩充

    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        return school;
    }
}


public class TestExtends {
    public static void main(String[] args) {
    Student student = new Student();
    student.setName("houchang");
    student.setAge(18);
    student.setSchool("清华大学");
    System.out.println(student.getAge());
    System.out.println(student.getName());
    System.out.println(student.getSchool());
    }
}//打印结果： houchang 18 清华大学
```

##### 	6.1.3 继承的限制

​	子类对象在实例化之前一定先要实例化父类对象，默认调用父类的构造方法之后再调用子类的构造方法进行子类对象初始化

```java
class Person2{
    public Person2(){
        System.out.print("父类对象产生");
    }
}
class Student extends Person2{
    public Student(){
       //super();隐藏的super关键字语句
        System.out.println("子类对象产生");
    }
}
public class TestExtends{
    public static void main(String[] args) {
        new Student();
    }
}
//打印结果： 父类对象产生  子类对象产生
```

​	通过以上代码我发现，没有任何⼀条语句调用父类构造方法。因此，子类对象实例化之前一定先实例化父
类对象，注意:实际上在子类的构造⽅法之中，相当于隐含了⼀个语句 *super();* 同时需要注意的是，如果父类里没有提供⽆参构造，那么这个时候就必须使⽤*super()*明确指明你要调用的父类构造方法。 

​	在Java中只允许单继承，也就是一个子类只能继承一个父类，例如：

```java
class A{}
class B{}
class C extends A,B{}
```

​	这种继承称为多继承，一个类C同时继承了A，B两个类，在Java中是错误的。

​	上述多继承的目的就是为了能在子类C中同时拥有AB两类的操作，为了这个目的，可以用多层继承来实现。

```java
class A{}
class B extends A{}
class C extends B{}//多层继承
```

​	思考，如果子类要继承父类中被private修饰的成员属性或成员方法，有办法让它实现吗？

​	答案是有！

```java
class Person2{
    private String name;//被private所修饰的属性
    private int age;//被private所修饰的属性
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

}
class Student extends Person2{
    public void fun(){
        System.out.println("name:"+getName()+"__"+"age:"+getAge());
    }
}


public class TestExtends{
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(19);//通过实例化子类对象去调用父类中的set方法
        student.setName("houchang");
        student.fun();
    }
}
//打印结果 name：houchang ——— age：19
```

​	上述程序被称为隐式继承，也就是在子类中使用父类中被private所修饰的操作。



## 6.2 super关键字

##### 	6.2.2 调用父类构造方法

​	子类是不能调用父类的构造方法的，如果要使用父类的构造方法一定要在子类的构造方法中使用关键字super，并且super必须是子类构造方法中的头一条语句。例如：

```java
class Person2{
    private String name;
    private int age;

    public Person2(String name,int age){
        this.age = age;
        this.name = name;
        System.out.println("name:"+name+"-"+"age:"+age);
    }

}

class Student extends Person2{
    public Student(String name,int age){
        super(name,age);//super关键字写在第一行
    }
}

public class TestExtends{
    public static void main(String[] args) {
        new Student("houchang",19);
    }
}
```

​	1.在子类中调用父类构造方式的唯一方式是：super() 或者super(参数表)。这两句必须写在子类构造方法体中的第一行。

​	2.如果在子类的构造方法体中没有显式地调用super调用语句，则编译器自动调用父类的默认构造方法。

​	3.如果在父类中定义了构造方法，但是没有定义默认的构造方法，则子类中不能调用父类的默认构造方法。否则会出错。

##### 	6.2.2调用父类成员

​	通过6.1继承节里面，得出当子类中定义了和父类中同名的成员变量和成员方法时，父类的成员变量和成员方法不能被子类所继承下来，此时称为子类隐藏了父类的成员变量和成员方法，如果要在子类中使用被隐藏的父类成员，或者使用父类中的构造方法，就必须在子类中使用关键字 ```super```。

```java
//调用父类成员
class Circlee{
     float r = 5;
     public Circlee(float r){
         this.r = r;
     }
     public double getArea(float r){//圆面积
         return r * r * Math.PI;
     }
     public double getLong(){//圆周长
         return 2 * r * Math.PI;
     }
}
class Cylinder extends Circlee{//子类Cylinder(圆柱)
    float h = 8;

    public Cylinder(float r,float h){
        super(r);//调用父类构造方法，初始化父类成员变量r
        this.h = h;
    }
    public double getArea(){
        double d_area;//保存两个圆的面积
        double c_area;//保存圆柱侧面积
        d_area = 2 * super.getArea(r);//俩低圆面积
        c_area = super.getLong() * h;//圆柱侧面面积
        return d_area+c_area;
    }

    @Override
    public double getLong() {
        return 2 * 2 * r * Math.PI;
    }
}
public class SuperDemo{
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5,20);
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getLong());
    }
}
//打印结果785.3981633974483

```

例如











