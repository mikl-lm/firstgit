package com.example.concurrent.annotation;

import com.example.concurrent.config.DataSources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解有几点需要注意：

 1）@Target 是作用的目标，接口、方法、类、字段、包等等，具体看：ElementType

 2）@Retention 是注解存在的范围，RUNTIME代表的是注解会在class字节码文件中存在，在运行时可以通过反射获取到，具体看：RetentionPolicy

 3）允许的变量，通常都要给定默认值，比如我们使用一个service时，可以@Service，也可以@Service("xxxx")
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RoutingDataSource {
    String value() default DataSources.MASTER_DB;
}
