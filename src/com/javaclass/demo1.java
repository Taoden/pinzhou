package com.javaclass;

import lombok.*;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/26 8:40
 */
public class demo1 {

    /*
    *   1. 创建类的实例。
        2. 类的静态变量，或者为静态变量赋值。
        3. 类的静态方法。
        4. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象。
        5. 初始化某个类的子类。
        6. 直接使用java.exe命令来运行某个主类。
    * */

//      框架：半成品软件。可以在框架的基础上进行软件开发，简化编码
//      反射：将java代码的各个组成部分封装为其他对象，可以在程序运行过程中操作这些对象，
//      反射的好处：
//      可以在程序运行过程中，操作这些对象。
//      可以解耦，提高程序的可扩展性。

    /*
    * 获取Class对象的方式
    * | Class.forName("全类名") | 通过指定的字符串路径获取     | 多用于配置文件，将类名定义在配置文件中。读取文件，加载类 |
    *| 类名.class              | 通过类名的属性class获取      | 多用于参数的传递
     *| 对象.getClass()         | 通过对象的getClass()方法获取 | 多用于对象的获取字节码的方式                             |
    * */

    public static void main(String[] args) throws Exception{
//        Student student=new Student();
//        Class aClass = student.getClass();
//        System.out.println("1"+aClass);
//        Class studentClass = Student.class;
//        System.out.println("2"+studentClass);
        Class aClass1 = Class.forName("com.javaclass.Student");
        System.out.println("3"+aClass1);

//        1. Constructor[] getConstructors()  获取所有的public修饰的构造方法
//        2. Constructor getConstructor(Class... parameterTypes)  根据参数类型获取构造方法对象，只能获得public修饰的构造方法。
//        ```java
//1. T newInstance(Object... initargs)根据指定参数创建对象。
//2. T newInstance()空参构造方法创建对象。
        //获取无参数构造方法
        Constructor constructor=aClass1.getConstructor();
        //运行构造方法
        Object o = constructor.newInstance();
        System.out.println(o);

        //获取有参数构造方法
        Constructor constructor1 = aClass1.getConstructor(String.class, int.class);
        //运行构造方法，传递实际参数
        Object object = constructor1.newInstance("张三",20);
        System.out.println(object);

//        Class类中定义了方法 `T newInstance()`，可以直接运行获取到的构造方法
//        **要求**：被反射的类中必须有public权限的无参数构造方法。

        Object object1 = aClass1.newInstance();
        System.out.println(object1);

//        1. Method[] getMethods() 获取所有的public修饰的成员方法，包括父类中。
//        2.Method getMethod("方法名", 方法的参数类型... 类型) 根据方法名和参数类型获得一个方法对象，只能是获取public修饰的

//        Object invoke(Object obj, Object... args)
//      返回值Object，表示调用方法后，该方法的返回值
//  	根据参数args调用对象obj的该成员方法
//  	如果obj=null，则表示该方法是静态方法

        //获取study方法
        Method method = aClass1.getMethod("study");
        //执行方法，传递对象
        method.invoke(object1);

        //获取有参数的方法eat
        Method method1 = aClass1.getMethod("eat",String.class,double.class);
        //调用eat方法，传递实际参数
        method1.invoke(object,"吃饭",9.9);










    }
}
@Data
/*
*
* @Data
使用这个注解，就不用再去手写Getter,Setter,equals,canEqual,hasCode,toString等方法了，注解后在编译时会自动加进去。
@AllArgsConstructor
使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor
使用后创建一个无参构造函数
@Builder
关于Builder较为复杂一些，Builder的作用之一是为了解决在某个类有很多构造函数的情况，也省去写很多构造函数的麻烦，
* 在设计模式中的思想是：用一个内部类去实例化一个对象，避免一个类出现过多构造函数，
*
* */

class Student{
    @Getter
    @Setter
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public  void study(){
        System.out.println("学生在学习");
    }
    public void eat(String s,double d){
        System.out.println("带参数方法:"+s+"::"+d);
    }

}
