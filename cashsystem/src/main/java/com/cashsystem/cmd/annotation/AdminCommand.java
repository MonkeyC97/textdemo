package com.cashsystem.cmd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//源注解（注解之上的注解
// 注解不仅被保存到class文件当中，当JVM加载class文件之后，仍然存在

@Target(ElementType.TYPE)//说明了Annotation所修饰的对象范围：用于描述类、接口（包括注解类型）或枚举
public @interface AdminCommand {
}

