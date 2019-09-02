### 3.垃圾回收器与内存分配策略

#### 3.1如何判断对象已死？

##### 3.1.1引用计数法

给对象增加一个引用计数器，当有地方引用这个对象时，计数器的值+1，当引用失效时，计数器的值就-1；任何时刻计数器的值为0的对象就是不能再使用的，就是对象已死。

主流的JVM中没有选用引用计数法来管理内存，最主要的原因还是引用计数法无法解决对象的循环引用问题。

```java
//观察对象的循环引用问题
/**
*JVM参数：-xx：PrintGC
*/
public class Test{
    public Object instance = null;
    private static int _1MB = 1024 * 1024;
  //让对象占用一定的空间，触发回收
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC(){
        Test test1 = new Test();
        Test test2 = new Test();
      //test1的instance对象引用test2
        test1.instance = test2;
      //test2的instance对象引用test1
        test2.instance = test1;
        test1 = null;
        test2 = null;
        System.gc();//强制垃圾回收
    }
    public static void main(String[] args) {
        testGC();
    }
}
//[GC (System.gc()) [PSYoungGen: 6767K->496K(38400K)] 6767K->504K(125952K), 0.0041076 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
```

6767k->496说明此时对象已经被回收了，所以JVM不采用引用计数法来判断对象是否存活。

##### 3.1.2可达性分析法

思想：通过一系列被称为"GC Roots"的对象作为起始点，从这些节点开始向下搜索，搜索走过的路径称为引用链，当一个对象到GC Roots没有任何的引用链相连时(从GC Roots到这个对象不可达)时，证明此对象是不可用的。

![屏幕快照 2019-09-02 15.14.31](/Users/houchang/Desktop/屏幕快照 2019-09-02 15.14.31.png)

如图所示，Object5，6，7都是要被回收的对象。

在Java语言中，可作为GC Roots的对象包含一下几种：

1.虚拟机栈(栈桢中的本地变量表)中引用的对象

2.方法区中类静态属性引用的对象

3.方法区中常量引用的对象

4.本地方法栈中JNI(Native方法)引用的对象

在JDK1.2之前，Java中引用的定义很传统：如果引用的数据类型中存储的数值代表的是另一块内存的起始地址，就称这块内存代表着一个引用。但是这样定义，一个对象只有被引用或者没有被引用的两种状态。

我们希望能描述这一类对象：当内存空间开足够的时候，则能保存在内存中；如果内存空间在进行垃圾回收之后还是非常紧张，则可以抛弃这些对象，很多系统中的缓存对象都符合这样的场景。

在JDK1.2之后，Java对引用的概念做了扩充，将引用分为强引用，软引用，若引用，虚引用，这四种强度依次递减。

> 1. 强引用 : 强引用指的是在程序代码之中普遍存在的，类似于"Object obj = new Object()"这类的引用，只 要强引用还存在，垃圾回收器永远不会回收掉被引用的对象实例。 
> 2. 软引用 : 软引用是用来描述一些还有用但是不是必须的对象。对于软引用关联着的对象，在系统将要发生 内存溢出之前，会把这些对象列入回收范围之中进行第二次回收。如果这次回收还是没有足够的内存，才 会抛出内存溢出异常。在JDK1.2之后，提供了SoftReference类来实现软引用。 
> 3. 弱引用 : 弱引用也是用来描述非必需对象的。但是它的强度要弱于软引用。被弱引用关联的对象只能生存 到下一次垃圾回收发生之前。当垃圾回收器开始进行工作时，无论当前内容是否够用，都会回收掉只被弱 引用关联的对象。在JDK1.2之后提供了WeakReference类来实现弱引用。 
> 4. 虚引用 : 虚引用也被称为幽灵引用或者幻影引用，它是最弱的一种引用关系。一个对象是否有虚引用的存 在，完全不会对其生存时间构成影响，也无法通过虚引用来取得一个对象实例。为一个对象设置虚引用的 唯一目的就是能在这个对象被收集器回收时收到一个系统通知。在JDK1.2之后，提供了 PhantomReference类来实现虚引用 

```java
/*
*软引用何时被收集
*JVM参数：-Xmx200m -XX:PrintGC
*
*/
public class SoftReference {
    public static void main(String[] args) throws InterruptedException {
        //100M缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];
        //将缓存数据用软引用持有
        java.lang.ref.SoftReference<byte[]> softReference = new java.lang.ref.SoftReference<>(cacheData);
        //将缓存数据的强引用去除
        cacheData = null;
        System.out.println("第一次GC前"+cacheData);
        System.out.println("第一次GC前"+softReference.get());
        //进行强制垃圾回收
        System.gc();
        Thread.sleep(500);
        System.out.println("第一次GC之后"+cacheData);
        System.out.println("第一次GC之后"+softReference.get());
        //再分配一个120M的对象，看看回收之后对象的情况
        byte[] newCacheData = new byte[120 * 1024 * 1024];
        System.out.println("分配之后"+cacheData);
        System.out.println("分配之后"+softReference.get());

    }
}
```

打印信息：

`第一次GC前null
第一次GC前[B@63947c6b
[GC (System.gc())  105071K->102920K(175104K), 0.0021991 secs]
[Full GC (System.gc())  102920K->102821K(175104K), 0.0086113 secs]
第一次GC之后null
第一次GC之后[B@63947c6b
[GC (Allocation Failure)  103486K->102853K(175104K), 0.0017569 secs]
[GC (Allocation Failure)  102853K->102853K(175104K), 0.0016118 secs]
[Full GC (Allocation Failure)  102853K->102804K(175104K), 0.0047356 secs]
[GC (Allocation Failure)  102804K->102804K(199680K), 0.0018186 secs]
[Full GC (Allocation Failure)  102804K->387K(126976K), 0.0102129 secs]
分配之后null
分配之后null`

可以看出第一次GC没有直接回收软引用关联的对象，而是发现回收之后内存还是不足才进行了软引用对象的回收。



<font color=red>抛出问题：即时在可达性分析算法中不可达的对象，一定会被GC回收吗？</font>

答案是否定的。

即使在可达性分析算法中不可达的对象，也并非"非死不可"的，这时候他们暂时处在"缓刑"阶段。要宣告一个对象的 真正死亡，至少要经历两次标记过程 : 如果对象在进行可达性分析之后发现没有与GC Roots相连接的引用链，那它将 会被第一次标记并且进行一次筛选，筛选的条件是此对象是否有必要执行finalize()方法。当对象没有覆盖finalize()方 法或者finalize()方法已经被JVM调用过，虚拟机会将这两种情况都视为"没有必要执行"，此时的对象才是真正"死"的 对象。 

如果这个对象被判定为有必要执行finalize()方法，那么这个对象将会被放置在一个叫做F-Queue的队列之中，并在稍 后由一个虚拟机自动建立的、低优先级的Finalizer线程去执行它(这里所说的执行指的是虚拟机会触发finalize()方 法)。finalize()方法是对象逃脱死亡的最后一次机会，稍后GC将对F-Queue中的对象进行第二次小规模标记，如果 对象在finalize()中成功拯救自己(只需要重新与引用链上的任何一个对象建立起关联关系即可)，那在第二次标记时它 将会被移除出"即将回收"的集合;如果对象这时候还是没有逃脱，那基本上它就是真的被回收了。 

```java

/**
 * 从代码示例我们发现，finalize方法确实被JVM触发，并且对象在被收集前成功逃脱。
 * 但是从结果上我们发现，两个完全一样的代码片段，结果是一次逃脱成功，一次失败
 * 这是因为，任何一个对象的 finalize()方法都只会被系统自动调用一次，
 * 如果相同的对象在逃脱一次后又面临一次回收，它的finalize()方法不会被再次执行，因此第二段代码的自救行动失败。
 */

/**
 * 观察对象的自我拯救(finalize方法)
 */
public class Test5 {
    public static Test4 test;
    public void isAlive(){
        System.out.println("I am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        test = this;
    }

    public static void main(String[] args) throws InterruptedException {

        test = new Test4();
        test = null;
        System.gc();
        Thread.sleep(500);
        if(test != null){
            test.isAlive();
        }else{
            System.out.println("Oh no I am dead");
        }

        test = null;
        System.gc();
        Thread.sleep(500);
        if(test != null){
            test.isAlive();
        }else{
            System.out.println("I am dead");
        }
    }
}
/**
finalize method executed
I am alive
I am dead
*/
```

#### 3.2回收方法区

方法区(永久代)的垃圾回收主要收集两部分内容 : 废弃常量和无用的类。 

回收废弃常量和回收Java堆中的对象十分类似。以常量池中字面量(直接量)的回收为例，假如一个字符串"abc"已经进 入了常量池中，但是当前系统没有任何一个String对象引用常量池的"abc"常量，也没有在其他地方引用这个字面量， 如果此时发生GC并且有必要的话，这个"abc"常量会被系统清理出常量池。常量池中的其他类(接口)、方法、字段的 符号引用也与此类似。 

判定一个类是否是"无用类"则相对复杂很多。类需要同时满足下面三个条件才会被算是"无用的类" : 

1. 该类所有实例都已经被回收(即在Java堆中不存在任何该类的实例)

2. 加载该类的ClassLoader已经被回收

3. 该类对应的Class对象没有在任何其他地方被引用，无法在任何地方通过反射访问该类的方法 

JVM可以对同时满足上述3个条件的无用类进行回收，也仅仅是"可以"而不是必然。在大量使用反射、动态代理等场景 都需要JVM具备类卸载的功能来防止永久代的溢出。 

### 3.3垃圾回收算法

##### 3.3.1标记-清除算法

分为两阶段：标记和清除，首先标记出所有要回收的对象，在标记完成后统一回收所有被标记的对象。

![屏幕快照 2019-09-02 16.10.22](/Users/houchang/Desktop/屏幕快照 2019-09-02 16.10.22.png)

标记-清除算法的不足主要有两个：

- 效率问题：标记清除这两个阶段的效率都不高
- 空间问题：标记清除之后会产生大量不连续的内存碎片，空间碎片太多的话可能导致以后程序运行中需要分配较大的对象的时候，无法找到足够的连续内存而不得不提前触发一次垃圾收集

##### 3.3.2复制算法(新生代回收算法)

"复制"算法是为了解决"标记-清理"的效率问题。它将可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这块内存需要进行垃圾回收时，会将此区域还存活着的对象复制到另一块上面，然后再把已经使用过的内存区域一次清理掉。这样做的好处是每次都是对整个半区进行内存回收，内存分配时也就不需要考虑内存碎片等复杂情况，只需要移动堆顶指针，按顺序分配即可。此算法实现简单，运行高效。算法的执行流程如下图 

![屏幕快照 2019-09-02 16.24.32](/Users/houchang/Desktop/屏幕快照 2019-09-02 16.24.32.png)

**现在的商用虚拟机(包括HotSpot都是采用这种收集算法来回收新生代) **

新生代中98%的对象都是"朝生夕死"的，所以并不需要按照1 : 1的比例来划分内存空间，而是将内存(新生代内存)分 为一块较大的Eden(伊甸园)空间和两块较小的Survivor(幸存者)空间，每次使用Eden和其中一块Survivor(两个 Survivor区域一个称为From区，另一个称为To区域)。当回收时，将Eden和Survivor中还存活的对象一次性复制到 另一块Survivor空间上，最后清理掉Eden和刚才用过的Survivor空间。 

当Survivor空间不够用时，需要依赖其他内存(老年代)进行分配担保。
 HotSpot默认Eden与Survivor的大小比例是8 : 1，也就是说Eden:Survivor From : Survivor To = 8:1:1。所以每次新 

生代可用内存空间为整个新生代容量的90%,而剩下的10%用来存放回收后存活的对象。 HotSpot实现的复制算法流程如下: 

> 1. 当Eden区满的时候,会触发第一次Minor gc,把还活着的对象拷贝到Survivor From区;当Eden区再次触发 Minor gc的时候,会扫描Eden区和From区域,对两个区域进行垃圾回收,经过这次回收后还存活的对象,则直 接复制到To区域,并将Eden和From区域清空。 
>
> 2. 当后续Eden又发生Minor gc的时候,会对Eden和To区域进行垃圾回收,存活的对象复制到From区域,并将 Eden和To区域清空。 
>
> 3. 部分对象会在From和To区域中复制来复制去,如此交换15次(由JVM参数MaxTenuringThreshold决定,这个 参数默认是15),最终如果还是存活,就存入到老年代 



![image-20190902163124838](/Users/houchang/Library/Application Support/typora-user-images/image-20190902163124838.png)

新生代各区占比如上图所示。

##### 3.3.3标记-整理算法（老年代回收算法）

复制收集算法在对象存活率较高的时候会进行比较多的复制操作，效率会变低，所以在对象存活率较高的老年代，采用标记整理算法。

![屏幕快照 2019-09-02 16.38.43](/Users/houchang/Desktop/屏幕快照 2019-09-02 16.38.43.png)

标记过程与标记清除过程一样，但后续步骤不是直接对可回收对象进行处理，而是让所有存活对象都向一端移动，然后直接清理掉端边界以外的内存。

##### 3.3.4分代收集算法

当前JVM垃圾收集都采用的是"分代收集（Generational Collection）"，这个算法并没有新思想，知识根据对象存活周期的不同将内存划分为几块。

一般是把Java Heap划分成新生代和老年代。新生代，每次回收都有大量的对象死去，采用复制算法。

而老年代中对象存活率高、没有额外空间对它进行分配担保，就必须采用标记整理或者标记清除算法。

***问题引出***

请问了解Minor GC和Full GC吗？有什么不一样？

>1.Minor GC又被称为新生代GC，指的是发生在新生代的垃圾收集，因为Java对象大多都是存活率低，朝生夕灭，因此MinorGC采用复制算法比较多，回收速度也快。
>
>2.Full GC 又称为老年代GC：指的是发生在老年代的垃圾回收，出现了MaiorGC，一般都会伴随至少一次的MinorGC，但是也有例外，在Parallel Scavenge收集器中就有直接进行FullGC的策略选择过程。Major GC的速度一般会比Minor GC慢10倍以上。

#### 3.4垃圾收集器

HotSpot虚拟机包含的收集器如下图所示：

![屏幕快照 2019-09-02 17.08.14](/Users/houchang/Desktop/屏幕快照 2019-09-02 17.08.14.png)

如果两个收集器之间存在连线，就说明它们之间可以搭配使用。

- 并行（Parallel）：指多条垃圾收集线程并行工作，用户线程仍处于等待状态。

- 并发（Concurrent）：指用户线程和垃圾线程同时执行（不一定并行，可能会交替执行），用户程序继续运行，而垃圾收集程序再另外一个CPU上。

- 吞吐量：

  ​		吞吐量 = 运行用户代码时间/(运行用户代码时间 + 垃圾收集时间)

  例如：虚拟机总共运行了100分钟，其中垃圾回收用了1分钟，吞吐量就为99%

  ##### 3.4.1Serial收集器

  - 特性

    ​		这个收集器是一个单线程的收集器，它最大的特点不只是它只会使用一个CPU或一条收集线程去完成垃圾收集工作，更重要的是在它垃圾回收的时候，必须停掉其他的工作线程，知道它收集结束（Stop The World）

  - 应用场景

    ​		Serial收集器是虚拟机运行在Client模式下的默认新生代收集器

  - 优势

    ​		简单而高效（与其他的收集器的单线程相比），对于限定单个CPU的环境来说，Serial收集器由于没有线程交互的开销，专心做垃圾收集自然可以获得最高的单线程收集效率。

    

![屏幕快照 2019-09-02 17.28.50](/Users/houchang/Desktop/屏幕快照 2019-09-02 17.28.50.png)



##### 3.4.2ParNew收集器(新生代收集器，并行GC)

​	ParNew收集器其实就是Serial收集器的多线程版本，除了使用多线程进行垃圾收集之外，其余行为包括Serial收集器可用的所有控制参数，收集算法，Stop The World，对象分配规则、回收策略都与Serial收集器完全一样。

- 特性：

Serial收集器的多线程版本

- 应用场景：

  ParNew收集器是许多运行在Server模式下的虚拟机中首选的新生代收集器

  作为Server的首选收集器之中有一个与性能无关的很重要的原因是:除了Serial收集器外，目前只有它能与CMS收集器配合工作。 在JDK 1.5时期，HotSpot推出了一款在强交互应用中几乎可认为有划时代意义的垃圾收集器——CMS收集器，这款收集器是HotSpot虚拟机中第一款真正意义上的并发收集器，它第一次实现了让垃圾收集线程与用户线程同时工作。 不幸的是，CMS作为老年代的收集器，却无法与JDK 1.4.0中已经存在的新生代收集器Parallel Scavenge配合工作，所以在JDK 1.5中使用CMS来收集老年代的时候，新生代只能选择ParNew或者Serial收集器中的一个。

- 对比分析：

  与Serial收集器相比：

  ParNew收集器在单CPU环境中绝对不会有比Serial收集器更好的效果，甚至有雨存在线程交互的开销，该收集器在通过超线程技术实现的两个CPU的环境中都不能百分之百地保证可以超越Serial收集器。

  然而，随着可以使用的CPU的数量的增加，它对于GC时系统资源的有效利用还是很有好处的。

  ![屏幕快照 2019-09-02 17.35.44](/Users/houchang/Desktop/屏幕快照 2019-09-02 17.35.44.png)

##### 3.4.3Parallel Scavenge收集器(新生代收集器，并行GC)

- 特性：

  Parallel Scavenge收集器是一个新生代收集器，它也是使用复制算法的收集器，又是并行的多线程收集器。

  Parallel Scanvenge收集器使用两个参数控制吞吐量：

  -XX:MaxGCPauseMillis控制最大的垃圾收集停顿时间

  -XX:GCRatio直接设置吞吐量的大小

  直观上，只要最大的垃圾收集停顿时间越小，吞吐量是越高的，但是**GC停顿时间的缩短是以牺牲吞吐量和新生代空间为代价的**，比如原来10秒收集一次，每次停顿100ms，现在变成5秒收集一次，每次停顿70ms。停顿时间下降的同时，吞吐量也下降了。

```
  应用场景:
停顿时间越短就越适合需要与用户交互的程序，良好的响应速度能提升用户体验，而高吞吐量则可以高效率地利用
```

CPU时间，尽快完成程序的运算任务，主要适合在后台运算而不需要太多交互的任务。 对比分析: 

​	Parallel Scavenge收集器 VS CMS等收集器: Parallel Scavenge收集器的特点是它的关注点与其他收集 器不同，CMS等收集器的关注点是尽可能地缩短垃圾收集时用户线程的停顿时间，而Parallel Scavenge收 集器的目标则是达到一个可控制的吞吐量(Throughput)。 由于与吞吐量关系密切，Parallel Scavenge 收集器也经常称为“吞吐量优先”收集器。 

​	Parallel Scavenge收集器 VS ParNew收集器: Parallel Scavenge收集器与ParNew收集器的一个重要区 

别是它具有自适应调节策略。 GC自适应的调节策略: 

​	Parallel Scavenge收集器有一个参数- XX:+UseAdaptiveSizePolicy 。当这个参数打开之后，就不需要手工指 定新生代的大小、Eden与Survivor区的比例、晋升老年代对象年龄等细节参数了，虚拟机会根据当前系统的运 行情况收集性能监控信息，动态调整这些参数以提供最合适的停顿时间或者最大的吞吐量，这种调节方式称为 GC自适应的调节策略(GC Ergonomics)。 

注:工作流程图同ParNew 



























