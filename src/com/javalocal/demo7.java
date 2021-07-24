package com.javalocal;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 22:02
 */
public class demo7 {
    public static void main(String[] args) {
//
        //创建对象
        demo7 s = new demo7();
        // 使用对象
         System.out.println(s.name + "," + s.age);
        s.name = "林青霞";
        s.age = 30;
        System.out.println(s.name + "," + s.age);
        s.study();
        s.doHomework();

    }
//    需求：首先定义一个学生类，然后定义一个学生测试类，在学生测试类中通过对象完成成员变量和成员方法的使用
    //分析：
    //成员变量：姓名，年龄…
    //成员方法：学习，做作业…

    //成员变量
     String name;
     int age;
    // 成员方法
     public void study() {
     System.out.println("好好学习，天天向上");
     }
     public void doHomework() {
     System.out.println("键盘敲烂，月薪过万");
     }
}
