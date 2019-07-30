# 8 三大特殊类

## 8.1 String类

##### 8.1.1 概念

​	用String类创建的字符串是一个固定的、不可改变的对象

​	一个字符串常量用双引号括起，如"同志们好"、"88.999"、"hello word"，可以把每个字符串常量当作一个对象来使用。程序执行时，系统自动将字符串常量封装为对象。

​	字符串是一个对象，必须声明一个变量来引用字符串

##### 8.1.2 构造字符串

​	1.字符串常量

```java
String str = "hehe";
```

​	该句执行之后，自动将字符串常量"hehe"封装为对象，并且将对象地址保存在变量str中，即str引用了字符串，str为字符串的名字。

​	2.构造方法

​	（1）String（String str）

​		用字符串常量为参数为参数构造一个字符串。例如：

```java
String s = new String("We are students");//将对象的地址保存在s中，字符串常量作为参数
```

​	（2）String（char[] ）

​		用一个字符数组为参数构造一个字符串。例如：

```java
char[] a = new char[]{"x","y","z"};
String s = new String(a);//用字符数组名作为参数
```

​	（3）String(char[] a, int startIndex,int count)

​		提取字符数组a的一部分字符创建一个字符串，参数startIndex和count分别指定在a中提取字符串的起始位置和截取的字符个数。例如：

```java
char[] a = new char[]{"s","t","u","d","e","n","t"};
String s = new String(a,2,3)
```

​		上述两条语句的执行结果与下面一条语句相同：

```java
String s = "bus";
```

  （4）String(byte[] a）

​		用字节数组为参数构造一个字符串，并返回字符串的引用

```java
byte a[] = {97,98,99};
```

​	(5)  String(byte[] a, int offset, int length)

​		表达式 new String(a, offset,length)的作用是从数组a的起始位置offset开始，取length个字节，构造一个字符串，并且返回字符串的引用。

##### 8.1.3 实用方法

​	假设 str、s是引用字符串的变量。下面讲解字符串的使用方法。

​	1.获取字符串的长度str.length

```java
 class Test{
 	 public static void main(String[] args) {
        String s = "monkeyc97 need to study harder and harder";
        String s1 = "1997-06-26";
        int n1 = s.length();
        int n2 = s1.length();
        System.out.println(n1);
        System.out.println(n2);
    }
 }
//41 	10
```

​	2.字符串的比较

​	(1)public boolean equals(String s)

```java
class Test{
  public static void main(String[] args) {
        String s1 = new String("hehe");
        String s2 = new String("hehe");
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
    }
}
//打印结果true 	false
```

​	此时s1 == s2的值是false，因为s1和s2保存的是两个对象在内存中地址，两个对象在内存中的地址不相等

​	.equals()方法比较的就是两个字符串的内容，只要内容一致返回true否则返回false

​	另外有一种忽略大小写的字符串比较方法  .equalsIgnoreCase(String s)

​	(2)public boolean startsWith(String s)

​	作用是判断此字符串的前缀是否与给定的字符串内容相同

```java
class Test{
   public static void main(String[] args) {
        String s = ("649152");
        String s1 = ("3718");
        System.out.println(s.startsWith("649"));
        System.out.println(s1.startsWith("083"));
    }
}
//true
//false
```

   (3) public boolean endsWith(String s)

​		作用是判断此字符串的后缀是否与自己给定的字符串内容相同

（4）public int compareTo(String s)

​		表达式str.compareTo的作用是比较str引用的字符串与s引用的字符串是否相同

```java
class Test{
  public static void main(String[] args) {
        String s1 = "a";
        String s2 = "A";
        System.out.println(s1.compareTo(s2));
    }
}
//打印结果32
```

​	通过查看源代码发现，底层用char类型数组保存每个字符串的字符，然后去做比较，如果俩字符不相等则返回差值，如果相等继续遍历，最后返回两个字符串长度的差值.

3.字符串的索引

（1）public int indexOf(String s)

​		从字符串的第一个字符开始寻找s字串首次出现的位置

```java
public class Test{
  public static void main(String[] args) {
        String s1 = new String("helloworld");
        System.out.println(s1.indexOf("ello"));
    }
}//返回1，如果没找到返回-1
```

（2）public int indexOf(String s,int startpoint)

​	从startpoint开始找如果找到返回出现的位置，这个位置是相对于整个字符串来说的。例如：

```java
public class Test{
  public static void main(String[] args) {
        String s1 = new String("helloworld");
        System.out.println(s1.indexOf("or",5));
    }
}// 6
```

（3）public int lastIndexOf(String s)

​	表示，从第一个字符开始找到给定字串s最后一次在字符串里面出现的位置。

（4）public int lastIndexOf(String s，int startpoint)

​	从给定位置开始找，找到返回给定字串s最后一次在字符串里面出现的位置。

4.截取字符串

​	（1）public String subString(int startpoint)

​	从指定的开始位置，截取字符串内容，例如：

```java
class Test{
  public static void main(String[] args) {
        String s1 = "heheworld";
        System.out.println(s1.substring(2));
    }
}//heworld
```

​	如果输入的截取长度超过字符串长度则会发生StringIndexOutOfBoundsException错误

（2）public String subString(int start,int end)

​	从指定的位置开始，从指定的位置结束，例如：

```java
class Test{
  public static void main(String[] args) {
        String s1 = "hello world";
        System.out.println(s1.substring(1,5));
    }
}// ello 
```

5.替换 

（1）public String replace(char oldChar,char newChar)

```java
class Test{
public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = s1.replace(s1,"hehe");
        System.out.println(s2);
    }
}//hehe
```

(2) public String replaceAll(String old,String new)

```java
class Test{
   public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = s1.replaceAll("l","2");
        System.out.println(s2);
    }
}//he22o wor2d
```

 (3) public String  trim()	去除字符串前面的空格

```java
class Test{
   public static void main(String[] args) {
        String s1 = "   I love you";
        System.out.println(s1.trim());
    }
}//I love you
```



6.字符串连接

​	public String concat(String s)

​	将两字符串连接在一起并且返回这个字符串的引用

```java
class Test{
  public static void main(String[] args) {
        String s1 = "I love you";
        String s2 = " three thousands times";
        System.out.println(s1.concat(s2));
    }
}// I love you three thousands times
```



##### 8.1.4 字符串与数组

1. 字符串向字符数组转换

   （1）public void getChars(int start,int end, char[] c,int offset)

   ​	将字符串中从start到end-1位置的字符复制到数组c中，并从数组c的offset处开始存放这些字符。必须保证数组c能容纳要被复制的字符个数。

```java
class Test{
  public static void main(String[] args) {
        String s1 = "I am so sorry";
        char[] a = new char[]{};
        s1.getChars(1,2,a,0);
    }
}
```

​		(2) public char[] toCharArray()

​		将字符串中的全部字符复制到该数组中，返回该数组的引用。数组的长度应该与字符串长度相等

```java
class Test{
  public static void main(String[] args) {
        String s1 = "four years no calls";
        char[] s = new char[20];
        s = s1.toCharArray();
        System.out.println(s[1]);
    }
}//打印结果 o
```



2. 字符串向字节数组转换

   public byte[] getBytes() 将字符串转换成字节数组，并返回字节数组的引用

   

3. 例子：验证回文字符串

```java
public class CheckPailndrome {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(isPailndrome(s)){
            System.out.println(s+"是回文");
        }else{
            System.out.println(s+"不是回文");
        }
    }

    public  static boolean isPailndrome(String s){

        int low = 0;
        int high = s.length() - 1;
        while (low < high){
            if(s.charAt(low) == s.charAt(high)){

                return true;
            }else{
                low++;
                high--;
            }
        }
        return false;
    }
}
//输入123321		123321是回文结构
```

