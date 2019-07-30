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

​	调用父类成员方法

```java
class Car {
    public void print(){
        System.out.println("我是汽车");
    }
}
class Suv extends Car{
    public void print(){
        super. print();
        System.out.println("我是路虎揽胜");
    }
}
public class CarTest{
    public static void main(String[] args) {
        Suv suv = new Suv();
        suv.print();
    }
}//打印结果 我是汽车 我是路虎揽胜
```

​	子类的成员变量隐藏了父类中同名的成员变量。通过super使用父类中被隐藏的成员变量。例如：

```java
class Person2{
    public int a = 10;//在子类中被隐藏的变量
    
}
class Student2 extends  Person2{
    public int a = 20;//在子类中定义了和父类中同名的变量
    public int  print(){
        return super.a+10;
    }
}
public class TestExtends{
    public static void main(String[] args) {
        Student2 student2 = new Student2();
        System.out.println(student2.print());
    }
}//打印结果20
```



## 6.3 final关键字

1.final关键字可以用来修饰类、变量、方法

2.final关键字修饰的类不能被继承，即不能拥有子类

3.用final关键字修饰的方法不能被重写

4.final一旦修饰⼀个类之后，该类的所有方法默认都会加上final修饰(不包含成员变量)



```java
final class ClassName{
		float fun()//此时这个fun方法已经被final所修饰
}
```



5.使用final定义的变量就成为了常量，并且不能被修改



```java
public final int A = 100;
public final int A_MAX = 1000;//被final修饰的变量不能被再次赋值，并且用大写字母中间用_隔开
```



6.Java提供的String类被定义为final类，不能被轻易修改



## 6.4重载(overload)和覆盖(override)

##### 1.重载的概念

​	在同一个类中有许多方法，它们的方法名相同，参数列表(参数个数，参数类型至少有一个不同)，方法的返回值不做要求，方法之间的这种现象被称为重载。例如：

```java
public void print(int r)
public void print(double r)//参数类型不同方法重载
```

```java
public void print(int r)
public void print(double r,int h)//参数类型不同并且参数个数不同的方法重载
```

又如：

```java
public void methodA()
public int methodA(){
	return 0;
}//这种不叫方法重载因为它们俩只是方法的返回值不同,并且在编译时会出错
```

又如:

```java
public void methodB()
public String methodB(String n){
  return n;
}//正确的方法重载，由此可见，方法重载时候方法的返回值可以不同
```

##### 2.覆盖的概念

方法的覆盖是子类和父类有同名且参数列表完全相同且返回值完全相同的方法，只是方法体不同，这种现象被称为覆盖。例如：

```java
class Student{
    protected String no;
    protected void print(){
        System.out.println("学号为："+no);
    }
}

class Granduate extends Student{
    String dept;
    public void print(){//方法的覆盖
        super.print();//使用super关键字调用父类中的方法
        System.out.println("专业为："+dept);
    }
}

public class TestOverride {
    public static void main(String[] args) {
        Student student = new Student();
        Granduate granduate = new Granduate();
        student.no = "41603050213";
        student.print();//父类对象调用父类中的方法
        System.out.println("-------------------");
        granduate.no = "41603050214";
        granduate.dept = "计算机科学与技术";
        granduate.print();//子类对象调用子类中的方法
    }
}
//打印结果为
/*

学号为：41603050213
-------------------
学号为：41603050214
专业为：计算机科学与技术

*/
```

由代码可知，根据该方法的对象所属的类决定调用哪个方法

覆盖之后的子类中的方法不能拥有比父类更加严格的访问权限，例如：

```java
//错误代码
class Student{
    protected String no;
    public void print(){
        System.out.println("学号为："+no);
    }
}

class Granduate extends Student{
    String dept;
     protected void print(){//方法的覆盖，此时子类中的方法修饰符权限是小于父类中的public的，编译出错
        super.print();//使用super关键字调用父类中的方法
        System.out.println("专业为："+dept);
    }
}
```

问题来了，当父类中的方法被private所修饰，子类中覆盖的方法被public修饰，算正确覆盖方法吗？

```java
class Student{
    protected String no;
  
  //如果现在⽗类⽅法使用了private定义，那么就表示该⽅法只能被父类使用，子类无法使用。换言之，子类根本就不知道⽗类有这样的方法。
    private void print(){
        System.out.println("学号为："+no);
    }
}

class Granduate extends Student{
    String dept;
     public void print(){//子类中的方法是新定义的方法和父类的方法没有任何关系
        System.out.println("专业为："+dept);
    }
}
```

##### 3.重载和覆盖的区别

|   No | 区别 | 重载(overload)             | 覆盖(override)                                               |
| ---: | :--: | -------------------------- | ------------------------------------------------------------ |
|    1 | 概念 | 方法名称相同，参数列表不同 | 方法名、参数列表、返回值类型相同                             |
|    2 | 范围 | 一个类之间                 | 继承关系父子类                                               |
|    3 | 限制 | 没有权限限制               | 子类中覆盖父类之后的方法不能拥有比父类中被覆盖的方法更严格的访问控制权限 |



## 6.5 多态



##### 1.多态的概念

对于Java语言来说，在同一类中或者不同类中，可以定义多个同名的方法，但是每个方法体中的代码却不同，这样系统会根据调用方法的对象或参数自动选择一个方法执行，向不同的对象发送相同的消息时，它们执行的方式就不同，我们称这种现象为多态。

##### 2.Java程序实现多态的步骤

（1）首先，在父类中声明一组方法

（2）其次，在各子类中对父类的同一方法进行覆盖和重写

##### 3.多态的表现

​	方法的多态：

​	（1）方法的重载：程序根据方法参数列表的不同去决定调用哪一个方法。

​	（2）方法的覆盖：同⼀个父类的方法，可能根据实例化子类的不同也有不同的实现。

​	对象的多态：

​		对于基本数据类型，在表达式计算或者赋值的时候存在数据类型转换；对于引用数据类型，也存在着数据类型转换。

```java
Person per = new Student();//向上转型
```

```java
Student stu = (Student) per;//向下转型
```

```java
//向上转型
class Person1{
    public void print(){
        System.out.println("人超类");
    }
}
class Student3 extends Person1{
    @Override
    public void print() {
        System.out.println("学生派生类");
    }
}
public class TestDemo1{
    public static void main(String[] args) {
        Person1 person1 = new Student3();//向上转型
        person1.print();
    }
}//打印结果 学生派生类
```

​	由上述程序可知，不论是否发生向上转型，关键是看你使用了那个子类，而且通过向上转型之后调用的方法是否被子类覆盖了。

```java
/*
向下转型
 */

class Person1{

    public void print(){
        System.out.println("父类方法");
    }
}

class Student3 extends Person1{
    @Override
    public void print() {
        System.out.println("子类覆盖方法");
    }
    public void fun(){
        System.out.println("子类独有方法");
    }
}
public class TestDemo1{
    public static void main(String[] args) {
        Person1 person1 = new Student3();
        person1.print();
        Student3 student3 = (Student3)person1;//向下转型
        student3.fun();
    }
}
//打印结果
//子类覆盖方法
//子类独有方法
```

向下转型之前必须先发生向上转型。



```java
Person per = new Person();
Student stu = (Student) per;
```



上述程序在向下转型的时候没有经过向下转型，会出现错误: ***Exception in thread "main" java.lang.ClassCastException.***



在转换前，为确保对象是某个类的实例，可以用运算符号 ***instanceof*** 测试。

```java
class Person1{

    public void print(){
        System.out.println("父类方法");
    }
}

class Student3 extends Person1{
    @Override
    public void print() {
        System.out.println("子类覆盖方法");
    }
    public void fun(){
        System.out.println("子类独有方法");
    }
}
public class TestDemo1{
    public static void main(String[] args) {
        Person1 person1 = new Student3();
        System.out.println(person1 instanceof Student3);
        System.out.println(person1 instanceof Person1);
        if(person1 instanceof Student3){
            Student3 student3 = (Student3)person1;
            student3.fun();
        }
    }
}
//结果
//true
//true
//子类独有方法
```

向上转型的目的是什么呢？看一组代码：

```java
/*
向上转型的目的是什么呢
 */

//先看常规的代码
class Person3{
    public void print(){
        System.out.println("父类方法");
    }
}
class Student1 extends Person3{
    @Override
    public void print() {
        System.out.println("子类覆盖父类方法");
    }
    public void fun(){
        System.out.println("子类独有方法");
    }
}

public class TestDemo1{
    public static void main(String[] args) {
        Person3 person3 = new Person3();
        person3.print();
        Student1 student1 = new Student1();
        student1.print();
        student1.fun();
    }
}
```

要求定义⼀个方法，这个方法可以接收Person类的所有⼦类实例，并调用Person类的方法。

```java
class Person1{
    public void print(){
        System.out.println("人类");
    }
}
class Student3 extends Person1{
    @Override
    public void print() {
        System.out.println("学生");
    }
}
class Teacher extends Person1{
    @Override
    public void print() {
        System.out.println("老师");
    }
}
public class TestDemo1{
    public static void main(String[] args) {
        whoYouAre(new Student3());
        whoYouAre(new Teacher());
        whoYouAre(new Person1());
    }
    public static void whoYouAre(Person1 person1){
        person1.print();
    }
}//打印结果 学生 老师 人类
```

通过代码可以得出，通过向上转型，我们统一了操作参数 （person1）



















