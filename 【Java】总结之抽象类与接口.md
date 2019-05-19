

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





















