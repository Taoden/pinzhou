package com.javalocal;

import java.util.Random;
import java.util.Scanner;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 13:41
 */
public class demo3 {
    public static void main(String[] args) {
//        需求：一年有12个月，分属于春夏秋冬4个季节，键盘录入一个月份，请用程序实现判断该月份属于哪个季
//        节，并输出。

//        运行结果：
//        春：3、4、5
//        夏：6、7、8
//        秋：9、10、11
//        冬：1、2、12

        //键盘录入月份数据，使用变量接收
         Scanner sc = new Scanner(System.in);
         System.out.println("请输入一个月份：");
         int month = sc.nextInt();
        // case穿透
         switch(month) {
             case 1:
             case 2:
             case 12:
                 System.out.println("冬季");
                 break;
             case 3:
             case 4:
             case 5:
                 System.out.println("春季");
                 break;
             case 6:
             case 7:
             case 8:
                 System.out.println("夏季");
                 break;
             case 9:
             case 10:
             case 11:
                 System.out.println("秋季");
                 break;
             default:
                 System.out.println("你输入的月份有误");
         }


//         需求：在控制台输出1-5和5-1的数据

        //需求：输出数据1-5
         for(int i=1; i<=5; i++) {
             System.out.println(i);
         }
         System.out.println("--------");
        // 需求：输出数据5-1
         for(int i=5; i>=1; i--) {
             System.out.println(i);
         }

//         需求：求1-5之间的数据和，并把求和结果在控制台输出
        //求和的最终结果必须保存起来，需要定义一个变量，用于保存求和的结果，
        // 初始值为0
         int sum = 0;
        // 从1开始到5结束的数据，使用循环结构完成
         for(int i=1; i<=5; i++) {
        // 将反复进行的事情写入循环结构内部
             // 此处反复进行的事情是将数据 i 加到用于保存最终求和的变量 sum 中 sum += i;
             // /* sum += i;
              sum = sum + i;
             // 第一次：sum = sum + i = 0 + 1 = 1;
             // 第二次：sum = sum + i = 1 + 2 = 3;
             // 第三次：sum = sum + i = 3 + 3 = 6;
             // 第四次：sum = sum + i = 6 + 4 = 10;
             // 第五次：sum = sum + i = 10 + 5 = 15; */
              }
        //当循环执行完毕时，将最终数据打印出来
         System.out.println("1-5之间的数据和是：" + sum);


//         需求：求1-100之间的偶数和，并把求和结果在控制台输出 }

        //求和的最终结果必须保存起来，需要定义一个变量，用于保存求和的结果，
        // 初始值为0
         int sum1 = 0;
        // 对1-100的数据求和与1-5的数据求和几乎完全一样，仅仅是结束条件不同
         for(int i=1; i<=100; i++) {
        // 对1-100的偶数求和，需要对求和操作添加限制条件，判断是否是偶数
              if(i%2 == 0) {
                  sum1 += i;
              }
         }
             // 当循环执行完毕时，将最终数据打印出来
              System.out.println("1-100之间的偶数和是：" + sum1);


//         需求：在控制台输出所有的“水仙花数”
//解释：什么是水仙花数？
//水仙花数，指的是一个三位数，个位、十位、百位的数字立方和等于原数
//例如 153 3*3*3 + 5*5*5 + 1*1*1 = 153
//思路：
//1. 获取所有的三位数，准备进行筛选，最小的三位数为100，最大的三位数为999，使用for循环获取
//2. 获取每一个三位数的个位，十位，百位，做if语句判断是否是水仙花数

        //输出所有的水仙花数必然要使用到循环，遍历所有的三位数，三位数从100开始，到999结束
         for(int i=100; i<1000; i++) {
        // 在计算之前获取三位数中每个位上的值
              int ge = i%10;
             int shi = i/10%10;
             int bai = i/10/10%10;
             //判定条件是将三位数中的每个数值取出来，计算立方和后与原始数字比较是否相等
              if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i) {
             // 输出满足条件的数字就是水仙花数
              System.out.println(i);
              }
         }


//        需求：统计“水仙花数”一共有多少个，并在控制台输出个数
        //定义变量count，用于保存“水仙花数”的数量，初始值为0
         int count = 0;
        for(int i=100; i<1000; i++) {
            // 在计算之前获取三位数中每个位上的值
            int ge = i%10;
            int shi = i/10%10;
            int bai = i/10/10%10;
            //在判定水仙花数的过程中，满足条件不再输出，更改为修改count的值，使count+1
            if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i) {
                // 输出满足条件的数字就是水仙花数
                count++;
                System.out.println(i);
            }
        }
        //打印输出最终结果
         System.out.println("水仙花共有：" + count + "个");
//        今后如果需求带有统计xxx，请先想到计数器变量
//         计数器变量定义的位置，必须在循环外部


//需求：世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，假如我有一张足够大的纸，它的厚度是0.1毫
//米。请问，我折叠多少次，可以折成珠穆朗玛峰的高度?

        //定义一个计数器，初始值为0
         int count1 = 0;
        // 定义纸张厚度
         double paper = 0.1;
        // 定义珠穆朗玛峰的高度
        int zf = 8844430;
        //因为要反复折叠，所以要使用循环，但是不知道折叠多少次，这种情况下更适合使用while循环
        // 折叠的过程中当纸张厚度大于珠峰就停止了，因此继续执行的要求是纸张厚度小于珠峰高度
         while(paper <= zf) {
             // 循环的执行过程中每次纸张折叠，纸张的厚度要加倍
             paper *= 2;
             // 在循环中执行累加，对应折叠了多少次
             count1++;
             // }
             // 打印计数器的值
             System.out.println("需要折叠：" + count + "次");
         }


//         循环嵌套概述：在循环中，继续定义循环
        //外循环控制小时的范围，内循环控制分钟的范围
         for (int hour = 0; hour < 24; hour++) {
                for (int minute = 0; minute < 60; minute++) {
                        System.out.println(hour + "时" + minute + "分");
                     }
         System.out.println("--------");
             }

//         请反复理解这句话（整个内循环，就是外循环的一个循环体，内部循环体没有执行完毕，外循环是不会
//          继续向下执行的）
//        结论：
//          外循环执行一次，内循环执行一圈


//        需求：
//  程序自动生成一个1-100之间的数字，使用程序实现猜出这个数字是多少？
//当猜错的时候根据不同情况给出相应的提示
//A. 如果猜的数字比真实数字大，提示你猜的数据大了
//B. 如果猜的数字比真实数字小，提示你猜的数据小了
//C. 如果猜的数字与真实数字相等，提示恭喜你猜中了

        //要完成猜数字的游戏，首先需要有一个要猜的数字，使用随机数生成该数字，范围1到100
         Random r = new Random();
         int number = r.nextInt(100) + 1;
         while(true) {
             // 使用程序实现猜数字，每次均要输入猜测的数字值，需要使用键盘录入实现
             Scanner sc3 = new Scanner(System.in);
             System.out.println("请输入你要猜的数字：");
             int guessNumber = sc3.nextInt();
             // 比较输入的数字和系统产生的数据，需要使用分支语句。
             // 这里使用if..else..if..格式，根据不同情况进行猜测结果显示
             if (guessNumber > number) {
                 System.out.println("你猜的数字" + guessNumber + "大了");
             } else if (guessNumber < number) {
                 System.out.println("你猜的数字" + guessNumber + "小了");
             } else {
                 System.out.println("恭喜你猜中了");
                 break;
             }

         }


    }
}
