### 集合输出的方法

集合输出一共有四种手段：Iterator、ListIterator、Enumeration、foreach

#### - 迭代输出：Iterator

在JDK1.5之前，在Collection接口中就定义有iterator()方法，通过此方法可以取得Iterator接口的实例化对象；而在JDK1.5之后，将此方法提升为Iterable接口中的方法。无论你如何提升，只要Collection有这个方法，那么List、Set也一定有此方法。

​	对于Iterator接口最初的设计里面实际有三个抽象方法：

		1. 判断是否有下一个元素：`public boolean hasNext();`
  		2. 取得当前元素：`public E next();`
  		3. 删除元素:`public default void remove();，`此方法从JDK1.8开始变为default完整方法

​	范例：标准的Iterator使用

```java
public class TestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        list.add("xixi");
        Iterator<String> iterator = list.iterator();//实例化Iterator对象
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
/*
*	hehe
*	haha
*	xixi
*/
```

对于Iterator接口中提供的remove()方法主要解决的就是集合内容的删除操作。

```java
public class TestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("world");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("world")){
                iterator.remove();//此时使用集合提供的list.remove()方法，会产生ConcurrentModificationException，原因是modCount与excptedModCount数不同(源码)
              //使用iterator.remove()则不会报错
                continue;
            }
            System.out.println(str);
        }
    }
}
//hello
//hello
```

#### 双向迭代接口：ListIterator

Iterator输出有一个特点：**只能够由前向后进行内容的迭代，而如果要想进行双向迭代，那么就必须依靠Iterator的子接口：ListIterator来实现。**

此接口定义的方法：

1.判读是否有上一个元素：`public ListIterator listIterator();`

2.取得上一个元素：`public E previous();`

Iterator接口对象是由Collection接口支持的，但是ListIterator是由List接口支持的，List接口提供有如下方法：

- 取得ListIterator接口对象：`public ListIterator listIterator();`

范例：观察ListIterator接口使用

```java
public class Test11 {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("从前到后输出");
        while(listIterator.hasNext()){
            String str = listIterator.next();
            System.out.println(str);
        }
        System.out.println("从后往前输出");
        while(listIterator.hasPrevious()){
            String str2 = listIterator.previous();
            System.out.println(str2);
        }
    }
}
/*从前到后输出
1
2
3
4
从后往前输出
4
3
2
1
*/
```

先进行从前向后的输出，再进行从后往前的输出，否则无法实现双向

#### Enumeration枚举输出

在JDK1.0的时候就引入了Enumeration输出接口，而在JDK1.5的时候对其也做了更正，主要是追加了泛型的应用。首先来观察Enumeration的接口定义：

​	1.判断是否有下一个元素：`public boolean hasMoreElements();`

​	2.取得元素：`public E nextElement();`

但是要取得这个接口的实例化对象，是不能依靠Collection、List、Set等接口的。**只能依靠Vector子类，因为Enumeration最早的设计就是为了Vector服务的，在Vector类中提供有一个取得Enumeration接口对象的方法**：

- 取得Enumeration接口对象：`public Enumeration<E> elements();`

范例：使用Enumeration输出

```java
/**
 * Enumeration接口的使用
 */

public class TestDemo{
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("hehe");
        vector.add("haha");
        Enumeration<String> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
//hehe
//haha
```

#### foreach输出

从JDK1.5开始，foreach可以用来输出数组，实际上除了数组之外也可以输出集合

```java
public class TestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        list.add("hahah");
        for(String str : list){
            System.out.println(str);
        }
    }
}
//hehe
//haha
//hahah
```