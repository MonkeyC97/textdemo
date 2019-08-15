昨天在写一个简单的SpringMVC时候，什么东西都在IDEA里面配置好了，但是仍报错，错误信息如下

<font color= red>至少有一个JAR被扫描用于TLD但尚未包含TLD。 为此记录器启用调试日志记录，以获取已扫描但未在其中找到TLD的完整JAR列表。 在扫描期间跳过不需要的JAR可以缩短启动时间和JSP编译时间</font>

![屏幕快照 2019-08-04 下午11.04.03](/Users/houchang/Desktop/屏幕快照 2019-08-04 下午11.04.03.png)

在网上找了好多解决办法，都没用，idea重启了好多次也没用，页面上面也是404NOT FOUND，最后找到了问题的所在，那就是在TomCat配置里面改一下就ok了。

如下图：![屏幕快照 2019-08-04 下午11.08.22](/Users/houchang/Desktop/屏幕快照 2019-08-04 下午11.08.22.png)

点击

![屏幕快照 2019-08-04 下午11.08.30](/Users/houchang/Desktop/屏幕快照 2019-08-04 下午11.08.30.png)

如图，把HTTP默认端口LocalHost，也就是图中的HTTP port：8080改为8088

![image-20190804231111674](/Users/houchang/Library/Application Support/typora-user-images/image-20190804231111674.png)

然后点击apply，点击ok，重新debug项目。

问题就解决了。