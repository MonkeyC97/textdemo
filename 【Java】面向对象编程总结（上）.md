# 5. 面向对象编程—类与对象(上)

## 	5.1面向对象编程简介

##### 	    1.Java是一门面向对象的编程语言，为我们提供了定义类、定义属性、方法等最基本的功能。

##### 		2.面向对象的三大特征

​			（1）封装性

​			（2）继承性

​			（3）多态性

##### 		3.面向对象名次拓展

​			（1）OOA ：面对对象分析

​			（2）OOD：面对对象设计

​			（3）OOP：面向对象编程

## 	5.2面向对象的概念

​		采用面向对象的方法编写软件系统来解决现实世界中的问题，必须了解四个概念：实体，类，对象，消息。

		##### 		1.实体

​			我们把现实生活中存在的事、物体等统称为实体。如：特朗普，飞机，高铁，空气，桌子等都是实体。

##### 		2.类

​			类是人类对实体抽象的映射，是人类大脑抽象思考的结果，进行抽象总结出来一个模版，这个模版被称为类，所谓的类就是指共性的概念，描述了现实领域内一组实体的共同属性和共同行为特征。

#####		3.对象

​			对象是实际存在的，现实世界中实际存在，指的是一个具体的，可以使用的事物，如果以类为模版，给类中每一个变量赋值，就会得到一个实体，这个实体就是对象。

##### 		4.类与对象的关系

​			类是对象的抽象，对象是类的实例化。

​			首先先产生类才能实例化对象，对象的所有行为都在类中进行完整的定义。

##### 		5.类中的组成

​			属性：变量，描述了实体的静态特征。

​			方法：操作的行为，描述了实体的动态特征。

## 	5.3类的定义

​    1.语法

```java
class 类名
{
  属性1;
  属性2;
  属性n;
  方法1(){}
  方法2(){}
  方法n(){}...
}
```

​	2.定义一个Person类

```java
class Person{
  String name;//这个人有名字属性
  int age;//年龄属性
  String sex;//性别属性
  public Person(String name,int age,String sex){
    this.name = name;
    this.age = age;
    this.sex = sex;
  }
  void say(){//这个人可以说话的方法
    //具体代码
  }
  void run(){//这个人可以走路的方法
		//具体代码
  }
}
```

## 	5.4对象的创建和访问

​	有了类，就可以通过类来生产对象了。

​	1.语法

```java
类名称 对象名称 = new 类名称();
```

​	

​	2.创建一个Person类的对象

```java
Person per1 = new Person();
Person per2 = new Person("monkeyc",22,"男");
```

​	在Java程序中，使用构造方法创建对象，并为对象分配内存。整个表达式返回了对向在内存中的地址码,只要出

现了关键词new，表明在堆上分配了内存并且产⽣了Person类的对象per引⽤这部分内存.

其中，表达式new Person();的作用是创建对象，并为对象分配内存。整个表达式返回了对象在内存中的地址码。

赋值语句 Person per1 = new Person();表示把对象在内存中的地址码赋给变量per1，这是我们认为变量per1引用

了对象，我们也可以把变量per1理解为对象的名称。



​	3.下面的例子演示了变量的声明、对象的创建、为对象分配内存的过程。

```java
class Person{
    String name;
    int age;
    String sex;
    public Person(){
        this.name = "houchang";
        this.age = 22;
        this.sex = "男";
    }
    public Person(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
public class Test1{
  public static void main(String[] args){
    Person per = new Person();
    System.out.println(per.name);
    System.out.println(per.age);
    System.out.println(per.sex);
  }//打印结果为"houchang" 22 "男"
}
pulic class Test2{
  public static void main(String[] args){
    Person per = new Person("monkeyc",22,"男")
    System.out.println(per.name);
    System.out.println(per.age);
    System.out.println(per.sex);
  }
}//打印结果为"monkeyc" 22 "男"
```

如果类中我提供了一个或者多个构造方法，那么编译器将不再提供默认的构造方法。



## 5.5基本类型变量和对象类型变量

```java
int k;					//基本数据类型声明的变量
Circle circle1; //用类声明的变量
```

​	编译器对上面两条语句编译后，给变量k赋值0，给对象型变量circle1赋值为null。null代表空地址，表示circle1还没有引用任何对象，两个变量的内存模型如下图所示：![屏幕快照 2019-05-15 上午12.16.07](/Users/houchang/Desktop/屏幕快照 2019-05-15 上午12.16.07.png)

​		如果执行下面的赋值语句：

```java
int k = 8;
Circle circle1 = new Circle(15);//创建一个对象，并将对象的地址保存在circle1中
```

​		假设new Circle(15)创建的对象在内存中的地址是0xAC12，则，变量k和变量circle1的内存模型下图所示：

​	![屏幕快照 2019-05-15 下午1.55.11](/Users/houchang/Desktop/屏幕快照 2019-05-15 下午1.55.11.png)

再分析下面两条语句：

```java
Circle c1 = new Circle(5);

Circle c2 = new Circle(10);
```



假设new Circle(5) 创建的对象的地址是0x7896，new Circle(10)创建的对象的地址是0x4798，则变量c1和c2的内存模型如下图所示：![屏幕快照 2019-05-15 下午2.14.01](/Users/houchang/Desktop/屏幕快照 2019-05-15 下午2.14.01.png)

当执行下面语句后，变量c1和c2的内存模型如下图所示：

```java
Circle c1 = c2;
```

![屏幕快照 2019-05-15 下午2.25.45](/Users/houchang/Desktop/屏幕快照 2019-05-15 下午2.25.45.png)

垃圾回收器【自动垃圾回收机制，GC机制】
(1).当堆内存中的对象成为垃圾数据的时候，会被垃圾回收器回收
(2).什么时候堆内存当中的java对象会变成垃圾呢？
答：没有更多的引用指向他的时候，这个对象无法被访问因为这个对象只能通过引用的方式访问。



## 5.6封装和构造方法

### 5.6.1.使用private关键字进行封装，这种处理只是封装的第一步。

先看一组代码：

```java
class User{
    String name;
    int age;
}

public class UserTest{
    public static void main(String[] args) {
        User user = new User();
        user.name = "monkeyc";
        user.age = -100;
        System.out.println("用户名:"+user.name+"\n"+"用户年龄:"+user.age);
    }

}//打印结果为  用户名：monkeyc   用户年龄：-100
```

​     

对于当前程序来说： 

（1）显然，用户年龄是不可能为负数的。  
（2）User类中的age属性正在外部程序中可以随意访问，导致age属性的不安全。
（3） 一个User对象表示一个用户，用户的年龄不可能为负数，程序当中年龄值为负数，程序运行的时候并没有报错，这是当前程序存在的缺陷。



这里就需要使用封装，为什么要封装，封装有什么好处？

1.封装之后，对外提供简单的操作入口，比如电视机就是一个很好的封装案例，电视机的实现远离非常复杂，但是对于使用电视机的人来说，只需要使用遥控器来操控电视机而不用去关心其内部的实现原理。

2.封装之后才能形成真正的"对象"，真正的"独立体"。

3.封装就意味着以后的程序可以重复使用，并且这个事物应该适应性比较强，在任何场合都可以使用。

4.封装之后，对于事物本身，提高了安全性。



  封装的步骤：

1.所有属性私有化，使用private关键字进行修饰，private表示私有的，修饰的所有数据只能在本类中访问。

2.对外提供简单的操作入口，也就是说以后外部程序要访问age属性，必须通过这些简单的入口进行访问：

> 对外提供两个公开的方法，分别是set和get方法
>  ·想修改属性，调用set方法
>  ·想读取属性，调用get方法



 3.set方法的命名规范（以上述程序为例）：

```java
public void setName(String n){
  name = n;
}
```



4.get方法的命名规范

```java
public String getName(){
  return name;
}
```

setter and getter方法没有static关键字，有static关键字修饰的方法调用：类名.方法名（实参），没有static关键字修饰的方法调用引用.方法名（实参)。

### 5.6.2构造方法

​	构造方法是一种特殊的方法，其名称与类名必须一致并且没有返回值，方法名前也不加void。一个类中必须有构造方法，如果没有，系统会自动生成一个无参构造方法，一个类也可以有多个构造方法。构造方法的作用就是对成员变量初始化。

例如：使用构造方法设置对象属性

```java
class Person1{
    private String name;//定义俩Person1类的属性：姓名和年龄
    private int age;
    public Person1(String n,int in){//带参数的构造方法
        name = n;
        setAge(in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int i) {
       if(i < 0 || i >200){
           age = 0;
       }else{
           age = i;
       }
    }
    public void getInfo(){
        System.out.println("姓名："+name+"年龄："+age);
    }
}



public class TestDemo{
    public static void main(String[] args) {
        Person1 person1 = new Person1("houchang",-100);
        person1.getInfo();
    }
}//打印结果为姓名："houchang"年龄：0
```

构造⽅法的调用和对象内存分配⼏乎是同步完成的，因此我们可以利用构造方法来为类中的属性进行初
始化操作(可以避免多次*setter*调用)。

##### 构造方法的重载

```java
public Person1(){
  System.out.println("无参数的构造方法");
}
```

```java
public Person1(String n){
  name = n;
  System.out.println("有参数的构造方法");
}
```

在定义类的时候，先定义属性—>再定义构造方法-->再定义普通方法。

##### 对象属性的初始化方式？

(1).提供一系列的get和set方法（必须用public）

(2).通过提供合适的构造函数

(3).静态代码块和实例代码块

##### 对象的产生需要一下两步：

 (1) 为对象开辟内存

 (2) 调用合适的构造函数（说明构造函数不止一个）

##### 匿名对象的定义

new Person("monkeyc",22) .getInfo();

只使用一次，因为没有任何的栈内存指向它，使用一次后就变成垃圾空间。



### 5.6.3全局变量和局部变量

在类体中定义的变量就是全局变量，也称为成员变量，在类中所有的方法都可以调用它，在方法体中定义的变量就是局部变量，只能在方法内部来调用。

1.变量的作用域

```java
class employee{
  public int age;//成员变量
  public String name;//成员变量
  private double salary;//成员变量

public double getMouthSalary(){
  int k = 3300;//局部变量
  return salary+k;//salary是成员变量可以在类中的任何方法取调用
  }
public String getYearSalary(){
  return k*12;//这里就会出错，k是定义在getMouthSalary方法体中的所以不能在这个方法中使用
}
}
```

注意：成员变量可以不用初始化因为系统会赋一个默认值，但是成员变量必须初始化，不然编译出错。

2.局部变量和成员变量重名

```java
class Person1 {
    private String name;
    private int age;
    private int k = 1;//成员变量k
    private double salary = 1000;//成员变量salary
    public Person1(String n,int a){
        this.name = n;
        this.age = a;
    }
    public double getSalary(){
        int k = 2000;//局部变量k（与成员变量同名）
        return salary+k;
    }
}

public class TestDemo{
    public static void main(String[] args) {
        Person1 person1 = new Person1("houchang",-100);
        System.out.println(person1.getSalary());
    }
}
//打印结果3000.0
```

可以看出当成员变量和局部变量同名时，在方法内起作用的是局部变量k。那怎么在方法中使用同名的成员变量？

```java
class Person1 {
    private String name;
    private int age;
    private int k = 1;
    private double salary = 1000;
    public Person1(String n,int a){
        this.name = n;
        this.age = a;
    }
    public double getSalary(){
        int k = 2000;
        return salary+this.k;//k之前加了this关键字，此时的k就是成员变量k
    }
}

public class TestDemo{
    public static void main(String[] args) {
        Person1 person1 = new Person1("houchang",-100);
        System.out.println(person1.getSalary());
    }
}
//打印结果1001.0
```

成员变量的声明和赋值是一步完成的：

```java
class Person{
  String name = "蔡徐坤";
}
```

通过两步完成是非法的：

```java
class Person{
  String name;
  name = "蔡徐坤";//错误单独赋值语句时非法语句，单独的赋值语句只能在方法体中。
}
```



### 5.6.4 this关键字

Java语言中this关键字表示当前类的一个对象的引用，让类中一个方法访问该类的另一个方法或属性。

```java
//this表示当前对象

class Person1{
    private String name;
    public void print(){
        System.out.println("print方法"+this);//表示引用当前对象
    }
}

public class TestDemo{
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        System.out.println("main方法"+person1);
        person1.print();
        System.out.println("_________________");
        Person1 person2 = new Person1();
        System.out.println("main方法"+person2);
        person2.print();
    }
}
//打印结果为main方法localTest.Person1@63947c6b
//        print方法localTest.Person1@63947c6b
//       ====================================
//        main方法localTest.Person1@2b193f2d
//        print方法localTest.Person1@2b193f2d
```

```java
//this调用本类成员
//调用成员变量
class Person{
  private String name;
  int age;
  public Person(String name,int age){//参数与类中属性同名
    this.name = name;//用this.属性来表示此变量是成员变量
    this.age = age;//在类方法中访问类属性，必须使用this关键字
  }
}
//调用成员方法时语法为：
this.方法名([参数列表]);
```

```java
//this调用本类的构造方法
class Person{
  String name;
  boolean sex;
  Date4_3 birth
    public Person(){}
  	public Person(String name,boolean sex){
      this.name = name;
      this.age = age;
    }
  //使用对象实例为出生日期赋初值
  public Person(String name,boolean sex,Date4_3 birth){
    //构造方法中调用另一个构造方法，使用this([参数列表])
    this(name,sex);
    this.birth = birth;
  }
  //直接使用年月日的方式为出生日期赋初值
  public Person(String name,int age,int year,int mouth,int day){
    this(name,sex);
    this.birth = new Date4_3(year,mouth,day);
  }
}
```



### 5.6.5 static关键字

1.static属性

在了解static关键字之前，我们先来了解一下类变量和实例变量，二者的区别在于：类变量前有static关键字修饰，例如：

```java
class Person{
  private String name;
  private int age;//实例变量
  private static String country;//属性被static变量所修饰，所以此变量是一个类变量
}
```

成员变量和局部变量的区别：

局部变量定义在方法区中的变量，在栈中储存。

成员变量定义在类中的变量，成员变量里的实例变量在堆内存中储存：

（1）变量前加static修饰的是类变量，也称静态变量。访问使用 ```类名称+属性名```,不受对象的限制，可以直接访问。

（2）变量前没有static修饰的是实例变量。访问实例变量必须在实例化对象之后访问。

（3）如果需要描述共享属性的概念，或者不受对象实例化控制，使⽤static。

（4）静态变量储存在方法区内存中，而不是栈中。

（5）三块内存区变化最频繁的是栈内存，最先有数据的是方法区内存，垃圾回收器针对的是堆内存。

2.static方法

当以类为模版创建多个对象的时候，则每个对象拥有自己独立的实例方法，而所有对象公用类的所有类方法。

方法声明时，方法名前不加关键字static的是实例方法，加关键字的static的是类方法。

（1）实例方法调用

实例方法只有在对象创建之后才存在，调用实例方法的格式是：

```java
对象名.方法();
```

（2）类方法调用

类方法在对象创建以前就存在，调用类方法有两种格式：

1）对象没有创建之前

```java
类名.方法();
```

2）对象创建之后

```java
对象名.方法();    类名.方法();
```



例如：实例变量与类变量，实例方法与类方法的调用。

```java
class Circle1{
    private double radius;//实例变量
    private static int numOfObject;//类变量
    public Circle1(){
        this.radius = 1;//创建一个半径为1的圆
    }
    public Circle1(double radius){
        this.radius = radius;//带参构造方法
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public static int getNumOfObjects(){//跟踪创建的Circle1对象的个数
        return numOfObject;
    }
}

public class TestVariable {
    
    public static void printCircle(Circle1 circle1){
        System.out.println("半径("+circle1.getRadius()+")和对象数("+circle1.getNumOfObjects()+")");
    }
    
    public static void main(String[] args) {
        Circle1 circle1 = new Circle1();
        System.out.println("c1是：");
        printCircle(circle1);//在创建circle2之前显示circle1
        Circle1 circle2 = new Circle1(5);
        circle1.setRadius(10);
        //在c2创建之后，显示c1 和 c2
        System.out.println("\n在创建了c2并将c1的半径改为10之后");
        System.out.println("c1是 ： ");
        printCircle(circle1);
        System.out.println("c2是 ： ");
        printCircle(circle2);
    }
    
    

}

```

所有的static方法不允许调用非static修饰的变量或者方法

所有的非static方法可以调用static修饰的变量或者方法

使用static 方法的目的就是为了某些方法不希望收到对象的控制，即在没有实例化对象之前就可以执行。



## 5.7 代码块

先复习一下之前学习过的对象属性的初始化方式：

（1）提供一系列的get() set()方法

（2）提供合适的构造函数

（3）静态代码块或者实例代码块

代码块是什么呢？

定义：使用 { }定义的一段代码。

分为四种：

（1）普通代码块

（2）构造块

（3）静态块

（4）同步代码块



##### 5.7.1 普通代码块

定义在方法之内的代码块。

```java
public class Test{
   public static void main(String[] args) {
        {//普通代码块
            int x = 10;
            System.out.println(x);
        }
        int x =100;
        System.out.println(x);
    }
}//打印结果 10  100
```



##### 5.7.2 构造代码块

定义在类中的代码块(不加修饰符)

例如：

```java
class Willc{
     {
         System.out.println("构造代码块");
     }
     public Willc(){
         System.out.println("构造方法");
     }
 }
  public class TestDemo{
      public static void main(String[] args) {
          new Willc();
          new Willc();
      }
  }
//打印结果为构造代码块   构造方法   构造代码块   构造方法
```

通过以上代码发现，构造块优先与构造方法执行，每产生一个新的对象就调用一次构造块，构造块可以进行简单的逻辑操作（在调用构造方法之前）

##### 5.7.3 静态代码块

使用static定义的代码块

根据静态块所在类的不同又可以分为以下两种类型

> 1.在非主类中
>
> 2.在主类中



例如：

```java
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
```

上述程序打印结果为：

​	222主类中的静态代码块
​	444主类中的普通代码块
​	111主类中的构造代码块
​	333主类中的构造函数
​	111主类中的构造代码块
​	333主类中的构造函数
​	666非主类中的静态代码块
​	555非主类中的构造代码块
​	777非主类中的构造函数
​	555非主类中的构造代码块
​	777非主类中的构造函数

> 由此可以得出：不论静态代码块在主类中还是在非主类中，都只是打印一遍。
>
> 静态代码块 —> 构造代码块—>构造函数
>
> main方法中的普通代码块在静态代码块之后打印，也就是说在主类中定义的静态代码块，优先于主方法（main）执行。

### 5.8 内部类

内部类是一种在其他类的内部定义的类，包含内部类的类称为外部类。

例如：

```java
class Outer{
    private String msg = "hehe";
    class Inner{//内部类
        public void print(){//定义一个普通方法
            System.out.println(msg);
        }
    }
    //在外部类中定义一个方法，该方法产生内部类对象，并且调用print方法
    public void fun(){
        Inner inner = new Inner();
        inner.print();
    }
}

public class TestClass {
    public static void main(String[] args) {
        Outer outer = new Outer();//外部类实例化对象
        outer.fun();//调用外部类方法
    }
}//打印结果hehe
```

​	内部类可以方便的操作外部类的私有访问

​	内部类方法可以访问该类定义所在作用域中的数据，包括被private修饰的私有数据

​	内部类可以堆同一包中的其他类隐藏起来

​	内部类可以弥补Java单继承的缺陷

​	当想要定义一个回调函数却不用太大代码量的时候我们可以选择使用匿名内部类来完成。

##### 5.8.1 内部类分类

在Java中内部类主要分为：

（1）成员内部类

（2）静态内部类

（3）方法内部类

（4）匿名内部类

在使用内部类的时候创建内部类对象

```java
外部类.内部类 内部类对象 = new 外部类().new 内部类();
Outer.Inner inner = new Outer().new Inter();
```

在外部类内部创建内部类对象

```java
Inner inner = new Inner();
```



##### 5.8.2 成员内部类

在成员内部类中要注意两点：

>1.成员内部类中不能存在任何static的变量和方法
>
>2.成员内部类是依附于外部类的，所以只有创建了外部类才能好创建成员内部类



##### 5.8.3静态内部类

关键字static 可以修饰成员变量、方法、代码块、也可以修饰内部类，使用static修饰的内部类称为静态内部类。静态内部类于非静态内部类的最大区别就是，非静态内部类在编译完成的时候就会隐藏地保存着一个引用，该引用是指向创建它的外部类，但是静态内部类却没有。没有这个引用就意味着：

>1.静态内部类的创建是不需要依赖于外部类的，可以直接创建
>
>2.静态内部类不可以使用任何外部类的非static成员变量和方法，而内部类则都可以

外部类的创建语法：

```java
外部类.内部类 内部类对象 = new 外部类.内部类();
Outer.Inner inner = new Outer.Inner();
```

例如：使用static创建静态内部类

```java
class Outer{
  private static String mas = "hehe";
  static class Inner{}{
    public void print(){
      System.out.println(msg);
    }
  }
	public void fun(){
    Inner inner = new Inner();
    inner.print();
  }
}

public class Test{
  public static void main(String[] args){
    Outer.Inner inner = new Outer.Inner();
    inner.print();
  }
}
```

##### 5.8.4 方法内部类

方法内部类定义在外部类的方法中，局部内部类和成员内部类基本一致，只是它们的作用域不同，方法内部类只能在该方法中被使用，出了该方法就会失效。

>1.局部内部类不允许使用访问权限修饰符public private protected 均不允许。
>
>2.局部内部类对外完全隐藏，除了创建这个类的方法可以访问它，其他的地方不允许访问。
>
>3.局部内部类要想使用方法形参，该形参必须用final声明(JDK8形参变为隐式final声明)。

```java
class Outer{
    private int num;
    public void display(int test){
        class Inner{//不加访问权限修饰符
            public void fun(){
                num++;
                System.out.println(num);
                System.out.println(test);
            }
        }
        new Inner().fun();
    }
}
public class TestClass{
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display(20);
    }
}
```

##### 5.8.4 匿名内部类

匿名内部类是一个没有名字的方法内部类。

>1.匿名内部类没有访问修饰符
>
>2.匿名内部类必须继承一个抽象类或者接口
>
>3.匿名内部类中不能存在任何静态成员或者方法
>
>4.匿名内部类是没有构造方法的，因为它没有类名
>
>5.与局部内部类相同，匿名内部类也可以引用方法形参，此形参也必须声明final

```java
public interface IMyInterface {
    void test();
}
class Outer{
    private int num;
    public void display(int test){
        new IMyInterface() {
            @Override//方法重写
            public void test() {
                System.out.println("匿名内部类"+test);
            }
        }.test();
    }
}

public class TestClass{
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display(20);
    }
}
```

总结：内部类的特点：

1.破坏了程序的结构

2.方便进行私有属性的访问（外部了也可以访问内部类的私有域）

3.如果发现类名称上出现了```.```,应当首先考虑到内部类。







































