package com.javalocal;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 14:03
 */
public class demo4 {
    public static void main(String[] args) {
//        最大值获取：从数组的所有元素中找出最大值。
//实现思路：
//定义变量，保存数组0索引上的元素
//遍历数组，获取出数组中的每个元素
//将遍历到的元素和保存数组0索引上值的变量进行比较
//如果数组元素的值大于了变量的值，变量记录住新的值
//数组循环遍历结束，变量保存的就是数组中的最大值

        //定义数组
         int[] arr = {12, 45, 98, 73, 60};
        // 定义一个变量，用于保存最大值
        // 取数组中第一个数据作为变量的初始值
         int max = arr[0];
        // 与数组中剩余的数据逐个比对，每次比对将最大值保存到变量中
         for(int x=1; x<arr.length; x++) {
         if(arr[x] > max) { max = arr[x];
           }
        }
    //循环结束后打印变量的值
        System.out.println("max:" + max);




    }
}
