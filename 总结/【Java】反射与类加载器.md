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

public class TestDemo {
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
      //取得指定参数类型的构造方法对象
        Constructor<?> con = cls.getConstructor(String.class,int.class);
        System.out.println(con.newInstance("monkeyc",22));
    }
}
//Person2{name='monkeyc', age=22}
```

#### 反射调用普通方法

在Class类中有如下两种取得类中普通方法的函数：

- 取得全部普通方法

```java
public Method[] getMethods() throws SecurityException
```

- 取得指定普通方法

```java
public Method getMethod(String name,Class<?> ... parameterTypes)
```

以上两个方法返回的是`java.lang.reflect.Method`类的对象，在此类中提供一个调用方法的支持

- 调用

```java
public Object invoke(Object obj,Object ...agrs) throws IllegalAccessException,IllegalArgumentException,InvocationTargetExption
```

范例：取得一个类中的全部普通方法

```java
import java.lang.reflect.Method;

class Person3{
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void sayHello(){
        System.out.println("hello");
    }
    public Person3(){}

    public void eat(){
        System.out.println("eating");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Class<?> cls = Person3.class;
        Method[] methods = cls.getMethods();
        for(Method met :methods){
            System.out.println(met);
        }
    }
}
/*
public java.lang.String Review.Test.reflect.Person3.toString()
public java.lang.String Review.Test.reflect.Person3.getName()
public void Review.Test.reflect.Person3.setName(java.lang.String)
public int Review.Test.reflect.Person3.getAge()
public void Review.Test.reflect.Person3.setAge(int)
public void Review.Test.reflect.Person3.sayHello()
public void Review.Test.reflect.Person3.eat()
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
*/
```

范例：通过反射调用setter、getter方法

```java
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person4{
    private String name;
    private int age;
    public Person4(){}

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

    @Override
    public String toString() {
        return "Person4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Class<?> cls = Person4.class;
        try {
            //任何时候都需要实例化对象来调用类中的普通方法
            Object obj = cls.newInstance();
          //取得setName这个方法的实例化对象，设置方法名称与类型参数
            Method setMethod = cls.getMethod("setName", String.class);
          //随后需要通过Method类对象调用指定的方法，调用方法需要有实例化对象
          //同时传入参数
            setMethod.invoke(obj,"monkeyc");//相当于Person对象.setName("monkeyc")
            Method getMethod = cls.getMethod("getName");
            Object result = getMethod.invoke(obj);
            System.out.println(result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
//monkeyc
```

#### 反射调用类中的属性

前提：类中的所有属性一定在类对象实例化之后才会进行空间分配，所以此时如果要想调用类的属性，必须保证有实例化对象。通过反射的newInstance()可以直接获取实例化对象(Object类型)

在Class类中提供有两种取得属性的方法：

> 1. 第一组(父类中) - 取得类中全部属性：`public  Field[] getFields() throws SecurityException`
> 2. 第二组(父类中) - 取得类中指定名称属性：`public Field getField(String name) throws NoSuchFieldExption,SecurityException`
> 3. 第二组(本类中) - 取得类中全部属性：`public Field[] getDeclareFields() throws SecurityException`
> 4. 第二组(本类中) - 取得类中指定名称属性:`public Method getDeclaredMethod(String name,Class<?>...parameterTypes) throws NoSuchMethodException,SecurityException`

范例：取得类中全部属性

```java
/**
 * 取得类中所有的属性
 */

class Person5{
    public   int age;
    public String name;
}
class Student extends  Person5{
    private String school;
}
public class Test8 {
    public static void main(String[] args) {
        Class<?> cls = Student.class;
        {
            Field[] fields = cls.getFields();
            for(Field fid : fields){
                System.out.println(fid);
            }
        }
        System.out.println("--------------------");
        {
            //本类中全部的属性
            Field[] fields = cls.getDeclaredFields();
            for(Field fid1 : fields){
                System.out.println(fid1);
            }
        }
    }
}
/*
public int Review.Test.reflect.Person5.age
public java.lang.String Review.Test.reflect.Person5.name
--------------------
private java.lang.String Review.Test.reflect.Student.school
*/
```

##### 动态设置封装

```java
public void setAccessible(boolean flag) throws SecurityException
```

范例：动态设置封装

```java
/**
 * 动态设置封装
 */
class Person6{
    private String name;

}

public class Test9 {
    public static void main(String[] args) {
        try {
            Class<?> cls = Person6.class;
            Object obj = cls.newInstance();
            Field nameField = cls.getDeclaredField("name");
            //取消封装
            nameField.setAccessible(true);
            nameField.set(obj,"monkeyc");
            System.out.println(nameField.get(obj));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
//monkeyc
```

范例：取得属性类型

```java
/**
 * getType()
 */
class Person{
    private int age;
    private String name;
}

public class TestDemo {
    public static void main(String[] args) {
        Class<?> cls = Person7.class;
        try {
            Object obj = cls.newInstance();
            Field field = cls.getDeclaredField("name");
            System.out.println(field.getType().getName());
          System.out.println(field.getType().getSimpleName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
//java.lang.String
//String
```

##### 反射与简单Java类

如果现在有一个简单的Java类，按照原始的做法使用getter与setter对属性进行操作

范例：基本程序

```java
class Emp{
  private String name;
  private int age;
  public String getEname(){
    return ename;
  }
  public void set Ename(String name){
    this.name = name;
  }
  public String getJob(){
    return job;
  }
  public void setJob(String job){
    this.job = job;
  }
}
```

现在Emp类中存在无参构造于是按照传统调用则编写如下：

```java
class Emp{
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setEname("monkeyc");
        emp.setJob("doctor");
        System.out.println(emp);
    }
}
```

假设一个类中存在很多个属性，要调用几十次settet方法，现在希望能对程序进行简化，输入字符串"**属性名称：属性值|属性名称：属性值|属性名称：属性值|…**"，就可以将类中的属性设置好，希望通过此程序实现任意的简单Java类的属性设置

```java
class Emp{
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
```

范例：EmpAction

```java
public class EmpAction {
    private Emp emp = new Emp();
    public void setValue(String value) throws Exception{
        BeanOperation.setBeanValue(this,value);
    }
    public Emp getEmp(){
        return emp;
    }
}
```

范例：BeanOreration类设计(公共程序类)

```java

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 本类主要负责实现自动的vo匹配处理操作
 */
public class BeanOperation {
    private BeanOperation(){}

    /**
     * 负责设置类中的属性操作
     * @param actionObject 表示当前发出设置请求的程序类的当前对象
     * @param message 属性的具体内容，格式为："属性名称：|内容|属性名称：|内容|...."
     * @throws Exception
     */
    public static void setBeanValue(Object actionObject,String message) throws Exception{
        //要想进行内容的设置，必须将字符串拆分
        //按照竖线拆分，取出所有要设置的内容
        String[] result = message.split("\\|");
        //每次执行后只剩下"属性名称:内容"
        for(int i = 0;i < result.length;i++){
            //需要针对属性名称及内容做进一步拆分
            String[] temp = result[i].split(":");
            //属性名称："emp.ename"
            String attribute = temp[0];
            //属性内容
            String value = temp[1];
            String[] fields = attribute.split("\\.");
            //获取当前操作的简单Java类对象
            Object currentObject = getObject(actionObject,fields[0]);
            //调用简单Java类中的setter方法
            setObjectValue(currentObject,fields[1],temp[1]);
        }
    }
    /**
     * 将给定字符串的首字母大写
     * @param str 给定的字符串
     * @return  返回首字母大写的字符串
     */
    public static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    /**
     * 负责调用XXXAction类中的getter方法取得简单Java类对象
     * @param obj 表示调用方法的所在类对象
     * @param attribute 表示属性名称
     * @return 调用对象结果
     */
    public static Object getObject(Object obj,String attribute) throws Exception{
        String methodName = "get" +initCap(attribute);
        //调用指定属性的Field对象，目的是取得对象类型，如果没有此属性意味着操作无法继续进行
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field == null){
            //第二次尝试从父类中取得该属性
            field = obj.getClass().getField(attribute);
        }
        if(field == null){
            //两次都未取得指定属性的对象，表示该对象一定不存在
            return null;
        }
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }
    /**
     * 根据指定的类对象设置指定类中的属性，调用setter方法
     * @param obj 属性所在类的实例化对象
     * @param attribute 属性名称
     * @param value 属性内容
     */
    public static void setObjectValue(Object obj,String attribute,String value) throws Exception{
        Field field = obj.getClass().getDeclaredField(attribute);
        //判断属性是否存在
        if(field == null){
            //第二次尝试在父类中取得该属性
            field = obj.getClass().getField(attribute);
        }
        if(field == null){
            //两次都未取得指定属性的对象，表示该对象一定不存在
            return;
        }
        String methodName = "set"+initCap(attribute);
        Method setMethod = obj.getClass().getMethod(methodName,field.getType());
        setMethod.invoke(obj,value);
    }
}

```

### ClassLoader类加载器

Class类描述的是整个类的信息，在Class类中提供的forName()方法，这个方法根据ClassPath配置的路径进行的类的加载，如果说现在你的类的加载路径可能是网络、文件、这个时候就必须实现类加载器，也就是ClassLoader类的主要作用.

- 认识ClassLoader

首先通过Class类观察如下方法

```java
/**
 * 初识ClassLoader
 */
class Member{

}
public class Test{
    public static void main(String[] args) {
        Class<?> cls = Member.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
    }
}
/*
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$ExtClassLoader@63947c6b
null
*/
```

此时出现了两个类加载器：AppClassLoader和ExtClassLoader。

JVM设计团队把类加载阶段中的"通过一个类的全限定名来获取描述此类的二进制字节流"这个动作放在Java虚拟机外部去实现，以便让应用程序自己决定如何去获取所需要的类。实现这个动作的代码模块称之为"类加载器"。

Bootstrap(启动类加载器):这个类加载器使用C++实现，是虚拟机⾃身的一部分;其他的类加载器都由 Java语言实现，独⽴于JVM外部并且都继承于java.lang.ClassLoader.BootStrap类加载器负责将存放于 <Java_HOME>\lib⽬目录中(或者被-Xbootclasspath参数指定路径中)能被虚拟机识别的(仅按照文件名识 别，如rt.jar，名字不符合的类库即使放在lib目录中也不会被加载)类库加载到JVM内存中。启动类加载器无法被Java程序直接引用。 

ExtClassLoader(扩展类加载器):它负责加载<Java_HOME>\lib\ext目录中，或者被java.ext.dirs系统变量指定的路径中的类库。开发者可以直接使⽤扩展类加载器。 

AppClassLoader(应用程序类加载器):负责加载⽤户类路径(ClassPath)上指定的类库，如果应用程序中 没有⾃定义⾃己的类加载器，则此加载器就是程序中默认的类加载器。 

### 双亲委派模型

![屏幕快照 2019-08-20 下午4.41.14](/Users/houchang/Desktop/blog/屏幕快照 2019-08-20 下午4.41.14.png)

我们的应用程序都是由上面这三种加载器相互配合来进行加载的，如果有必要，还可以加入自定义加载器

双亲委派模型除了顶层的BootStrapClassLoader加载器之外，剩下的加载器都需要有它自己的父类加载器，

双亲委派模型工作流程：当一个类加载器收到加载请求的时候，它自己不会加载这个请求，而是委托自己的父类加载器去处理这个请求，所以说**所有的加载都应该首先被指放到BootStrap层，只有当父类加载器无法加载时(在自己的搜索范围内没有找到这个类)，才会下放到下一层进行加载**。

**双亲委派模型对于保证Java程序的稳定运行很重要，java类随着类加载器一起具备了一种带有优先级的层次关系**

例如：`java.lang.Object`它存放在rt.jar中，无论哪一个类加载器要加载这个类，都要放置到顶层BootStrap类加载器中进行加载，因此**Object类在程序中任意类加载器中都是同一个类**

首先在终端之中输入命令:

`cd Desktop`,`vim Member.java`

```java
class Member{
  @Override
  public String toString(){
        return "Memver";
   }
}
```

范例：自定义类加载器

```java
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

//自定义类加载器
class MyClassLoader extends ClassLoader{
    /**
     * 实现一个自定义的类加载器、传入类名称、通过指定路径加载
     * @param className 类名称
     * @return 返回的Class对象
     * @throws Exception
     */
    public Class<?> loadData(String className) throws Exception{
        byte[] classData = this.loadClassData();
        return super.defineClass(className,classData,0,classData.length);
    }
    /**
     * 通过指定的文件路径进行类的文件加载，实际上就是进行二进制文件读取
     * @return 类文件数据
     * @throws Exception
     */
    private byte[] loadClassData() throws Exception{
        InputStream input = new FileInputStream("/Users/houchang/Desktop/Member.class");
        //取得所有字节内容，放到内存中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //读取缓冲区
        byte[] data = new byte[20];
        int temp = 0;
        while((temp = input.read(data))!= -1){
            bos.write(data,0,temp);
        }
        byte[] result = bos.toByteArray();
        input.close();
        bos.close();
        return result;
    }
}

public class TestDemo{
    public static void main(String[] args) throws Exception {
        Class<?> cls = new MyClassLoader().loadData("Member");
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        System.out.println(cls.newInstance());
    }
}
/*
Review.Test.reflect.MyClassLoader@2b193f2d
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$ExtClassLoader@4dc63996
*/
```

类加载器给⽤户提供最大的帮助为:可以通过动态的路径进行类的加载操作。

比较两个类相等的前提:必须是由同⼀个类加载器加载的前提下才有意义。否则，即使两个类来源于同一个**Class**⽂文件，被同⼀个虚拟机加载，只要加载他们的类加载器不同，那么这两个类注定不相等。



