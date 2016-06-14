IMWR changed
====

+ 添加SSDBClient客户端（Spring配置，commons-pool2 线程池，异常捕获，结果转换为基本数据类型），Spring 配置如下

----------------
```
<bean id="ssdbClient" class="org.nutz.ssdb4j.SSDBClient" destroy-method="close">
	<constructor-arg name="host" value="127.0.0.1" />
	<constructor-arg name="port" value="8888" />
	<constructor-arg name="timeoutSeconds" value="3000" />
	<constructor-arg name="pass" value="" />
</bean>
```
+ 添加 apache commons-pool2 线程池
+ Response新增KeyValue及Block格式转换
+ 删除官方文档没有的命令（需要可自行添加），新增zpop_front、zpop_back等命令

Name
====

ssdb4j
======

又一个SSDB的Java驱动. 连接池,主从,都有了

SSDB官网
-----------------

https://github.com/ideawu/ssdb

License
-------------------
BSD 3-Clause License

maven
-----------------

```
<dependency>
    <groupId>org.nutz</groupId>
    <artifactId>ssdb4j</artifactId>
    <version>9.4</version>
</dependency>
```

依赖的jar
----------------

Apache Common Pool 1.6 http://commons.apache.org/proper/commons-pool/download_pool.cgi

最简单用法
----------------

```
import org.nutz.ssdb4j.spi.SSDB;
import org.nutz.ssdb4j.spi.Response;
import org.nutz.ssdb4j.SSDBs;


SSDB ssdb = SSDBs.simple();
ssdb.set("name", "wendal").check(); // call check() to make sure resp is ok 

Response resp = ssdb.get("name");
if (!resp.ok()) {
    // ...
} else {
    log.info("name=" + resp.asString());
}
```
