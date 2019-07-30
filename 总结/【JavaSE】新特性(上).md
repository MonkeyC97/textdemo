### 新特性

#### 1.可变参数

```java
//现在假设说有这样的要求:要求设计⼀一个⽅方法，⽤用于计算任意参数的整数的相加结果。
public class Test1 {
    public static void main(String[] args) {
        System.out.println(add(new int[]{1,2,3}));
        System.out.println(add(new int[]{1,2,3,4,5,6,7}));
        System.out.println(add(new int[]{1,2,3,4,5,6,7,8,9}));

    }
    public static int add(int[] a){
        int sum = 0;
        for(int i = 0; i < a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
}
```

​	这种最初的实现方式本身存在缺陷，现在要求设计的不是数组，而是任意多个参数。从JDK1.5之后追加了可变参数的概念：

```java
public [static][final]返回值 方法名（[参数类型 参数名称][参数类型 ... 参数名称]）{
  ...
}//这个参数类型后面的...实际上表示的是一个数组结构
```

例如上面的例子可以写成：

```java

public class Test1 {
    public static void main(String[] args) {
        System.out.println(add("hehe",new int[]{1,2,3,4}));
        System.out.println(add("haha",1,2,3,4));
        System.out.println(new int[]{1,2,3,4,5,6,7,8,9});
    }
    public static int add(String msg,int ... a){//传递多个参数的时候，必须把可变参数放到最后一位
        int sum = 0;
        for(int i = 0; i <= a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
}

```

#### 2.foreach循环

格式：

```java
for(数据类型 临时变量 :数组（集合）){
  //循环次数为数组长度，而每一次循环都会顺序取出数组中的一个元素赋值给临时变量
}//所以，在for循环里面无须使用索引来取数据
```

范例：

```java
public class Test{
  static int[] a = new int[]{1,2,3,4,5,6};

    public static void main(String[] args) {
        int sum = 0;
        for(int x : a){//for-each循环
            System.out.println(x);
        }
    }
} //打印1，2，3，4，5，6
```



#### 3.泛型

泛型指的就是在类定义的时候并不会设置类中的属性或者方法中的参数的具体类型，而是在类使用时在进行定义。

泛型的基本语法：

```java
class Myclass<T>{
  	T value;
}
```

尖括号<>中的T被称作类型参数，用来指代任何类型。实际上这个T你可以任意写，但出于规范的目的，Java还是建议我们用单个大写字母来代替类型参数。

- T代表一般的任何类
- E代表ELement的意思，或者Exception异常的意思
- K代表Key的意思
- V代表Value的意思，通常与K一起配合使用
- S代表Subtype的意思

如果一个类被<T>的形式定义，那么它就被称为泛型类

```java
MyClass<String> myclass1 = new MyClass<String>();
MyClass<Integer> myclass2 = new MyClass<Integer>();
```

<font color=red>泛型只能接受类，所有的基本数据类型必须使用包装类</font>

范例：泛型类引入多个类型参数以及使用

```java
class MyClass<T,V>{
    private T value1;
    private V value2;
}
public class Test {
    public static void main(String[] args) {
        MyClass<String,Integer> myClass = new MyClass<String,Integer>();
    }
}
```

使用泛型定义Point类

```java

/**
 * 使用泛型定义point类
 */
class Point1<T>{
    private T x;
    private T y;
    public Point1(){

    }
    public T getX(){
        return x;
    }
    public void setX(T x){
        this.x = x;
    }
    public T getY(){
        return y;
    }
    public void setY(T y){
        this.y = y;
    }

}

public class Test2 {
    public static void main(String[] args) {
        Point1<String> point1 = new Point1<String>();
      //上句也可以写为Point1 point1 = new Point1<>();
        point1.setX("hehe");
        point1.setY("haha");
        System.out.println("X坐标为："+point1.getX()+" "+"Y坐标为："+point1.getY());
    }
}

```

范例：泛型方法与泛型类共存

```java

class MyClass1<T>{
    public void testMethod1(T t){
        System.out.println(t);
    }
    public <T> T testMethod2(T t){
        return t;
    }

    public <T> void testMethod3(T t){
        System.out.println(t);
    }
}

public class Test3 {
    public static void main(String[] args) {
        MyClass1<String> myClass1 = new MyClass1<String>();
        myClass1.testMethod1("emmm");
        Integer i = myClass1.testMethod2(100);
        myClass1.testMethod3(200);
    }
}

```

上述代码中，MyClass<T>是泛型类，testMethod1是泛型类中的普通方法，而testMethod2是一个泛型方法。而泛型类中的类型参数与泛型方法中的类型参数是没有相应的联系的。泛型方法始终以自己定义的类型参数为准。
泛型类的实际类型参数是String，而传递给泛型方法的类型参数是Integer，两者不相干。

但是，为了避免混淆，如果在一个泛型类中存在泛型方法，那么两者的类型参数最好不要同名。比如，MyClass<T>代码可以改为这样

```java
class MyClass1<T>{
  public void testMethod(T t){
    System.out.print(t);
  }
  public <E> E testMethod2(E e){
    return e;
  }
}
```

