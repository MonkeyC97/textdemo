---
title: 通配符，类型擦除
---


#### 1.通配符

先看一段代码：

```java
class Point{
    private Object x;
    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
<!- more -->
public class Test4 {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(123);
        point.setY(456);
        String x = (String) point.getX();
        String y = (String) point.getY();
        System.out.println(x+y);
    }
}
```

程序会出现<font color=red>Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String</font>，这是因为两个没有关系的对象进行了强转而导致的。

​	在程序类中追加了泛型的定义之后，避免课ClassCastException的问题，但是又会出现新的情况：参数统一的问题。

观察下列程序：

```java
class Message<T> {
    private T message;

    public void setMessage(T message) {
        this.message = message;
    }
    public T getMessage(){
        return message;
    }
}


public class Test5 {
    public static void main(String[] args) {
        Message<String> message = new Message();
        message.setMessage("hello world");
        fun(message);
    }

    public static void fun(Message<String> message){
        System.out.println(message.getMessage());
    }
}
```

以上程序会带来新的问题，如果现在泛型的类型设置的不是String，而是Integer.

```java
public class Test5{
  public static void main(String[] args){
    Message<Integer> message = new Message();
    message.setMessage(99);
    fun(message);//报错
  }
  public static void fun(Message<String> message){
    System.out.println(message.getMessage());
  }
}
```

我们需要的解决方案就是：可以接受所有的泛型类型，但是又不能够让用户随意修改。这种情况就需要使用通配符"?"来处理。

```java
public class Test5 {
    public static void main(String[] args) {
        Message<String> message = new Message();
        message.setMessage("hello world");
        fun(message);
    }
//这里使用通配符"?"描述的是它可以接受任意数据类型，但是由于不确定类型，所以无法修改
    public static void fun(Message<?> message){
        System.out.println(message.getMessage());
    }
}//打印结果hello world
```

在?的基础上，又产生了两个字通配符：

- <font color=red>？extend类：设置泛型上限</font>

例如：？extends Number，表示只能够设置Number或其子类，例如：Integer、Double等

- <font color=red>？super类：设置泛型下限</font>

例如：？super String 表示只能够设置String及其父类Object

范例：观察泛型上限

```java
/**
 * 观察泛型上限
 */
class TopClass<T extends Number> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}

public class Test6 {
    public static void main(String[] args) {
        TopClass<Double> topClass = new TopClass<>();
        topClass.setMessage(12.3);
        fun(topClass);
    }
    public static void fun(TopClass<? extends Number> message){
//        message.setMessage(11.3);无法修改
        System.out.println(message.getMessage());
    }

}
```



范例：观察泛型下限

```java
/**
 * 设置泛型下限
 */

class Lowest<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}


public class Test7 {
    public static void main(String[] args) {
        Lowest<String> lowest = new Lowest<>();
        lowest.setMessage("hello");
        fun(lowest);
    }

    public static void fun(Lowest<? super String> message){
        message.setMessage("world");//可以修改
        System.out.println(message.getMessage());
    }
}
```

<font color=red>注意，上限可以用在声明，不能修改；而下限只能用在方法参数，可以修改内容！</font>

#### 2.泛型接口

泛型除了可以定义在类中，也可以定义在接口里面，这种情况我们称之为泛型接口。

```java
//定义一个泛型接口
interface IMessage<T>{
  public void print(T t);
}
```

例：在子类定义时继续使用泛型

```java

/**
 * 泛型接口的定义与使用
 */
interface IMessage<T>{
    public void print(T t);
}
class Gclass<T> implements IMessage<T>{

    @Override
    public void print(T t) {
        System.out.println(t);
    }
}

public class Test8 {
    public static void main(String[] args) {
        IMessage<String> message = new Gclass<>();
        message.print("hello world");
    }
}

```

范例：在子类实现接口的时候明确给出具体类型

```java
/**
 * 泛型接口的定义与使用
 */
interface IMessage<T>{
    public void print(T t);
}
class Gclass<T> implements IMessage<String>{//给出了明确的数据类型

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

public class Test8 {
    public static void main(String[] args) {
        IMessage<String> message = new Gclass<>();
        message.print("hello world");
    }
}

```

#### 3.类型擦除

泛型信息只存在于代码编译阶段，在进入JVM之前，与泛型相关的信息会被擦除掉，专业术语叫做类型擦除。

泛型类和普通类在java虚拟机内相比是没有什么特别的地方的。

```java
class MyClass2<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public void print(T t){
        System.out.println(t);
    }
}

public class Test9 {
    public static void main(String[] args) {
        MyClass2<String>  myClass1  = new MyClass2<>();
        MyClass2<Integer> myClass2 = new MyClass2<>();
        System.out.println(myClass1.getClass()==myClass2.getClass());
    //打印结果为true
}
```

打印结果为true是因为MyClass2<String>和Myclass<Integer>在JVM中的Class都是MyClass2.class.

观察类型擦除

```java
import java.lang.reflect.Field;

class MyClass3<T extends String,E>{
    private T message;
    private E text;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public E getText() {
        return text;
    }

    public void setText(E text) {
        this.text = text;
    }
    public void print(T t,E e){
        System.out.println(t);
        System.out.println(e);
    }
}

public class Test10 {
    public static void main(String[] args) {
        MyClass3<String,Integer> myClass3 = new MyClass3<>();
        Class cls = myClass3.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getType());
        }
    }
}
//打印结果：class java.lang.String
//  			class java.lang.Object
```

在泛型类被类型擦除的时候，之前泛型类中的类型参数部分如果没有制定上限，如<T>则会被转译成普通的Object类型，如果指定了上限如<T extends String>则类型参数就会被替换成类型上限











