# 5.方法

## 5.1 方法定义

​	1.方法定义的一般格式

```java
访问修饰符 方法类型 返回值类型 方法名称（参数列表）
{
	方法体的内容;
}
```

	>访问修饰符： private、默认方式、protected、public。
	>
	>方法类型：包括：static、默认方式。
	>
	>返回值类型：可以是任何Java 数据类型。
	>
	>方法名：程序员给方法起的名字，一般要求达到见名知意的规范。

​	2.方法定义举例

```java
public class TestMax{//类声明，public表示类TestMax是公有的
  public static void main(String[] args) {
    int i = 8;
    int j = 3;
    int k = max(i,j);//调用max方法
    System.out.println("i和j中"+k+"是较大值");
}
//max方法的定义
public static int max(int num1,int num2){//public表示max方法是公有的 static表示方法是类方法
    if(num1 >= num2){
        return num1;
    }else{
        return num2;
    }
 }
}

```



 ## 5.2 方法调用

​	定义方法的目的就是为了以后调用方法。依据方法是否返回值，有两种调用方法的途径。

​	（1）方法返回一个值

```java
int k = max(i,j);   //调用方法max(i,j)，将其结果赋值给int类型的k
```

​	（2）方法不返回值

​		如果方法不返回值，即，返回数据类型是void，那么，将调用方法当成一条语句使用，例如：

```java
System.out.println("Hello World"); // 调用方法println的返回值类型是void
```

​	

## 5.3 参数的传递

​	方法中的形参有2类，一种是基本数据类型，一种是引用类型。

​	如果方法中的参数是基本数据类型，则调用方法时，实参值一一对应地传给形参，这称为按值传递；

​	如果方法中的参数是引用类型，则调用方法时，实参的地址一一对应地传给形参。

```java
 public static void main(String[] args) {
        int num1 = 6;
        int num2 = 8;
        System.out.println("在调用swap之前，num1 ="+num1+"  num2+"+num2);
        swap(num1,num2);
        System.out.println();
        System.out.println("在调用swap之后，num1 ="+num1+"  num2+"+num2);
    }
    public static void swap(int n1,int n2){
        System.out.println("在调用swap之前n1 = " + n1 + "  n2=" + n2);
        //下面是交换变量n1，n2的实现过程
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("在调用swap之后n1 = "+n1+"  n2="+n2);
    }
//打印结果为
/*
在调用swap之前，num1 =6  num2=8
在调用swap之前n1 = 6  n2=8
在调用swap之后n1 = 8  n2=6
在调用swap之后，num1 =6  num2=8
*/
```

​	在调用swap方法前，实参num1的值是6，num2的值是8。在调用swap方法后，实参num1、num2的值没有改变。即，swap方法执行后，没有改变实参的值。形参值的改变并没有影响实参num1和num2。



## 5.4 方法重载overload

​	在同一个类中有不同的方法，它们的方法名相同，参数列表（参数列表中参数的个数、参数的类型至少有一个不同），返回值不做要求，方法之间的这种现象称为方法重载。

​	例如：下面的程序定义三个方法。第一个求最大整数，第二个求最大双精度数，第三个求三个双精度数中的最大数。三个方法的名称都是max，但是，方法的参数列表不同。

```java
		public static int max(int num1,int num2){//int 类型的比较
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
    } 		
		public static double max(double num1,double num2){//double类型两个数值的比较
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
    }
    public static double max(double num1,double num2,double num3){//double类型三个数值的比较
         return max(max(num1,num2),num3);
    }

    public static void main(String[] args) {
        System.out.println(max(3,4));//4
        System.out.println(max(3.0,4.0));//4.0
        System.out.println(max(3.5,4.7,5.9));//5.9
    }
```

​		语句执行的时候，如果实参是int型，就调用int型的max方法，如果实参是double型，就调用形参为double型的max方法，如果实参是三个double型，就调用参数个数为三个double型的max方法。可见，调用语句执行时，java系统是根据实参的个数，参数类型取寻找匹配的方法。



## 5.5 方法应用



#### 例：计算十个随机数的平均值及十个随机数的平方和。

```java
public static void main(String[] args) {
        int num = 0;//保存一个随机数
        double sum = 0;//保存随机数的和
        double squresum = 0;//保存随机数的平方和
        for(int i = 0; i <= 10;i++){
            num = (int) Math.round(Math.random()*1000);//生成随机数num
            System.out.println(num);

            //对随机数进行求和
            sum = sum + num;
            //对随机数的和求平方和
            squresum = squresum + Math.pow(num,2);
        }
        //对随机数的和求平均值
        double mean = sum / 10;
        System.out.println("随机数的平均值为："+ mean);
        System.out.println("随机数的平方和为："+ squresum);
    }
/*
打印结果
831
368
901
986
193
265
310
116
349
749
201
随机数的平均值为：526.9
随机数的平方和为：3550215.0
*/
```



#### 例：利用递归计算阶乘

```java
public static void main(String[] args) {
        System.out.println("请输入一个正整数：");//提示用户输入一个正整数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("n的阶乘为："+factorial(n));
    }
    static long factorial(int n){
        if(n == 0){//递归结束的条件，当参数n为0 时，不再递归下去
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }
//打印结果 输入10 n的阶乘为3628800
```



### 例：利用递归求斐波那契数

```java
public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("第n个斐波那契数对应的值是："+ fib(n));
    }

    public static long fib(int n){
        if(n == 1 || n ==0){
            return 1;//停止递归调用
        }else{
            return fib(n - 1) + fib(n - 2);//斐波那契数列从第三项开始，当前项为前两项之和
        }
    }
//输入10 ，结果为89
```









