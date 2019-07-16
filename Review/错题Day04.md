1.下面属于黑盒测试方法的是  ( C ) 

A：语句覆盖

B：逻辑覆盖

C：边界值分析

D：路径覆盖

2.下面不能用作存储容量单位的是 ( C )

A:Byte

B:GB

C:MIPS

D:KB

3.下面属于软件定义阶段任务的是（A）

A：需求分析

B：软件分析

C：详细设计

D：系统维护

4.关于Socket通信编程，以下描述错误的是（D）

A：服务器端通过new ServerSocket()创建TCP连接对象

B：服务器端通过TCP连接对象调用accept()方法创建通信的Socket对象

C：客户端通过new Socket()方法创建通信的Socket对象

D：客户端通过new ServerSocket()创建TCP连接对象



##### 编程题1

 标题:买苹果 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易 将不会购买。 

输入描述:
 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
 输出描述: 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1 示例1:
 输入
 20
 输出
 3 

```java
public class Main{
  public static void main(String[] args){
    Scanner scanner = new Scanner();
    int n = scanner.nextInt();
		System.out.println(Main.buy(n));//20	3  	24  3
  }
  public static int buy(int n){
    if(n%2 != 0 || n < 6 || n == 10){//如果不是偶数或者n小于6或者等于10，那么都不能恰好购买n个苹果
      return -1;
    }
    if(n%8 == 0){
      return n/8;//如果n能被8整除，直接返回n/8
    }else{
      return n/8 + 1;//回溯1次，其结果为n/8-1+2 = n/8+1;回溯1次，其结果为n/8-2+3 = n/8+1。因此，可以情况3下，可以返回n/8+1
    }
  }
}
```



##### 编程题2

输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”

```java

```



