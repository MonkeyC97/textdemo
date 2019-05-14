## 一.基本概念


 ***数组的动态初始化***

   数组类型[]数组名称 = new 数组类型[长度];


```
int[] arr = new int[3];
```

1.数组的访问通过索引来完成，即数组名称[索引]，索引从0开始，所以可以采用的索引范围从0～索引 - 1，假设现在开辟了3个空间的数组，那么可以使用的索引是0，1，2，如果访问超过了数组索引，将会提示java.lang.ArrayIndexOutOfBoundsException

```
int[] arr = new int[3];
System.out.println(arr[3]);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418143823830.png)

2.当数组采用动态初始化开辟空间后，数组之中的每个元素都是该数据类型的默认值。

```
int[] arr = new int[3]
System.out.println(arr[1]);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418144011850.png)

3.数组本身是一个有序的集合操作，所以对于数组的内容操作往往使用循环来完成(数组是一个有限的合集，往往使用for循环)。

```
char[] arr = new char[3];
char[0] = 'a';
char[1] = 'b';
char[2] = 'c';
for(int i = 0; i < arr.length; i++){
System.out.println(char[i]);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019041814453233.png)

4.在java中有一种动态取得数组长度的方法，数组名称.length

```
/动态初始化数组
       int[] x = new int [3];
      System.out.println(x[1]);process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)//int 类型如果没有进行初始化的话，那么结果将是0;(系统在编译的时候已经进行了初始化)
        x[2] = 1;
        x[1] = 3;
        x[0] = 6;
        for(int i = 0;i < x.length;i++){
            System.out.println(x[i]);//通过循环控制索引下标来修改数组里面存放的数的值
        }

        
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418144816839.png?x-oss-)



 ***数组的静态初始化***


数据类型 []数组名称 = new 数据类型[]{值，值，....}

```
int[] arr = new int[]{1,2,3,4};
   for(int i = 0; i < arr.length; i++){
		System.out.println(arr[i]);
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019041814545990.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)
***二维数组***

动态初始化：数组类型[ ][ ]数组名称 = new 数组类型[列个数 ][行个数 ]

```
int[][] arr = new int[][]{{1,2,3},{4,5},{6,7,8,9}};
        for(int i = 0;i < arr.length;i++){
          for(int j = 0;j < arr[i].length;j++){
            System.out.println("data["+i+"]["+j+"]="+arr[i][j]+"、") ;
          }
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418151341547.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)
	


***数组与方法互操作***

数组是引用数据类型，所有引用数据类型都可以设置多个栈内存指向，所以在进行数组操作的时候，也可以将其通过方法进行处理。

1 方法接受数组

```
public class Test{
  public static void printArray(int[] temp){
      for(int i = 0;i < temp.length;i++){
        System.out.println(temp[i]);
      }
  }
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5,6};
    printArray(arr);
  }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418153208697.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)
2.方法返回数组

```
 public static void main(String[] args) {
    int[] arr = init();

    printArray(arr);
  }
  public static int[] init(){
    return new int[]{1,2,3,4};
  }
  public static void printArray(int[] temp) {
    for(int i = 0;i < temp.length;i++){
      System.out.println(temp[i]);
    }
  }
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418154227932.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)


3.方法修改数组

```
public static void main(String[] args) {
    int[] arr = init();
    bigger(arr);
    printArray(arr);
  }
  public static int[] init(){
    return new int[]{1,2,3,4};
  }
  public static void bigger(int[] temp){
    for(int i = 0;i < temp.length;i++){
      temp[i] = temp[i]*2;
    }
  }
  public static void printArray(int[] temp) {
    for(int i = 0;i < temp.length;i++){
      System.out.println(temp[i]);
    }
  }
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418154733917.png)



 ***Java对数组的支持***

 java实现数组的排序java.util.Arrays.sort(arrayName);


```
public static void main(String[] args) {
  int[] arr = new int[]{1,2,3,4,5,6,7};
  char[] arr1 = new char[]{'a','b','c','d','e'};
  java.util.Arrays.sort(arr);
  java.util.Arrays.sort(arr1);
  printArray(arr);
  printArray2(arr1);
   }
   public static void printArray(int[] temp){
     for(int i = 0;i < temp.length;i++){
       System.out.println(temp[i]);
     }
     
   }
   public static void printArray2(char[] temp){
     for(int i = 0;i <temp.length;i++){
       System.out.println(temp[i]);
     }
   }
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418155930370.png)

数组的拷贝：四种方法
1. for
2. clone
3. System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度)

```
public static void main(String[] args) {
   int[] arr = new int[]{1,2,3,4,5,6,7};
  char[] arr1 = new char[]{'a','b','c','d','e'};
  System.arraycopy(arr1,1,arr,2,3);
  printArray(arr);
   }
   public static void printArray(int[] temp){
     for(int i = 0;i < temp.length;i++){
       System.out.print(temp[i]);
     }
     
```
![](https://img-blog.csdnimg.cn/20190418161012969.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)
打印结果出现异常，最后更改两个数组的类型都为int型，最后编译通过，成功运行

```
public static void main(String[] args) {
  int[] arr = new int[]{1,2,3,4,5,6,7};
  int[] arr1 = new int[]{11,22,33,44,55,66,77};
  System.arraycopy(arr1,1,arr,2,3);
  printArray(arr);
  
   }
   public static void printArray(int[] temp){
     for(int i = 0;i < temp.length;i++){
       System.out.println(temp[i]);
     }
     
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418161320110.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)

4. Arrays.copyOf(源数组名称，新数组长度)

```
public class Test{
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5,6};
    int[] result=Arrays.copyOf(arr, 10);  
    for(int temp : result){//依次输出result里面的每个值
        System.out.println(temp);
    }
  }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418164341975.png)

这里还可以使用Arrays.copyOf扩大数组的长度。

```
public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5};
    int[] result=Arrays.copyOf(arr, arr.length*2);  
    for(int temp : result){
      System.out.println(temp);
    }
  }
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418165037834.png)

***四种方法中System.arraycopy()是最拷贝速度最快的，被native修饰所表示底层代码是由C/C++完成的。***


这四种拷贝方式，对于基本类型来说是深拷贝，对于引用类型来说都是浅拷贝。

浅拷贝：只复制一层对象，当对象的属性是引用类型时，实质复制的是其引用，当引用指向的值改变时也会跟着改变。

深拷贝：一个整个独立的对象拷贝，深拷贝会拷贝所有的属性,并拷贝属性指向的动态分配的内存。当对象和它所引用的对象一起拷贝时即发生深拷贝。深拷贝相比于浅拷贝速度较慢并且花销较大。



***对象数组***

对象数组往往是以引用数据类型为主的定义，例如：类，借口。

动态初始化：类名称[ ] 对象数组名称 = new  类名称 [长度 ] ;
静态初始化：类名称[ ] 对象数组名称 = new 类名称  [ ] { } ;

```
//对象数组的静态初始化

class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void getInfo(){
        System.out.println("姓名:"+this.name+"\n"+"年龄:"+this.age);
    }
}
public class ArrayDemo3{
    public static void main(String[] args) {
        Person[]per = new Person[]{
            new Person ("张三",13),
            new Person ("李四",15),
            new Person ("王五",16)
        };
       for(int i = 0;i < per.length;i++){
             per[i].getInfo();
       }
    }
     
}


```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418171249214.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3ODI1Mw==,size_16,color_FFFFFF,t_70)
对象数组的动态初始化：

```
class Person {
          private String name ;
          private int age ;
          public Person(String name, int age) {
                  this.name = name ;
                  this.age = age ;
          }
          public void getInfo() {
System.out.println("姓名:"+this.name+",年年龄:"+this.age) ;
}
  }
  public class Test {
public static void main(String[] args){
Person[] per = new Person[3] ; // 数组动态初始化，每个元素都是其对应数据类型的默认值
per[0] = new Person("张三",1) ;
per[1] = new Person("李四",2) ;
per[2] = new Person("王五",3) ; for(intx=0;x<per.length ;x++){
        per[x].getInfo() ;
   }
  }
}

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418171609889.png)