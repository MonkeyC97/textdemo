# 1.JavaSE之数据类型与运算符

## 1.1Java注释

#### Java中的注释分为三种

> (1) 单行注释：//
>
> (2) 多行注释：/*   注释内容    */
>
> (3) 文档注释：/**  文档注释   */  （常用于方法和类之上描述方法和类的作用，可以用来自动生成文档）

## 1.2Java中的标识符

#### Java语言中，对于变量，常量，函数，语句块也有名字，我们通常称为Java标识符。

(1) Java语言规定，标识符必须遵循以下规范：标识符必须以数字，大小写字母，下划线_，美元符号$组成。

> 例如，liu, _zhao, $wang等都是合法的标识符(但一般最好不要使用下划线和美元符号开头)。

(2) 标识符的第一个字符不能是数字，Java关键字不能当作Java标识符，一些特殊符号不能位于标识符中，如&，+，#，*，！以及一些中文特殊符号。

>例如，567kan, Chen#,@meng ，if，class，.com都不是合法的标识符。

(3) Java语言严格区分大小写。

>例如，Love和love是两个完全不同的标识符。

(4) 标识符的长度没有限制，但是不宜过长。



##### 类名和接口名（大驼峰命名法UpperCamelCase）

每个单词的首字母大写。

> 例如，MyClass，YouInterface。

##### 方法名，变量名，参数名（小驼峰命名法lowerCamelCase）

首字母小写，其余字母的首字母大写。

>例如，sendMail，getName，setAge，myVariable。

##### 常量名

基本数据类型的常量名由大写字母组成，字与字之间用下划线分隔。

>例如，BUILDING_WINDOW_COLOR，SHOP_CUSTOMER_NUMBER。



## 1.3 Java中的关键字

#### 关键字是Java特有的符号，用来表示特殊用途，用户不能重新定义这些符号。关键字由小写字母标示。

​    用于定义访问权限修饰符的关键字

>private.   public.  protected

​	用于定义类，函数，变量修饰符的关键字

>final.   abstract.  static. synchronized

 	用于定义类与类之间的关键字

>extends.   implements

​	用于定义建立实例及引用实例，判断实例的关键字

>new.  this. super. instanceof

​	用于异常处理的关键字

>try.  throw.  thorws.  catch.  finally

​	用于包的关键字

>package. import

​	其他修饰符关键字

>native. strictfp. transient. Volatile. assert

##### 关于Java关键字有以下几点说明：

>(1) Java中有两个未使用的保留字，goto，const
>
>(2) Java中有三个特殊含义的单词，true，false，null
>
>(3) JDK1.4之后追加了assert关键字，JDK1.5之后追加了enum关键字



## 1.4 数据类型

##### Java数据类型分为两大类：基本数据类型和引用数据类型

Java包括了8中常见的基本类型。

| 类型         | 关键字  | 字节数 |         取值范围          |
| :----------- | :------ | :----: | :-----------------------: |
| 布尔类型     | boolean |   1    |        true flase         |
| 字符类型     | char    |   2    | \u0000~\uFFFF（0～65535） |
| 字节型       | byte    |   1    |         -128～127         |
| 短整形       | short   |   2    |       -32768～32767       |
| 整形         | int     |   4    |       -2^31~2^31-1        |
| 长整型       | long    |   8    |       -2^63~2^63-1        |
| 单精度浮点数 | float   |   4    |      -3.4E38～3.4E38      |
| 双精度浮点数 | double  |   8    |     -1.7E308～1.7E308     |



