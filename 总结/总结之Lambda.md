#### Lambd表达式

范例：传统的面向对象开发

```java
interface IMessage2{
    void print();
}

public class TestDemo {
    public static void main(String[] args) {
        IMessage2 message2 = new IMessage2() {//匿名内部类
            @Override
            public void print() {
                System.out.println("MyMessage");
            }
        };
        message2.print();
    }
}
```

对于此类操作有了更简化实现，如果采用函数式编程，则代码如下：

范例：函数式编程

```java
@FunctionalInterface//表明函数式编程
interface IMymessage3{
    void print();
}
public class Test16 {
  public static void main(String[] args) {
   IMymessage3 mymessage3 =()-> System.out.println("MyMessage");
        mymessage3.print();
    }
}
```

面向对象语法最大的局限：结构必须非常完整。

要想使用函数式编程有一个前提：接口必须只有一个抽象方法，如果有两个抽象方法，则无法使用函数式编程。如果现在某个接口就是为了函数式编程而生的，最好定义时就让其只能够定义一个抽象方法，所以有了一个新注解`@FunctionalInterface`注解。

Lambda表达式语法：`(参数) -> {} ;`(多行时)，`(参数) -> 单行语句`.

范例：多行语句

```java
@FunctionalInterface
interface IMessage{
  public void print();
}
public class TestDemo{
  public static void main(String[] args){
    IMessage message = () -> {
      System.out.println("hello");
      System.out.println("world");
      System.out.println("hello world");
    };
    message.print();
  }
}
```

**如果现在你的表达式里只有一行进行数据的返回，那么直接使用语句即可，可以不使用return**

范例：直接进行计算

```java
@FunctionalInterface
interface IMath{
     int add(int a,int b);
}

public class Test17 {
    public static void main(String[] args) {
        IMath math = (p1,p2) ->(p1+p2);
        System.out.println(math.add(20,30));
    }

}
```

#### 方法引用

>1.引用静态方法：类名称::static 方法名
>
>2.引用某个对象的方法：实例化对象::方法名
>
>3.引用某个特定类的方法：类名称::普通方法
>
>4.引用构造方法：类名称::new

范例：String类的valueOf()方法

```java

/**
 * 方法引用
 * @param <P>
 * @param <R>
 */
@FunctionalInterface
interface IMyMessage4<P,R>{
    R switchPara(P p);
}

public class Test18 {
    public static void main(String[] args) {
        IMyMessage4<Integer,String> message4 = String::valueOf;//进行方法引用
        String str = message4.switchPara(100);//相当于调用了String.valueOf
        System.out.println(str.length());
    }
}
//打印结果：3
```

范例：引用对象方法

String中的toUpperCase()方法为对象方法

```java
@FunctionalInterface
interface IMyMessage5<R>{
    R switchpara();
}

public class TestDemo{
    public static void main(String[] args) {
        IMyMessage5 iMyMessage5 = "hello"::toUpperCase;
        System.out.println(iMyMessage5.switchpara());
    }
}
```

范例：引用类中普通方法

String类中有一个compareTo方法，此方法为普通方法

```java
@FunctionalInterface
interface IMyMessage6<R,P>{
    R compare(P p1,P p2);
}

public class TestDemo{
    public static void main(String[] args) {
        IMyMessage6<Integer,String>   message6 = String::compareTo;
        System.out.println(message6.compare("侯","姚"));
    }
}
```

范例：引用构造方法

```java

class Person2{
    String name;
    int age;
    public Person2(){

    }
    public Person2(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
@FunctionalInterface
interface IMyPerson<R,PN,PA>{
    R message(PN name,PA age);
}

public class TestDemo {
    public static void main(String[] args) {
        IMyPerson<Person2,String,Integer> myPerson = Person2::new;
        System.out.println(myPerson.message("monkeyc97",21));
    }
}
```

#### 内建函数式接口

Lambda的核心在于：函数式接口。而函数式接口的核心：只有一个抽象方法

`java.util.function`实际上函数式编程分为以下四种接口：

> 1.功能性函数式接口：public interface Function<R,T> R apply(T t);
>
> 2.供给型函数式接口:  public interface Supplier T get();
>
> 3.消费型函数式接口：public interface Consumer void accept(T t);
>
> 4.断言型接口：public interface Predicate boolean test(T t);

##### 功能型接口

- 功能型指的是你输入一个数据，而后将数据处理后进行输出

  实际上所有的函数式接口里面都会有一些小的扩展。

```java
import java.util.function.Function;

public class TestDemo {
    public static void main(String[] args) {
        Function<Integer,String> function = String::valueOf;
        String str = function.apply(100);
        System.out.println(str.length());
    }
}
```

如果现在确定操作的数据是int，则可以使用IntFunction接口

```java
import java.util.function.IntFunction;
public class TestDemo {
public static void main(String[] args) {
        IntFunction<String> function = String::valueOf;
        String str = function.apply(111);
        System.out.println(str.length());
    }
}
```

##### 供给型接口

```java
import java.util.function.Supplier;
public class TestDemo{
  public static void main(String[] args){
    Supplier<String> stringSupplier = "hello"::toUpperCase;
        System.out.println(stringSupplier.get());
  }
}
```

#####消费型接口

```java
import java.util.function.Consumer;
public class TestDemo{
  public static void main(String[] args){
      Consumer<String> consumer = System.out::println;
        consumer.accept("hehe");
  }
}
```

##### 断言型接口

```java
import java.util.function.Predicate;
public class TestDemo{
  public static void main(String[] args){
    Predicate<String> pre = "###123shdsb" ::startsWith;
    System.out.println(pre.test("##"));
  }
}
```

