package com.javaclass;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/26 9:00
 */
public class demo2 {
    //        反射案例：
        /*
        *实现：
                1. 配置文件
                2. 反射
        *步骤：
        *   1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
            2. 在程序中加载读取配置文件
            3. 使用反射技术来加载类文件进内存
            4. 创建对象
            5. 执行方法
        *
        * 注意：需要将配置文件放在src目录下，放在src目录下的任何文件，都会被编译到classes目录下，
        * 这样做的目的是为了让配置文件跟随编译后的class文件一起，因为交付用户使用的是class文件，而不是源代码。
        *
        * - `InputStream getResourceAsStream(String name)`
          - 此方法返回输入流，该流从类目录下读取文件
          - 参数传递文件名
          *
          * properties文件：

            ```properties
            className=com.itheima.domain.Student
            methodName=sleep
        * */


    public static void main(String[] args) throws Exception {
        //获取类的加载器
        ClassLoader classLoader = demo2.class.getClassLoader();
      //加载器获取输入流，读取pro.properties文件
        InputStream resourceAsStream = classLoader.getResourceAsStream("Student.properties");
        Properties properties = new Properties();
        //集合IO关联
        properties.load(resourceAsStream);
        //获取集合中的键值对，类名
        String className = properties.getProperty("className");
        //获取集合中的键值对，方法名
        String methodName = properties.getProperty("methodName");
        //反射获取指定类的class文件对象
        Class aClass = Class.forName(className);
        Object object = aClass.newInstance();
        //获取指定的方法
        Method method = aClass.getMethod(methodName);
        //运行方法
        method.invoke(object);

    }
    @Test
    public void study(){
        System.out.println("测试");
    }
}


class Student1 {
    public void sleep(){
        System.out.println("sleep...");
    }
}
