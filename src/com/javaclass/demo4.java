package com.javaclass;

import lombok.*;
import org.junit.Test;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/26 9:34
 */
public class demo4 {
//1. 定义注解Book，要求如下：
//   - 包含属性：String value()   书名
//   - 包含属性：double price()  价格，默认值为 100
//   - 包含属性：String[] authors() 多位作者
//   - 限制注解使用的位置：类和成员方法上
//   - 指定注解的有效范围：RUNTIME
//2. 定义BookStore类，在类和成员方法上使用Book注解
//3. 定义TestAnnotation测试类获取Book注解上的数据
public static void main(String[] args) {
    System.out.println("---------获取类上注解的数据----------");

    /**
     * 获取BookStore类上使用的Book注解数据
     */
    // 获得BookStore类对应的Class对象
    Class c=BookStore.class;
    // 判断BookStore类是否使用了Book注解
    if(c.isAnnotationPresent(Book1.class)){
        // 根据注解Class对象获取注解对象
        Book1 book = (Book1) c.getAnnotation(Book1.class);
        // 输出book注解属性值
        System.out.println("书名：" + book.value());
        System.out.println("价格：" + book.price());
        System.out.println("作者：" + Arrays.toString(book.authors()));
    }

//    lombok常用注解
//    @Getter和@Setter
//    作用：生成成员变量的get和set方法。
//    写在成员变量上，指对当前成员变量有效。
//    写在类上，对所有成员变量有效。
//    注意：静态成员变量无效。
//
//    @ToString
//    作用：生成toString()方法。
//    注解只能写在类上。
//
//    @NoArgsConstructor和@AllArgsConstructor
//    @NoArgsConstructor：无参数构造方法。
//    @AllArgsConstructor：满参数构造方法。
//    注解只能写在类上。
//
//    @EqualsAndHashCode
//    作用：生成hashCode()和equals()方法。
//    注解只能写在类上。
//
//    @Data
//    作用：生成get/set，toString，hashCode，equals，无参构造方法
//    注解只能写在类上。
}





}
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Book1{
//    书名
    String value();
//    价格
    double price() default 100;
//    多位作者
    String[] authors();


}

@Book1(value = "红楼梦",authors = "曹雪芹",price = 998)
class BookStore{

}
