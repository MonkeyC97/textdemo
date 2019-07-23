##### 1.下列关于java并发的说法中正确的是：

​	A:copyonwritearraylist适用于写多读少的并发场景

​	B:readwritelock适用于读多写少的并发场景

​	C:concurrentthashmap的写操作不需要加锁，读操作需要加锁

​	D:只要在定义int类型的成员变量i的时候加上volatile关键字，那么多线程并发执行i++这样的操作的时候就是线程安全的了

```java
解析：
A.CopyOnWriteArrayList适用于写少读多的并发场景
B.ReadWriteLock即为读写锁，他要求写与写之间互斥，读与写之间互斥，
   读与读之间可以并发执行。在读多写少的情况下可以提高效率
C.ConcurrentHashMap是同步的HashMap，读写都加锁
D.volatile只保证多线程操作的可见性，不保证原子性
```

##### 2.Java中的集合类包括ArrayList、LinkedList、HashMap等，下列关于集合类描述错误的是？

A：ArrayList和LinkedList均实现了List接口

B：ArrayList的访问速度比LinkedList快

C：随机添加和删除元素时，ArrayList的表现更佳

D：HashMap实现Map接口，它允许任何类型的键和值对象

```java
解析：C：随机添加和删除元素的时候，使用LinkedList表现更佳；在查找元素时候，使用ArrayList更好
```



##### 3.在Java中，HashMap中是用哪种方法来解决哈希冲突的？

A：开放地址法

B：二次哈希法

C：链地址法

D：建立一个公共溢出区

```java
解析：C
解决哈希冲突常用的两种方法是：开放定址法和链地址法 
  开放定址法：当冲突发生时，使用某种探查(亦称探测)技术在散列表中形成一个探查(测)序列。沿此序列逐个单元地查找，直到找到给定 的关键字，或者碰到一个开放的地址(即该地址单元为空)为止（若要插入，在探查到开放的地址，则可将待插入的新结点存人该地址单元）。查找时探查到开放的 地址则表明表中无待查的关键字，即查找失败。  
  链地址法：将所有关键字为同义词的结点链接在同一个单链表中。若选定的散列表长度为m，则可将散列表定义为一个由m个头指针组成的指针数 组T[0..m-1]。凡是散列地址为i的结点，均插入到以T[i]为头指针的单链表中。T中各分量的初值均应为空指针。
```

##### 4.阅读下列程序，选择哪一个是正确的输出结果？

```java
class HelloA{
  public HelloA(){
    System.out.println("I am A class");
  }
  static{
    System.out.println("static A");
  }
}
public class HelloB extends HelloA{
  public HelloB(){
    System.out.println("I am B class");
  }
  static{
    System.out.println("static B");
  }
  public static void main(String[] args){
    new HelloB();
  }
}
```

打印结果：static A static B I am A class I am B class

被static修饰的静态代码块先打印，在调用子类的构造方法时，默认先调用父类的构造方法。

##### 5.关于sleep和wait，以下描述错误的是

A：sleep是线程类的方法，wait是object的方法

B：sleep不释放对象锁

C：sleep暂停线程，但监控状态依然保持，结束后会自动恢复

D：wait进入等待锁定池，只有针对此对象发出notify方法获得对象锁进入运行状态

