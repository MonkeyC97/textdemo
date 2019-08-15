今天在完成一个收银台项目的很简单的功能时，突然发现用idea写的Java代码往数据库中插入数据时，显示结果如下：

![屏幕快照 2019-08-09 下午8.43.34](/Users/houchang/Desktop/blog/屏幕快照 2019-08-09 下午8.43.34.png)

可以看见红框内我的name属性本来输入的是中文：悟空和猴子但是现在好像不支持中文，我先确定是不是数据库的问题。所以我在终端里面使用sql语句直接插入一条数据：

![屏幕快照 2019-08-09 下午8.47.47](/Users/houchang/Desktop/屏幕快照 2019-08-09 下午8.47.47.png)

此时，name属性和username属性都显示为中文，那么排除数据库本身的问题。

在网上搜了好一大堆，最后在连接数据库的时候加了两句代码搞定了…..

```java
String url = "jdbc:mysql://localhost:3306/check_stand?" +
                            "useUnicode=true&characterEncoding=utf-8&useSSL=false";
```

如此，问题解决，而且加入了useSSL=false之后也不会有警告。

