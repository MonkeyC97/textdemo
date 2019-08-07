#### 1.枚举

```java
//定义一个描述颜色基色的多例类

class Color{
    private String title;
    public static final int RED_FLAG = 1;
    public static final int BLUE_FLAG = 2;
    public static final int GREEN_FLAG = 3;
    private static final Color red = new Color("red");
    private static final Color blue = new Color("blue");
    private static final Color green = new Color("green");
    private Color(String title){
        this.title = title;
    }

    public static Color getInstance(int ch){
        switch (ch){
            case RED_FLAG:
                return red;

            case BLUE_FLAG:
                return blue;

            case GREEN_FLAG:
                return green;

                default:
                    return null;
        }
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println(Color.getInstance(Color.RED_FLAG));
    }
}

```

这样做的目的是**限制本类实例化对象的产生个数**。

但是从JDK1.5之后，有了枚举，上述代码可以用枚举来取代。

```java
enum EColor {
    RED,BLUE,GREEN
}

public class TestEnum {
    public static void main(String[] args) {
        System.out.println(EColor.RED);
    }
}
```

#### 2.Enum类

1.构造方法

```java
protected Enum(String name,int ordinal)
```

2.取得枚举名字

```java
public final String name();
```

3.取得枚举序号

```java
public final int ordinal();
```

```java
/**
 * enum关键字的使用
 */
enum EColor {
    RED,BLUE,GREEN
}



public class TestEnum {
    public static void main(String[] args) {
        System.out.println(EColor.RED);
        System.out.println(EColor.RED.ordinal()+"\n"+EColor.GREEN.name());

    }
}
//打印结果
//RED
//0
//GREEN
```

所有的枚举类默认继承与Enum类

在枚举操作中还有一个方法可以取得所以的枚举数据：values()返回的是一个枚举的对象数组。

```java
enum EColor {
    RED,BLUE,GREEN
}



public class TestEnum {
    public static void main(String[] args) {
        for(EColor e : EColor.values()){
            System.out.println(e.ordinal()+e.name());
        }
    }
}
//0RED
//1BLUE
//2GREEN
```

enum与Enum的区别：

- enum是一个关键字使用它定义的类实际上就是继承了Enum这个抽象类而已

#### 1.3 定义结构

虽然枚举等同于多例设计，但是在多例设计是一个类中产生的，所以该类中可以定义更多的属性或方法，所以在枚举设计的时候考虑到这些因素，提出了更为全面的设计方案：可以在枚举中定义属性、方法，实现接口

```java
//在枚举中定义更多的属性

enum Color2{
 RED("红色"),BLUE("蓝色"),GREEN("绿色");//如果定义多个内容，枚举对象必须写在第一行
 private String title;
  private Color2(String title){
    this.title = title;
}

    @Override
    public String toString() {
        return "Color2{" +
                "title='" + title + '\'' +
                '}';
    }
}


public class Test2 {
    public static void main(String[] args) {
        System.out.println(RED);
    }
}

```



```java
/**
枚举实现接口
*/
interface IColor {
    public String printTitle();
}


enum Color3 implements IColor{
    RED("红色"),BLUE("蓝色"),GREEN("绿色");
    private String title;

    @Override
    public String printTitle() {
        return title;
    }
    private Color3(String title){
        this.title = title;
    }
}

public class Test3{
    public static void main(String[] args) {
        IColor color = Color3.BLUE;
        System.out.println(color.printTitle());
    }
}
```

```java
//定义一个表示性别的枚举类
enum Sex{
    MAN("男"),FEMAIE("女");
    private String title;
    private Sex(String title){
        this.title = title;
    }
    @Override
    public String toString() {
        return title;
    }
}
class Person{
    private int age;
    private String name;
    private Sex sex;
    public Person(int age,String name,Sex sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public Person(){

    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}


public class Test4 {
    public static void main(String[] args) {
        Person person = new Person(19,"houchang",Sex.MAN);
        Person person1 = new Person();
        person.setSex(Sex.FEMAIE);
        person.setAge(20);
        person1.setAge(19);
        person1.setName("monkeyc");
        person1.setSex(Sex.MAN);
        System.out.println(person1.getAge()+person1.getName()+person1.getSex());
        System.out.println(person);
    }
}
/*打印结果
19monkeyc男
Person{age=20, name='houchang', sex=女}
*/
```

#### 2.注解

Annotation可以说是JDK发展的重要技术，从现在的开发来讲，Annotation的使用已经变得非常常见。

- 使用一个配置文件，程序运行的时候要通过配置文件读取相关的配置操作。

如果此时想要更改一些配置，那么只需要更改配置文件即可，也就是可以在不修改源代码的前提下实现项目的变更。

##### 准确覆写

方法覆写：发生在继承关系值中，子类定义了与父类的方法名称相同，参数列表相同、返回值类型相同成为方法的覆写，被覆写的方法不能够拥有比父类更为严格的访问控制权限。

```java
Class Person{
  public String toString(){
    return "hehe";
  }
}
public class TestDemo{
  public static void main(String[] args){
    System.out.println(new Person());
  }
}
```

注意：这个时候不叫覆写，属于自己定义了一个扩展的方法，最为重要的是，这个问题在程序编译的时候根本无法显示出来，为了保证覆写方法的严格，可以使用一个注解(@Override)来检测：如果该方法确定成功覆写，则不会有语法错误；如果没有成功覆写，则认为是语法错误。

```java
Class Person{
  @Override//追加了次注解后将明确的表示该方法是一个覆写的方法，如果覆写错误会出现语法错误
  Public String toString(){
    retuen "hehe";
  }
}
public class TestDemo{
  public static void main(String[] agrs){
    System.out.println(new Person());
  }
}
```

##### 声明过期

@Deprecated

```java

class Person{
    private String name;
    @Deprecated
    public Person(){

    }
    public Person(String name){
        this.name = name;
    }
    @Deprecated
    public void fun(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test11 {
    public static void main(String[] args) {
        Person person = new Person() ; // 明确的标记出过期
        person.fun();
        person = new Person("hehe") ;
        System.out.println(person);
    }

}
```

##### 压制警告

@SuppressWarings

当调用了某些操作可能产生问题的时候就回出现警告进行，但是警告信息不会导致程序出错，就可以使用压制警告。

#### 3.接口定义加强

从JDK1.8开始，提供了两类新的结构：

- 可以使用default来定义普通方法，需要通过对象调用
- 可以是用static来定义静态方法，通过接口名就可以调用s

```java
//定义普通方法
interface IMyMessage{
    public default void fun(){//接口中定义了普通方法，有方法体
        System.out.println("hehe");
    }
    public void print();

}
class MessageImpl implements IMyMessage{

    @Override
    public void print() {
        System.out.println("haha");
    }
}

public class Test13 {
    public static void main(String[] args) {
        IMyMessage myMessage = new MessageImpl();
        myMessage.print();
        myMessage.fun();
    }
}
//打印hehe，haha
```

```java
//定义static方法
interface IMessage1{
    public default void fun(){
        System.out.println("hehe");
    }

    public static IMessage1 message(){
        return new MyMessage1();
    }
    public void print();
}

class MyMessage1 implements IMessage1{

    @Override
    public void print() {
        System.out.println("hello");
    }
}
public class Test14 {
    public static void main(String[] args) {
        IMessage1 message1 = IMessage1.message();
        message1.print();
        message1.fun();
    }
}
//hello haha
```















