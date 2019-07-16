1.在异常处理中，一下描述不正确的有()

A：try块不可以省略

B：可以使用多重catch块

C：finally语句块可以省略

D：catch块和finall块可以同时省略

<font color=red>答案：D</font>

2.面向对象开发中，引用传递意味着传递的并不是实际的对象，而是对象的引用，因此，外部对引用对象所做的改变不会反映到所引用的对象上

<font color=red>错误</font>

<font color = red>		传值传参的时候，我们在函数中改变了参数的值，其对应的变量的值并不改变，值类型传参就是将变量保存的内容复制到函数的形参中，他们是两个不同的变量，值不过保存的内容相同不了.引用传参保存的是一个地址，这个地址里保存的是变量的具体值，而引用类型作为参数的时候，是将变量保存的地址值赋值到参数变量里，这样他们都指向了同一个内容，这样我们改变参数的成员的话，那么相应的变量的成员也会改变。</font>

3.下列哪种说法是正确的？

A：实例方法可直接调用超类的实例方法

B：实例方法可直接调用超类的类方法

C：实例方法可直接调用本类的类方法

D：实例方法可直接调用其他类的实例方法

<font color=red>选C</font>

<font color=red>如果超类的实例方法和类方法被private修饰那么就不能直接直接调用</font>

4.添加和删除元素时，ArrayList的表现更佳

<font color=red>错误</font>

<font color=red>ArrayList是基于数组实现的，查询快，但是增删慢</font>

<font color=red>LinkedList是基于链表实现的所以查询慢，但是增删快</font>

5.以下代码运行输出的是:

```java
class Father{
    private String name = "MonkeyC";
    private int age = 22;
    public Father(String name){
        this.name = name;
    }
    public Father(){}
}


public class TestDay03_2 extends Father{
    String grade;
    public TestDay03_2(){

    }

    public static void main(String[] args) {
        TestDay03_2 test = new TestDay03_2();
        Father father = new TestDay03_2();
//        father.name;这一行报错的原因是name属性被private修饰只能在本类中访问
    }
}
```



<font color="red">编译出错</font>

6.以下程序的输出结果为

```java
class Base{
    public Base(String s){
        System.out.println("B");
    }
}

public class TestDay03_3 extends Base{
    public TestDay03_3(String C){
        System.out.println("C");
    }
    public static void main(String[] args) {
            new TestDay03_3("D");
    }
}
```

<font color=red>编译出错,因为实例化子类默认调用父类无参的构造函数，但是在父类中却没有提供</font>

编程题1:

