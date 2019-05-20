

# 7 抽象类与接口

## 7.1抽象类

##### 7.1.1抽象类的概念

​	1.最终类：若一个类不能被继承，则应该用final关键字所修饰，称该类为最终类。最种类位于类的树状结构的最底端，不能被继承。如：

```java
final class Leaf{
  ...
}
```

​	系统类库中，String类，StringBuffer类等都是final类。

​	

​	2.抽象类：抽象类与最种类刚好相反，必须被继承，使用关键字abstarct声明。如：

```java
abstract class FatherClass{
  ...
}
```

​	抽象类的类体定义与普通类定义相似，只是，其中可以包含一类特殊的成员方法，即抽象方法。抽象方法只有方法首部声明，没有方法体。所以，抽象类不能生产实例化对象。

```java
abstract class Drink{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void print();//抽象方法，没有方法体，用abstract修饰
}
```

​	抽象方法定义的格式：

```java
[访问修饰符] abstract 返回值类型 方法名称(参数列表);
```



##### 7.1.2抽象类的使用原则

​	1.所有的抽象类都必须被继承，必须要有子类

​	2.抽象类的子类必须要覆盖抽象类的抽象方法，抽象类子类则不需要。

​	3.抽象类的对象可以通过对象多态性利用子类实例化

​	4.private 和 abstract不能同时使用

```java
abstract class Drink{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void print();//抽象方法，没有方法体，用abstract修饰
}

class tea extends Drink{
    @Override
    public void print() {
        System.out.println("茶");
    }
}
public class TestAbstract {
    public static void main(String[] args) {
        Drink drink = new Tea();//实例化子类，向上转型
        drink.print();
    }
}
```



##### 7.1.3抽象类的相关规定

##### ***抽象类中也允许存在构造方法，子类也遵循对象实例化流程，在实例化子类对象之前，先调用父类的构造放法。***

​	例如：

```java
abstract  class Drink{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void print();

    public Drink(){
        System.out.println("饮料");
    }
}

class Cola extends Drink{

    @Override
    public void print() {

    }
    public Cola(){
        System.out.println("可乐");
    }
}

public class TestAbstract{
    public static void main(String[] args) {
       new Cola();
    }
}//打印结果 饮料 可乐
```

​	如果父类没有无参数构造函数，那么一定要指明子类必须要使用super去调用哪些父类的构造方法。

​	抽象方法必须是写在抽象类里面的，但是一个抽象类可以没有任何抽象方法，但是此时抽象类依然无法直接实例化对象。

​	抽象类一定不能使用final声明，因为被final修饰的类称为最终类不能被任何类继承，但是抽象类则是必须被子类继承的。

## 7.2 模版设计模式

##### 7.2.1 开闭原则(OCP):软件中的对象（类，模块，函数等等）应该对于扩展是开放的，但是对于修改是封闭的。



##### 7.2.2 模版设计模式是抽象类的一个实际应用场景



##### 7.2.3 美食作家王刚老师对酸菜鱼和水煮鱼的做法（精简版）

​	酸菜鱼：

​		1:准备食材

​		2:把水烧开

​		3:煮鱼

​		4:放酸菜

代码：

```java
class PourFish{
    //酸菜鱼做法
    void pourMake(){
        prepared();
        boilWater();
        boilFish();
        putSour();
    }
    public void prepared(){//准备食材
        System.out.println("准备鱼和酸菜");
    }
    public void boilWater(){
        System.out.println("把水烧开");
    }
    public void boilFish(){
        System.out.println("煮鱼");
    }
    public void putSour(){
        System.out.println("放酸菜");
    }
}
public class MidTest{
    public static void main(String[] args) {
       PourFish pourFish =  new PourFish();
       pourFish.pourMake();
    }
}
//准备鱼和酸菜
//把水烧开
//煮鱼
//放酸菜
```



​	水煮鱼：

​		1:准备食材

​		2:把水烧开

​		3:煮鱼

​		4:放青菜

```java
class OilFish{
    //水煮鱼做法
    void OilMake(){
        prepared();
        boilWater();
        boilFish();
        putGreen();
    }
    public void prepared(){//准备食材
        System.out.println("准备鱼和青菜");
    }
    public void boilWater(){
        System.out.println("把水烧开");
    }
    public void boilFish(){
        System.out.println("煮鱼");
    }
    public void putGreen(){
        System.out.println("放青菜");
    }
}
public class MidTest{
    public static void main(String[] args) {
       OilFish oilFish =  new OilFish();
       oilFish.OilMake();
    }
}
//准备鱼和青菜
//把水烧开
//煮鱼
//放青菜
```

​		从中可以看出，酸菜鱼和水煮鱼的实现有很大一部分的过程都是相同的，我直接更改一下代码,定义一个FishMake抽象类来做两种鱼。

```java
abstract class FishMake{//抽象类"做鱼"

    final void fishmake(){ //用final修饰的方法，子类不能覆盖

        prepare();
        boilWater();
        boilFish();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }
    public void prepare(){
        System.out.println("准备食材");
    }
    public void boilWater(){
        System.out.println("烧水");
    }
    public void boilFish(){
        System.out.println("煮鱼");
    }
    abstract void addCondiments();

    boolean customerWantsCondiments(){//勾子方法
        return true;
    }
}

class SourFish extends FishMake{

    @Override
    void addCondiments() {
        System.out.println("加酸菜");
    }
}
class OilFish extends FishMake{

    @Override
    void addCondiments() {
        System.out.println("加青菜");
    }
        
    public boolean customerWantsCondiments(){
       String answer = getUserInput();
       if(answer.equals("y")){
           return true;
       }else{
           return false;
       }
   }
   private String getUserInput(){
       String answer = null;
       System.out.println("您想要在水煮鱼中加青菜吗(y/n)");
       Scanner scanner = new Scanner(System.in);
       answer = scanner.nextLine();
       return answer;
   }
}

public class MidTest{
    public static void main(String[] args) {
       FishMake sourFish = new SourFish();
       FishMake oilFish = new OilFish();
        System.out.println("sourfish Making...");
        sourFish.fishmake();
        System.out.println("oilfish Making...");
        oilFish.fishmake();
    }
}
/*打印结果
sourfish Making...
准备食材
烧水
煮鱼
加酸菜
oilfish Making...
准备食材
烧水
煮鱼
您想要在水煮鱼中加青菜吗(y/n)
y
加青菜
*/
```



## 7.3接口

​	

##### 7.3.1 接口的概念

​	Java语言中的接口常应用于一下两个方面：

​	（1）将类看成是一个接口。用接口来声明一个变量。

​	（2）用类实现接口。在接口中定义一组通用的抽象方法，然后，在类中实现接口中的这组方法，为接口中的方法添加方法体。这时，我们称**该类实现了接口**。

​	Java语言中类具有单根性，也就是说一个字类不能同时继承俩个父类，但是一个类可以实现多个接口。



##### 7.3.2 接口的定义

​	1.接口定义格式如下：

```java
[访问修饰符] interface 接口名
{
	[常量定义]
	[抽象方法的定义]
}
```

​	例如：定义一个交易接口

```java
public interface ITrade {//接口声明
    final String bankName = "ChinaBank";//定义常量银行名
    abstract void saving(double monkey);//取款
    abstract void fetch(double monkey);//存款
}
```

​	2.接口的特征

​	Java把接口当作一个特殊的类看待。当对java源文件编译的时候，每个接口被编译为一个独立的字节码文件。每个接口名对应生成一个同名的字节码文件。但是，接口没有实例。

​	接口有一下特点：

​	（1）接口中常量的修饰符，默认情况下都是public,static和final类型。

​	（2）接口中的方法名的修饰符，默认情况下都是public 、abstract类型。

##### 7.3.3 类实现接口

​	（1）类实现接口的语句格式

​	当一个类通过关键字implements声明自己实现一个或多个接口时，这个了就继承了接口中的成员，这时，类和接口的关系相当于子类和父类的关系。例如，类ClassName 实现接口Printable和接口Addable的格式如下：

```java
class ClassName implements Printable,Addable{
  [常量定义][变量定义][方法定义]
  //为接口中的抽象方法添加方法体
}
```

​	例如，Dog类继承类Animal并实现接口Eatable和接口Sleepable的语句如下：

```java
class Dog extends Animal implements Eatable,Sleepable{
  //在这里定义Dog类的成员，并为接口中的抽象方法添加方法体
}
```

​	（2）类实现接口的实例

```java
public interface IGreeting {
    final String humanName = "houchang";
    abstract void voice();
}

class HumanBeings implements IGreeting{

    @Override
    public void voice() {
        System.out.println("hello");
    }
}

public class Dogs implements IGreeting {
    @Override
    public void voice() {
        System.out.println("汪汪汪");
    }
}

public class Cats implements IGreeting {
    @Override
    public void voice() {
        System.out.println("喵喵喵");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        HumanBeings houchang = new HumanBeings();
        houchang.voice();
        Dogs dogs = new Dogs();
        dogs.voice();
        Cats cats = new Cats();
        cats.voice();
    }
}//hello 汪汪汪 喵喵喵
```

注意的问题：

（1）一个类实现接口时，在类的声明部分用implements 关键字声明该类实现哪些接口

（2）若实现接口的类不是abstract的抽象类，则在类的定义部分必须实现接口中的所有抽象方法，即为所有抽象方法定义方法体。

（3）类实现接口中的方法时，必须使用完全相同的方法头，即有完全相同的返回值和参数列表。

（4）接口中的抽象方法的访问修饰符都默认为public，因此在类的定义中必须显式地使用public修饰符，否则会出现"Cannot reduce the visibility of the inherited method"（不能降低方法的访问范围）

（5）若类药实现的接口有一个或多个父接口，则在类体中必须实现该接口及其所有父接口中的所有抽象方法。

##### 7.3.4 接口当类使用

```java
public interface IEmployee {
    public static final double prize = 1000;
    public abstract void addSalary(int n);
}

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

/*打印结果
name:HouChang
I am employee
Salary:5300.0
hireDay:2019-09-01

name:YaoYihuan
I am employee
salary:14300.0
hireday:2019-09-02
*/
```



##### 7.3.4接口的继承

```java
//先定义一个接口
interface DoIt{
  abstract void doSomething(int i,double x);
 	abstract void doSomethingElse(String s);
}
//假设有许多类现在已经实现了这个接口
class Person implements DoIt{
  ...//覆盖接口中所有的抽象方法
}
class Animals implements DoIt{
  ...//覆盖接口中所有的抽象方法
}
class Robot implements Doit{
  ...//覆盖接口中所有的抽象方法
}
...//此时，我们需要给这个接口中再添加一个方法
  //接口变成了如下：
interface DoIt{
  abstract void doSomething(int i,double x);
 	abstract void doSomethingElse(String s);
  boolean didItWork(int i,String s,double x);//添加方法
}
//那么问题出现了，哪些实现了原来接口的类都要改变，如果类有很多，则相应地要进行大量修改

//解决办法（接口的继承）

interface DoItPlus extends DoIt{
  boolean didItWork(int i,double x,String s);
}
//此时你需要定义的类直接去实现这个继承接口之后的接口就可以在类中覆盖三种抽象方法了，而不需要大量更改代码
```























