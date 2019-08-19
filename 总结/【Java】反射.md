### 类加载器

**1、类的加载过程：**
　　当程序要使用某个类时，如果该类还未被加载到内存中，则系统会通过`加载、连接、初始化`三步骤来实现对这个类进行初始化。
　　**加载**：就是指将class文件读入内存，并为之创建一个Class对象。任何类使用时系统都会建立一个Class对象
　　**连接**：验证，是否有正确的内部结构，并和其他类协调一致。
　　**准备**:  负责为类的静态成员分配内存，并设置默认初始化值
　　**解析**:  将类的二进制数据中的符号引用替换为直接引用
　　**初始化**：开辟栈、堆内存空间，创建对象、默认初始化、显示初始化、构造初始化

**2、 类的加载时机**:
　　1）创建类的实例
　　2）访问类的静态变量、或者为类的静态变量赋值
　　3）调用类的静态方法
　　4）使用反射方法来强制创建某个类或者接口对象的java.lang.Class对象
　　5）初始化某个类的子类：初始化子类时，首先加载其父类
　　6）直接使用java.exe命令来运行某个主类

**3 、类加载器的主要作用：**
   负责将.class文件加载到内存，并为之生成对应的Class对象

**4 、类加载器的组成**
　　1）**根类加载器**：Bootstrap ClassLoader（我们使用的String等类）
　　　　也称为引导类加载器，负责java核心类的加载。比如，System Object String等，在JDK中的JRE的lib目录下rt.jar文件中
　　2）**扩展类加载器**：Extension ClassLoader
　　　　负责JRE的扩展目录中jre包的加载。在JDK中JRE的lib目录下ext目录
　　3）**系统类加载器**:System ClassLoader（加载我们自己写的）
　　　　负责在JVM启动时加载来自java命令的class文件以及classpath环境变量所指的jar包和类路径

### 反射

#### 1.反射机制

​	Java反射机制是对于任何一个类，我们能够知道这个类的属性和方法，对于任何一个对象，我们能调用它的任意一个方法和属性，这种动态获取信息以及动态调用对象的方法称为Java的反射机制

即：通过class文件对象，去使用这个文件中的成员变量，成员方法，构造方法

要想解剖一个类，就要先获取`.class`文件中`Class`类型的`class`对象

#### 2.获取class对象的方式

Class类是描述整个类的概念，也是整个反射的操作源头，在使用Class类的时候需要关注的依然是这个类的对象。而这个类的对象的产生模式一共有三种：

> 1.任何累的实例化对象可以通过Object类的getClass()方法取得Class类对象
>
> 2."类.class"直接根据某个具体的类型来取得Class类的实例化对象
>
> 3.使用Class类提供的方法:`public static Class<?> forNmae(String className) throws ClassNotFoundException`

```java
/**
 * 获取class对象
 */
public class Test {
    public static void main(String[] args) {
        Date date  = new Date();
      //1
        System.out.println(date.getClass());
      //2
        System.out.println(Date.class);
      //3
        try {
            System.out.println(Class.forName("java.util.Date"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//class java.util.Date
//class java.util.Date
//class java.util.Date
```

在以上给出的三种方法中，我们发现除了第一种方法会产生Date类的实例化对象之外，其他的两种都不会产生Date类的实例化对象，于是取得了Class类对象有一个最直接的好处：**可以通过反射实例化对象，在Class类中定义有如下方法**

```java
public T newInstance() throws InstantiationException,IllegalAccessException
```

```java
/**
 * 反射实例化对象
 * 取得了Class对象就意味着取得了一个指定类的操作权
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("java.util.Date");
            Object obj = cls.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

```

#### Class类

成员变量：`Field`

成员方法：`Method`

构造方法：`Constructor`

通过`Class`类的方法获取以上的三个对应的对象，然后通过`Filed/Method/Contructor`对象调用其方法去真正的使用类的成员、方法、构造

###反射的使用

##### 取得父类信息

```java
/**
 * 取得父类信息
 */
interface IMessage{

}
interface IMessage2{}

class A implements IMessage,IMessage2{

}

public class Test1 {
    public static void main(String[] args) {
        Class<?> cls = A.class;
        //包名
        System.out.println(cls.getPackage().getName());
        //父类名称
        System.out.println(cls.getSuperclass().getName());
        //父接口
        Class<?> [] classes = cls.getInterfaces();
        for(Class<?> a:classes){
            System.out.println(a);
        }
    }
}
/*
Review.Test.reflect
java.lang.Object
interface Review.Test.reflect.IMessage
interface Review.Test.reflect.IMessage2
*/
```

##### 反射调用构造

一个类中可以存在多个构造方法，如果要取得类中构造的调用，就可以使用Class类中提供的两个方法：

> - 取得指定参数类型的构造

```java
public constructor<T> getConstructor(Class<?> ... parameterTypes) throws NoSuchMethodException,SecurityException
```



> - 取得类中的所有构造

```java
public Constructor<?> [] getConstructors() throws SecurityException
```

以上两个方法返回的类型都是`java.lang.reflect.Constructor类的实例化对象，这个类之中大家只需要关注一个方法.

实例化对象：

```java
public T newInstance(Object ... initargs) throws InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException
```

- 取得类中所有构造信息

```java

import com.monkeyc.generic.Enum.Enum;

import java.lang.reflect.Constructor;

class Person{
    public Person(){

    }
    public Person(String name,int age){}

    public Person(String name, int age, Enum sex){

    }
}

public class Test3 {
    public static void main(String[] args) {
       Class<?> cls = Person.class;
        Constructor<?>[]  constructors = cls.getConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }

    }
}
/*
public Review.Test.reflect.Person()
public Review.Test.reflect.Person(java.lang.String,int)
public Review.Test.reflect.Person(java.lang.String,int,com.monkeyc.generic.Enum.Enum)
*/
```

范例：在定义简单Java类的时候一定要保留一个无参构造

```java

class Person1{
    String name;
    int age;
    public Person1(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Person1(){}
}

public class Test4 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> cls = Person1.class;
        System.out.println(cls.newInstance());//弱类型，只能调用无参构造
    }
}
//java.lang.InstantiationException
```

**Class**类通过反射实例化类对象的时候，只能够调⽤类中的无参构造。如果现在类中没有无参构造则无
法使用**Class**类调用，只能够通过明确的构造调用实例化处理。

范例：通过Constructor类实例化对象

```java
/**
 * 根据Constructor类实例化对象
 */
class Person2{
    String name;
    int age;
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

public class Test5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls  = Person2.class;
        Constructor<?> con = cls.getConstructor(String.class,int.class);
        System.out.println(con.newInstance("monkeyc",22));

    }
}
//Person2{name='monkeyc', age=22}
```



