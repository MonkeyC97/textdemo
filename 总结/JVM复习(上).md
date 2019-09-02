### 一.Java内存区域

#### 1.运行时数据区域

![屏幕快照 2019-09-01 20.03.16](/Users/houchang/Desktop/屏幕快照 2019-09-01 20.03.16.png)

（1）线程私有区域：程序计数器、Java虚拟机栈、本地方法栈。

（2）线程共享区域：Java堆、方法区、运行时常量池。

##### 1.程序计数器（PC Register）线程私有

程序计数器只占用很小的一块空间，可以看成是当前线程执行字节码的行号指示器。

如果当前线程执行的是一个Java方法，那么程序计数器就记录了正在执行的<font color=red>虚拟机字节码指令的地址</font>，如果是一个Native方法那么这个计数器的值为空。

#####2.Java虚拟机栈（线程私有）

虚拟机栈描述的是Java方法执行的内存模型：每个方法执行的时候同时都会创建一个栈桢用来存储<font color=red>局部变量表、操作数栈、动态链接、方法出口等信息</font>，每一个方法从调用直到执行完成的过程，就对应一个栈桢在虚拟机中入栈和出栈的过程。声明周期与线程相同。

我们之前讲的栈区域其实就是虚拟机栈中的局部变量表。

- **局部变量表**：存放了编译器可知的各种基本数据类型(8大基本数据类型)、对象引用。局部变量表所需的内存空间在编译期间完成分配，当进入一个方法时，这个方法需要在帧中分配大多的局部变量空间完全是确定的，在执行期间不会改变局部变量的大小。

  - 此区域一共会产生两种异常

  （1）如果线程请求的栈深度大于虚拟机所允许的深度(-Xss设置栈容量)，将会抛出StackOverFlowError异常。

  （2）虚拟机在动态扩展时无法申请到足够的内存，会抛出OOM(OutOfMemoryError)异常

##### 3.本地方法栈(线程私有)

本地方法栈与虚拟机栈的作用完全一样，它们的区别就是一个是为Java方法服务，一个是为Native方法服务。

在HotSpot虚拟机中，本地方法栈与虚拟机栈是同一块内存区域。



***线程私有：***

由于JVM的多线程是通过线程轮流切换并分配处理器执行时间的方式来实现，因此在任何一个确定的时刻，一个处理器(多核处理器则是指一个内核)都只会执行一条线程中的指令，因此为了切换线程后能恢复到正确的执行位置，每条线程都需要独立的程序计数器，各条线程之间计数器互不影响，独立存储。

JVM的多线程是通过CPU时间片轮转（即线程轮流切换并分配处理器执行时间）算法来实现的。也就是说，某个线程在执行过程中可能会因为时间片耗尽而被挂起，而另一个线程获取到时间片开始执行。当被挂起的线程重新获取到时间片的时候，它要想从被挂起的地方继续执行，就必须知道它上次执行到哪个位置，在JVM中，通过程序计数器来记录某个线程的字节码执行位置。因此，程序计数器是具备线程隔离的特性，也就是说，每个线程工作时都有属于自己的独立计数器。

##### 4.Java堆（线程共享）

Java堆事JVM所管理的最大内存区域，Java堆事所有线程共享的一块区域，在JVM启动时候创建，此内存区域存放的都是对象实例，JVM规范中说到，**所有的对象实例以及数组都在堆上分配**

Java堆是垃圾回收器管理的主要区域，很多时候被称之为GC堆，根据JVM规范，Java堆可以处于物理上不连续的内存空间中，Java堆在主流的虚拟机中都是可以扩展的(`-Xmx`设置最大值，`-Xms`设置最小值)。

如果在堆中没有足够的内存完成实例分配并且堆也无法在进行扩展时，就会抛出`OOM`异常。

##### 5.方法区（线程共享）

方法区与Java堆一样，是各个线程共享的内存区域，它用于存储已被虚拟机加载的<font color=red>类信息、常量、静态变量、即时编译器编译后的代码等数据。</font>在JDK8之前的HotSpot虚拟机中,方法区也被称为"永久代"(JDK8已经被元空间取代)。

永久代并不意味着数据进入方法区就永久存在，此区域的内存回收主要是针对常量池的回收以及堆类型的卸载。

当方法区无法满足内存分配需求时，将抛出OOM异常。

##### 6.运行时常量池(方法区的一部分)

常量池是方法区的一部分，存放字面量和符号引用。

**字面量**：字符串（JDK1.7之后移到堆中），final常量，基本数据类型的值

**符号引用：**类和结构的完全限定名，字段的名称和修饰符，方法的名称和修饰符



**Java堆溢出**

```java
//观察Java Heap OOM
/**
*JVM参数为：-Xmx20m	-Xms20m -xx：+HeapDumpOnOutOfMemoryError
*-xx:+HeapDumpOutOfMemoryError
*/

public class Test{
	static class OOMObject{
    
  }
  public static void main(String[] args){
    List<OOMObject> list = new ArrayList<>();
    while(true){
      list.add(new OOMObject());
    }
  }
}
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
```

加入`-xx:+HeapDumpOutOfMemoryError`,会生成Dump文件，分析问题的产生到底是出现了内存泄漏(Memory Leak)还是内存溢出(Memory OverFlow)

内存泄漏：泄露对象无法被GC

内存溢出：内存对象却是还存活，此时要根据JVM堆参数与物理内存相比较检查是否还应该把JVM堆内存调大，或者检查对象的生命周期是否过长。



**虚拟机栈和本地方法栈溢出**

```java
/**
 * 测试单线程下StackOverFlow
 */
public class TestStackOverFlow {
    private int stackLength = 1;
    public void stackLeak(){
        this.stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        TestStackOverFlow test = new TestStackOverFlow();
        test.stackLeak();
    }
}
//Exception in thread "main" java.lang.StackOverflowError
```

如果是多线程导致的内存溢出问题，在不能减少线程数的情况下，只能减少最大堆和减少栈容量的方式来换取多线程。

```java
/**
 * 测试多线程下的StackOverFlow
 */
public class TestStackOverFlow2 {

    private void dontStop(){
        while(true){

        }
    }
    public void stackOverFlowByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        TestStackOverFlow2 test = new TestStackOverFlow2();
        test.stackOverFlowByThread();
    }
}
```

以上代码不要没事瞎跑。











