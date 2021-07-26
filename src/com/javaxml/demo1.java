package com.javaxml;

import lombok.Data;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/26 9:44
 */
public class demo1 {
    public static void main(String[] args) {
        Color1 color1 = Color1.GREEN;
        System.out.println(color1);



    }
}



 enum Color1{
    //枚举静态常量，直接为变量color赋值
    RED("红色"),GREEN("绿色"),YELLOW("黄色");
    private String color;
    private Color1(String color){
        this.color = color ;
    }
    //省略get/set
}