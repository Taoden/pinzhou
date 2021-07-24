package com.javalocal;

import java.util.Scanner;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 13:32
 */
public class demo2 {
    public static void main(String[] args) {
        int x = 10;
        int y = x++ + x++ + x++;
        System.out.println(y);
        // y的值是多少？ /*解析，三个表达式都是++在后，所以每次使用的都是自增前的值，
        // 但程序自左至右执行，所以第一次自增时，使用的是 10进行计算，但第二次自增时，x的值已经自增到11了，
        // 所以第二次使用的是11，然后再次自增。。。 所以整个式子应该是：int y = 10 + 11 + 12; 输出结果为33。
        // */注意：通过此练习深刻理解自增和自减的规律，但实际开发中强烈建议不要写这样的代码！小心挨打！


//        1、需求：动物园里有两只老虎，已知两只老虎的体重分别为180kg、200kg，请用程序实现判断两只老虎的体重是
//          否相同。
        //1：定义两个变量用于保存老虎的体重，单位为kg，这里仅仅体现数值即可。
         int weight1 = 180; int weight2 = 200;
        // 2：用三元运算符实现老虎体重的判断，体重相同，返回true，否则，返回false。
         boolean b = weight1 == weight2 ? true : false;
        // 3：输出结果
         System.out.println("b:" + b);
//需求：一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm，请用程序实现获取这三个
//和尚的最高身高。

        //1：定义三个变量用于保存和尚的身高，单位为cm，这里仅仅体现数值即可。
         int height1 = 150; int height2 = 210; int height3 = 165;
        // 2：用三元运算符获取前两个和尚的较高身高值，并用临时身高变量保存起来。
         int tempHeight = height1 > height2 ? height1 : height2;
        // 3：用三元运算符获取临时身高值和第三个和尚身高较高值，并用最大身高变量保存。
         int maxHeight = tempHeight > height3 ? tempHeight : height3;
         //4：输出结果
         System.out.println("maxHeight:" + maxHeight);


        //身高未知，采用键盘录入实现。首先导包，然后创建对象。
         Scanner sc = new Scanner(System.in);
        // 键盘录入三个身高分别赋值给三个变量。
         System.out.println("请输入第一个和尚的身高：");
         int heightone = sc.nextInt();
         System.out.println("请输入第二个和尚的身高：");
         int heighttwo = sc.nextInt();
         System.out.println("请输入第三个和尚的身高：");
         int heightthree = sc.nextInt();
        // 用三元运算符获取前两个和尚的较高身高值，并用临时身高变量保存起来。
         int tempHeight1 = heightone > heighttwo ? heightone : heighttwo;
        // 用三元运算符获取临时身高值和第三个和尚身高较高值，并用最大身高变量保存。
         int maxHeight2 = tempHeight1 > heightthree ? tempHeight : heightthree;
        // 输出结果。
         System.out.println("这三个和尚中身高最高的是：" + maxHeight2 +"cm");


//         if语句案例：奇偶数
//需求：任意给出一个整数，请用程序实现判断该整数是奇数还是偶数，并在控制台输出该整数是奇数还是偶数。
//分析：
//①为了体现任意给出一个整数，采用键盘录入一个数据
//②判断整数是偶数还是奇数要分两种情况进行判断，使用if..else结构
//③判断是否偶数需要使用取余运算符实现该功能 number % 2 == 0
//④根据判定情况，在控制台输出对应的内容
        //为了体现任意给出一个整数，采用键盘录入一个数据。(导包，创建对象，接收数据)
         Scanner sc1 = new Scanner(System.in);
         System.out.println("请输入一个整数：");
         int number = sc1.nextInt();
        // 判断整数是偶数还是奇数要分两种情况进行判断，使用if..else结构
        // 判断是否偶数需要使用取余运算符实现该功能 number % 2 == 0
        // 根据判定情况，在控制台输出对应的内容
         if(number%2 == 0) {
             System.out.println(number + "是偶数");
         } else {
             System.out.println(number + "是奇数");
         }



//         if语句格式3案例：
//需求：小明快要期末考试了，小明爸爸对他说，会根据他不同的考试成绩，送他不同的礼物，假如你可以控制小明
//的得分，请用程序实现小明到底该获得什么样的礼物，并在控制台输出。
//分析：
//①小明的考试成绩未知，可以使用键盘录入的方式获取值
//②由于奖励种类较多，属于多种判断，采用if...else...if格式实现
//③为每种判断设置对应的条件
//④为每种判断设置对应的奖励


        //小明的考试成绩未知，可以使用键盘录入的方式获取值
         Scanner sc2 = new Scanner(System.in);
         System.out.println("请输入一个分数：");
         int score = sc2.nextInt();
        // 由于奖励种类较多，属于多种判断，采用if...else...if格式实现
        // 为每种判断设置对应的条件
        // 为每种判断设置对应的奖励
        // 数据测试：正确数据，边界数据，
        // 错误数据
         if(score>100 || score<0) {
             System.out.println("你输入的分数有误");
         } else if(score>=95 && score<=100) {
             System.out.println("山地自行车一辆");
         } else if(score>=90 && score<=94) {
             System.out.println("游乐场玩一次");
         } else if(score>=80 && score<=89) {
             System.out.println("变形金刚玩具一个");
         } else {
             System.out.println("胖揍一顿");
         }




    }
}
