package com.javaclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @description: 注解
 * @author: dt
 * @date: 2021/7/26 9:19
 *
 */

public class demo3 {
//    - @Test，用于修饰需要执行的测试方法。
//            - @Before，修饰的方法会在测试方法之前被自动执行。
//            - @After，修饰的方法会在测试方法执行之后自动被执行。
//            - @After，修饰的方法会在测试方法执行之后自动被执行。

//      1. **@author**：用来标识作者名
//      2. **@version**：用于标识对象的版本号，适用范围：文件、类、方法。
//      3. **@Override** ：用来修饰方法声明，告诉编译器该方法是重写父类中的方法，如果父类不存在该方法，则编译失败。




//    使用自定义注解
//      1. 获取注解定义的位置的对象  （Class，Method,Field）
//      2. 获取指定的注解 `getAnnotation(Class)`
//      3. 调用注解中的抽象方法获取配置的属性值
//    使用：@注解名(属性名=属性值,属性名=属性值,属性名=属性值...)

    @Test
    @Book(value = "西游记",authors = {"吴承恩,嘟嘟"})
    public void showBook(){

    }


    public static void main(String[] args) {
//        - 如注解作用在方法上，就通过方法(Method)对象得到它的注解。
// // 得到方法对象
//   Method method = clazz.getDeclaredMethod("方法名");
//   // 根据注解名得到方法上的注解对象
//   Book book = method.getAnnotation(Book.class);

//         如注解作用在类上，就通过Class对象得到它的注解。
//         // 获得Class对象
//  Class c = 类名.class;
//  // 根据注解的Class获得使用在类上的注解对象
//  Book book = c.getAnnotation(Book.class);



    }



}

@interface Book {
    // 书名
    String value();
    // 价格
    double price() default 100;
    // 多位作者
    String[] authors();
}






//    自定义注解
//    元注解
// **@Target**   **作用：指明此注解用在哪个位置，如果不写默认是任何地方都可以使用。**
// TYPE： 用在类,接口上
//         FIELD：用在成员变量上
//         METHOD： 用在方法上
//         PARAMETER：用在参数上
//         CONSTRUCTOR：用在构造方法上
//         LOCAL_VARIABLE：用在局部变量上
//- **@Retention**    作用：定义该注解的生命周期(有效范围)。**
//SOURCE：注解只存在于Java源代码中，编译生成的字节码文件中就不存在了。
//CLASS：注解存在于Java源代码、编译以后的字节码文件中，运行的时候内存中没有，默认值。
//RUNTIME：注解存在于Java源代码中、编译以后的字节码文件中、运行时内存中，程序可以通过反射获取该注解。


//注解解析
//- **Anontation**：所有注解类型的公共接口，类似所有类的父类是Object
//- **AnnotatedElement**：定义了与注解解析相关的方法，常用方法以下四个：
//boolean isAnnotationPresent(Class annotationClass); 判断当前对象是否有指定的注解，有则返回true，否则返回false。
//T getAnnotation(Class<T> annotationClass);  获得当前对象上指定的注解对象。
//Annotation[] getAnnotations(); 获得当前对象及其从父类上继承的所有的注解对象。
//Annotation[] getDeclaredAnnotations();获得当前对象上所有的注解对象，不包括父类的。



//public @interface 注解名称{
//	属性列表;
//}


//任何一个注解，都默认的继承Annotation接口。
@interface MyAnno {
//注解的属性
//    作用
//    可以让用户在使用注解时传递参数，让注解的功能更加强大
//    属性的格式
//    **格式1：数据类型 属性名();**
//   - **格式2：数据类型 属性名() default 默认值;**



}
@interface Student2 {
    String name(); // 姓名
    int age() default 18; // 年龄
    String gender() default "男"; // 性别
}