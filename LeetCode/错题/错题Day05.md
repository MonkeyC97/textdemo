##### 1.下面的程序编译运行之后，在屏幕上显示的结果是( )

```java
public class Test{
  public static void main(String args[]){
    int x,y;
    x = 5>>2;//右移动
    y = x>>>2;//无符号右移动
    System.out.println(y);
  }
}//打印结果：0
```

##### 2.以下代码的结果是什么？

```java
public class Foo {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        opreate(a,b);
        System.out.println(a+" "+b);
    }
    static void opreate(StringBuffer X,StringBuffer Y){
        X.append(Y);
        X = Y;//此时不代表b就指向了AB，此时b还是指向B没有变
    }
}//往方法中传参，传的仅仅只是地址，而不是实际内存，所以不要以为y=x程序的执行，是 b=a的执行。
```

所以，上述代码可以运行，输出的是"AB，B"



##### 3.下面哪个说法是正确的（ ）

A：ConcurrentHashMap使用synchronized关键字保证线程安全

B：HashMap实现了Collction接口

C：Array.asList方法返回java.util.ArrayList对象

D：SimpleDateFormat是线程不安全的



答：A选项中，ConcurrentHashMap   使用segment来分段和管理锁，segment继承自ReentrantLock，因此ConcurrentHashMap使用ReentrantLock来保证线程安全。 

  	B中，HashMap定义规则如下： 

```java
public class HashMap<K,V>
    extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable
```

  	C中，应该是Arrays.asList()，其将一个数组转化为一个List对象，这个方法会返回一个ArrayList类型的对象，   这个ArrayList类并非java.util.ArrayList类，而是Arrays类的内部类



##### 4.以下说法错误的是（D）

A：虚拟机中没有泛型，只有普通类和方法

B：所有泛型类的类型参数在编译时都会被擦除

C：创建泛型对象时请指明类型，让编译器尽早的作参数检查

D：泛型的类型擦除机制以为着不能在运行时动态获取List<T>中T的实际类型

##### 5.以下程序运行的结果是

```java
public class Example{
  String str = new String("good");
  char[] ch = {'a','b','c'};
  public static void main(String args[]){
    Example ex = new Example();
    ex.change(ex.str,ex.ch);
    System.out.print(ex.str+"and");
    System.out.print(ex.ch);
  }
  public void change(String str,char ch[]){
    str = "test ok";
    ch[0] = 'g';
  }
}
```

运行结果为good and gbc

​	change函数被调用时，第一个形参str接收了类的成员变量str的值（虽然名称都是str，但是却是两个独立的String类型的引用变量），注意这两个str自身都是变量且都指向了堆内存中的String对象"good"，当我们在change函数内部将str指向了另一个String对象"test ok"后，类的成员变量str仍然保持指向"good"，所以最终打印出来就是"good"；对于第二个形参ch，它也是接收了类的成员变量ch的值拷贝，这一点和str没有差别，即两个ch都指向了字符数组{ 'a', 'b', 'c' }的首地址，但是ch[0]表示的是字符数组中'a'的地址，修改了它也就修改了字符数组的第一个元素，这个改变在change函数返回之后也会存在。所以本题中两个形参传参的本质区别在于，修改str只是将形参指向了新的对象，对外部的实参没有任何影响，而修改ch[0]是实实在在的修改了字符数组的首元素。



