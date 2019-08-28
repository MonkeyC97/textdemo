#####JavaWeb2.0 Http1.1

1:发出请求

2:获取回应

#####容器：

1.管理生命周期

2.管理数据源【DBCP、C3P0、Durid、BoneCP...】

数据源的作用是：维持数据库的连接，管理连接池（维护一定数量的数据库连接）

为什么使用数据源连接池？

- 因为web应用程序默认使用数据源
- 提高资源（web应用资源）的利用率

3.容器的类型：

​    Tomcat（9.0.22）

​	Nginx

​    Jetty

##### 程序的分层

 1.写web应用程序为什么要分层？

​		**便于扩展和维护**

2.如何分层

​	MVC	M：管理类和类之间的关系   （订单和用户） 领域对象（User、Orders）———JavaBean（POJO）

​		POJO：无参构造方法，提供get、set方法，不继承，不实现接口

​		PO：持久化对象 ——>序列化

​		VO：值对象 ——>传递函数（各层之间）

​		POJO：原始简单的Java对象 （服务领域对象）

​		Domain：领域对象（业务）

>  类与类之间的关系：（继承，关联，依赖，聚合和组合）

​				V：视图(元数据（没有格式的数据）、数据的显示形式) ——JSP（在html页面写Java代码）

​				C：控制层：1获取表单参数 2调用业务逻辑3转向 ——Servlet（Java应用程序继承HttpServlet）

3.JSP+Servlet+JavaBean

JSP（9个内置对象）

- Request
- Response
- Session
- Application
- Page(this)
- Out
- Exception
- ServletConfig
- PageContext

Scriptlet:

- 声明：`<%! %>`

- scriptLet：`<%@ %>`

- 表达式：`<%= %>`

- `<%Java代码%>`

动作：`<jsp:xxx>`

Scriptlet+动作 = 在jsp页面所有的Java代码

JSP页面不应当承担所有的工作，而只是用来承担数据的显示工作

其他所有的和业务有关的工作交给Servlet

##### Servlet

- Servlet生命周期：`Initail()`,`Services()[doGet,doPost]`,`destory()`

- get请求和post请求有什么区别？

- - GET在浏览器会退时是无害的，而POST会再次提交请求
  - GET产生的URL地址可以被Bookmark，而POST不可以
  - GET请求会被浏览器主动cache，而POST不会，除非手动设置
  - GET请求只能进行url编码，而POST支持多种编码方式
  - GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留
  - GET请求在URL中传送的参数是有长度限制的，而POST没有
  - GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息
  - GET参数通过URL传递，POST放在Request body中	

- 重定向和请求转发

  ​	（*）重定向是两个request，请求转发是一个request

  ​	（*）URL地址发生变化，URL地址不发生变化

  ​	（*）一个能带值，一个不能带值

- 字符编码

  ​	GB2312  UTF-8 UTF-16 GBK Ascii Unicode

- web当中的字符编码(转码)

  > 过滤器 web.xml
  >
  > 页面中转码 pageEncoding
  >
  > servlet response.setContextType("html/text;charset=UTF-8")
  >
  > 数据库转码（1.数据库本身的编码，2链接字符串）

####第一个MVC应用程序

##### 如何做？怎么做？

- 数据库表设计
- 构建web工程





##### 1.Spring

IOC(DI) 依赖注入，控制反转 applicationContext.xml管理类和类之间的关系

AOP（面向切面编程）术语：

- 切面：Aspect
- 切点：Pointcut
- 织入：Weave
- 通知：Advice（before，after，throws）
- 目标对象：TargetObject
- 连接点：Joinpoint
- 代理对象（Proxyobject）
- Introduction

【横切关注点】Accross Cutting Point

##### 2.SpringMVC

MVC（JSP，Servlet，JavaBean）

参数绑定：默认绑定的参数

- request、response
- HttpSession、
- Model、集合类型
- POJO（属性名称只要一致就可以绑定）

书：JavaRestFul Web Service

​	   第一行代码：Android 第2版

​		鸟哥私房菜Linux

RHCE，CCNA，OCP、hadoop、Docker、Vue.js

考PMP，MBA

MyBatis

- 延迟加载

- 关联映射

- 缓存

- 输入映射parameterType

- 输出映射resultType resultMap

- SQL片段

- 动态SQL

- APIs 【SqlSessionFactory，SqlSession】

  - 传统的使用DAO的方法开发mapper

  - 使用动态代理的方法开发mapper

    ​	4+1个原则

  - 简单的CRUD操作



​	

