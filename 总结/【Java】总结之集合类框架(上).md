### 集合框架

#### Collection接口

在Java的类集里面(java.util)提供了两个最为核心的接口:Collection、Map接口。其中Collection接口的操作形式与之前编写链表的操作形式类似，每进行一次数据操作的时候只能够对单个对象，进行处理。

**Collection是单个集合保存的最大父接口**

Collection接口的定义如下：

`public interface collection<E> extends Iterable<E>`

从JDK1.5开始发现Collection接口上追加有泛型应用，这要的好处是可以避免ClassCastException，里面的所有数据的保存类型应该是相同的。在JDK1.5之前It 儿啊罢了接口中的iterator()方法是直接在Collection接口中定义的。此接口的常用方法有以下几个：

| No.  | 方法名称                                          | 类型 | 描述                                   |
| ---- | ------------------------------------------------- | ---- | -------------------------------------- |
| 1    | public boolean add(E e);                          | 普通 | 向集合中添加数据                       |
| 2    | public boolean addAll(Collection<? extends E > c) | 普通 | 向集合中添加一组数据                   |
| 3    | public void clean();                              | 普通 | 清空集合数据                           |
| 4    | public boolean contains(Object o);                | 普通 | 查找数据是否存在，需要使用equals()方法 |
| 5    | public boolean remove(Object o);                  | 普通 | 删除数据，需要使用equals()方法         |
| 6    | public int size();                                | 普通 | 取得集合长度                           |
| 7    | public Object[] toArray();                        | 普通 | 将集合变为对象数组返回                 |
| 8    | public Iterator<E> iterator();                    | 普通 | 取得Iterator接口对象，用于集合输出     |

在开发中，我们很少会直接使用Collection接口，Collection接口只是一个存储数据的标准，并不能区分存储类型。例如：要存放的数据需要区分重复与不重复。在实际开发之中，往往会考虑使用Collection接口的字接口：`List(允许数据重复)`、`Set(不允许数据重复)`

#### 2.List接口

首先来观察List接口中提供的方法，在这个接口中有两个重要的扩充方法：

| No.  | 方法名称                           | 类型 | 描述                 |
| ---- | ---------------------------------- | ---- | -------------------- |
| 1    | public E get(int index);           | 普通 | 根据索引取得保存数据 |
| 2    | public E set(int index,E element); | 普通 | 修改数据             |

List子接口与Collection接口相比最大的特点在于其有一个get()方法，可以根据索引取得内容。由于List本身还是接口，要想取得接口的实例化对象，就必须有子类，在List接口下有三个常用子类：ArrayList、Vector、LinkedList

##### ArrayList子类

ArrayList是一个针对与List接口的数组实现

```java

import java.util.ArrayList;
import java.util.List;


public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
     	 System.out.println(list);
    }
}
//[hello, hello, world]
```

通过上述代码我们知道，List允许保存重复数据。

```java
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.size()+"、"+list.isEmpty());
        list.add("hello");
        list.add("hello");
        list.add("world");
        System.out.println(list.size()+"、"+list.isEmpty());//长度和是否为空
        System.out.println(list.remove("hello"));//删除
        System.out.println(list.contains("world"));//包括
        System.out.println(list);
    }
}
/*
0、true
3、false
true
true
[hello, world]
*/
```

范例：List的get()操作

```java
import java.util.ArrayList;
import java.util.List;
public class TestDemo{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        list.add("heihei");
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
```

**get()方法是List子接口提供的，如果现在操作的是Collection接口，那么对于此事的数据取出只能够将集合变为对象数组操作**

```java
public class Test2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }
}[hehe, haha]
```

#### 集合与简单Java类

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person{
    String name;
    int age;
    public Person(){

    }
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class Test3 {
    public static void main(String[] args) {
        List<Person> list  = new ArrayList<>();
        list.add(new Person(22,"侯昌"));
        list.add(new Person(22,"侯昌"));
        list.add(new Person(21,"姚怡欢"));
        for(Person p :list){
            System.out.println(p);
        }
      //集合类中contains()、remove()方法需要equals()支持
        System.out.println(list.contains(new Person(22,"侯昌")));
    }
}
```

##### Vector

使用vector：

```java
import java.util.List;
import java.util.Vector;

public class Test4 {
    public static void main(String[] args) {
        List<String> list  = new Vector<>();
        list.add("hehe");
        list.add("hah");
        list.clear();
        System.out.println(list);
    }
}
//[]
```

ArrayList与Vector的区别：

1.ArrayList是从JDK1.2开始提供的，而Vector是用JDK1.0开始就有了

2.ArrayList是异步处理，Vector是同步处理，性能较低

3.ArrayList是非线程安全；Vector是线程安全

4.输出形式：ArrayList支持Iterator、ListIterAtor、foreach；Vector支持Iterator、ListIterator、foreach、Enumeration

优先考虑ArrayList，因为其性能更高，实际开发时很多时候也是每个线程拥有自己独立的集合资源。如果需要考虑同步也可以使用concurrent包提供的工具将ArrayList变为线程安全的集合。

#### LinkedList子类

ArrayList和LinkedList的区别：

1.观察ArrayList源码可以发现ArrayList里面存放的是一个数组，如果实例化此类对向时传入了数组大小。则里面保存的数组就回开辟一个定长的数据，但是后面在进行数据保存的时候发现数组个数不够了会进行数组动态扩容。

2.LinkedList：是一个纯粹的链表实现。

**ArrayList封装的是数组，LinkedList封装的是链表，ArrayList时间复杂度是1，而LinkedList的复杂度为n**

### Set集合接口

Set接口与List接口最大的不同在与Set接口中的内容是不允许重复的，同时需要注意的是，Set接口并没有对Collection接口进行扩充，而List对Collection进行了扩充，因此在Set接口中没有get()方法。

在Set子接口中有两个常用子类：HashSet(无序存储)、TreeSet(有序存储)

##### Set接口常用子类

```java
/**
 * Set子类的使用
 */
public class TestDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("haha");
        set.add("haha");//重复数据
        set.add("hehe");
        for(String str :set){
            System.out.println(str);
        }
    }
}
//haha
//hehe 重复数据只会打印一条
```

```java
/*
* TreeSet的使用
*/
public class Test5 {
    //TreeSet的使用
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("C");
        set.add("D");
        set.add("B");
        set.add("D");
        set.add("A");
        set.add("E");
        set.add("Z");
        set.add("a");
        System.out.println(set);
    }
}
//[A, B, C, D, E, Z, a]
```

**TreeSet使用的是升序排列的模式完成的**

##### TreeSet排序分析

既然TreeSet子类可以进行排序，所以我们可以利用TreeSet实现数据的排列处理操作，此时想要进行排序实际上是针对与对象数组进行的排序处理，而如果要进行对象数组的排序，对象所在的类一定要实现Cpmparable接口并且覆写compareTo()方法，只有通过此方法才能知道大小关系

```java

import java.util.Set;
import java.util.TreeSet;

class Person1 implements Comparable<Person1>{

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person1(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person1 o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }
    }
}

public class Test6 {
    public static void main(String[] args) {
        Set<Person1> set = new TreeSet<>();
        set.add(new Person1("侯昌",22));
        set.add(new Person1("姚怡欢",21));
        set.add(new Person1("王亮棒",22));
				for(Person1 p : set){
          System.out.println(set);
        }
    }
}
//Person1{name='姚怡欢', age=21}
//Person1{name='侯昌', age=22}
//Person1{name='王亮棒', age=22}
```

#### Comparable接口与Comparator接口

**Comparable是排序接口**

若一个类实现了Comparable接口，就意味着"该类支持排序"。既然实现了Comparable接口的类支持排序，假设现在存在实现Comparable接口的类的对象的List列表(或数组)，则该List列表(或数组)可以通过Collections.sort()或者Arrays.sort()进行排序，此外，"实现Comparable"接口的类的对象可以用作有序映射(如TreeMap)中的键或有序集合(TreeSet)中的元素，而不需要制定比较器

**Comparable定义**

Comparable接口仅仅只包括一个函数：

````java
public interface Comparable<T>{
  public int compareTo(T o);
}
````

**关于返回值**

可以看出compareTo方法返回一个int值，该值有三种返回值：

> 1.返回负值：表示当前对象小于比较对象
>
> 2.返回正值：表示当前对象大雨比较对象
>
> 3.返回0：表示当前对象等于目标对象

##### Comparator(外部排序接口)简介

Comparator是比较器接口

我们若需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)；那么，我们可以建立一个"该类的比较器"来进行排序。这个"比较器只需要实现Comparator"接口即可。

也就是说，**实现Comparator类来新建一个比较器**，然后通过该比较器对类进行排序

Comparator定义，Comparator接口仅仅包括两个函数：

```java
public interface Comparator<T>{
  int compare(T o1,T o2);
  boolean equals(Object obj);
}
```

`int compare(T o1,T o2)`是比较o1和o2的大小，返回"负数"，意味着"o1比o2"小，返回"0"，意味相等，返回"正数"，意味着o1大于o2.

**Comparator和Comparable比较**

Comparable是排序接口；若一个类实现了Comparable接口，就意味着"该类支持排序"。而Conparator是比较器；我们若需要控制某个类的次序，可以建立一个"该类的比较器"来进行排序。

```java
package Review.Test.collection;

/**
 * 使用Comparator接口
 */

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person2{
    private int age;
    private String name;

    public Person2(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
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

}

class AscAgeComparator implements Comparator<Person2>{


    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o1.getAge() - o2.getAge();
    }
}
class DescAgeComparator implements Comparator<Person2>{

    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o2.getAge() - o1.getAge();
    }
}
public class Test7 {
    public static void main(String[] args) {
        Set<Person2> set = new TreeSet<>(new AscAgeComparator());
        set.add(new Person2(22,"侯昌"));
        set.add(new Person2(21,"姚怡欢"));
            System.out.println(set);
        System.out.println("------------------------------------------------------------");
        Set<Person2> set1 = new TreeSet<>(new DescAgeComparator());
        set1.add(new Person2(23,"王亮"));
        set1.add(new Person2(25,"王凡"));
            System.out.println(set1);
    }
}


//[Person2{age=21, name='姚怡欢'}, Person2{age=22, name='侯昌'}]
//------------------------------------------------------------
//[Person2{age=25, name='王凡'}, Person2{age=23, name='王亮'}]
```

##### 重复元素判断(hashCode()与equals()方法)

在使用TreeSet子类进行数据保存的时候，重复元素的判断依靠的Comparable接口完成的，但是这并不是全部Set接口判断重复元素的方式，因为如果使用的是HashSet子类，由于其跟Comparable没有任何关系，所以它判断重复元素依靠的方式是来自于Object类中的两个方法：

`1.hash码：public native int hashCode();`

`2.对象比较：public boolean equals(Object obj);`

`equals()`的作用是用来判断两个对象是否相等，在Object类中equals()方法的定义如下：

```java
public boolean equals(Object obj){
	return (this == obj);
}
```

这说明在我们实现自己的equals方法之前，equals等价于`==`，而`==`运算符是判断两个对象是不是同一个对象，即他们的**地址是否相等**，而覆写equals更多的是追求两个对象**在逻辑上的相等**，也就是**值相等**，或者**内容相等**

覆写，equals的准则

***自反性***：对于任何非空引用值x，`x.equals(x)`都应该返回`true`.

***对称性***：对于任何非空引用值x和y，当且仅当`y.equals(x)`返回`true`时,`x.equals(y)`才应返回true.

***传递性***：对于任何非空引用值x，y，z如果`x.equals(y)`返回`true`，并且`y.equals(z)`返回`true`，那么`x.equals(z)`应该返回`true`.

***一致性***：对于任何非空引用值x和y，多次调用`x.equals(y)`始终返回`true`或始终返回`flase`，前提是对象上equals比较重所用的信息没有被修改.

***非空性***：对于任何非空引用值x,`x.equals(null)`都应该返回flase

**hashCode()**用于返回对象的hash值，主要用于查找的快捷性，因为hashCode也是在Object对象中就有的，所以所有Java对象都有hashCode，在Hashtable和HashMap这一类的散列结构中，都是通过hashCode来查找在散列表中的位置的。

在Java中进行对象比较的操作有两步，第一步要通过一个对象的唯一编码找到一个对象的信息，当编码匹配之后再调用equlas()方法进行内容的比较

范例：覆写hashCode()与equals()方法消除重复

```java
/**
 * 覆写hashCode()与equals()方法消除重复
 */

class Person3 implements Comparable<Person3>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Person3(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person3 person3 = (Person3) o;
        return age == person3.age &&
                Objects.equals(name, person3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

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
    public int compareTo(Person3 o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }
        else{
            return this.name.compareTo(o.name);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Set<Person3> set = new HashSet<>();
        set.add(new Person3("houchang",23));
        set.add(new Person3("houchang",23));
        set.add(new Person3("monkeyc",23));
        set.add(new Person3("qiaobiluo",58));
        for(Person3 p :set){
            System.out.println(p);
        }
    }
}
/*
* Person3{name='monkeyc', age=23}
*	Person3{name='qiaobiluo', age=58}
*	Person3{name='houchang', age=23}
*/
```

***如果两个对象equals，那么他们的hashCode必然相等，但是hashCode相等，equals不一定相等***。

***对象判断必须两个方法equlas()，hashCode()返回值都相同才能判断为相同***















