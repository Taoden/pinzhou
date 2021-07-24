package com.javalocal;

import java.util.Scanner;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 22:07
 */
public class demo8 {
    public static void main(String[] args) {
        //public String()：创建一个空白字符串对象，不含有任何内容
         String s1 = new String();
         System.out.println("s1:" + s1);
        // public String(char[] chs)：根据字符数组的内容，来创建字符串对象
         char[] chs = {'a', 'b', 'c'};
         String s2 = new String(chs);
         System.out.println("s2:" + s2);
        // public String(byte[] bys)：根据字节数组的内容，来创建字符串对象
         byte[] bys = {97, 98, 99};
         String s3 = new String(bys);
         System.out.println("s3:" + s3);
        // String s = “abc”; 直接赋值的方式创建字符串对象，内容就是abc
         String s4 = "abc";
         System.out.println("s4:" + s4);

        /* 思路：1:已知用户名和密码，定义两个字符串表示即可
         2:键盘录入要登录的用户名和密码，用 Scanner 实现
         3:拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。字符串的内容比较，用 equals() 方法实现
         4:用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环 */
        //已知用户名和密码，定义两个字符串表示即可
         String username = "itheima"; String password = "czbk";
        // 用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环
         for(int i=0; i<3; i++) {
        // 键盘录入要登录的用户名和密码，用 Scanner 实现
         Scanner sc = new Scanner(System.in);
         System.out.println("请输入用户名：");
         String name = sc.nextLine();
         System.out.println("请输入密码：");
         String pwd = sc.nextLine();
        // 拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。字符串的内容比较， 用equals() 方法实现
             if (name.equals(username) && pwd.equals(password)) {
                 System.out.println("登录成功");
                 break;
             } else {
                 if(2-i == 0) {
                     System.out.println("你的账户被锁定，请与管理员联系");
                 } else {
                     //2,1,0 //i,0,1,2
                      System.out.println("登录失败，你还有" + (2 - i) + "次机会"); }
             }
                 }

        /*思路： 1:键盘录入一个字符串，用 Scanner 实现
         2:要统计三种类型的字符个数，需定义三个统计变量，初始值都为0
         3:遍历字符串，得到每一个字符
         4:判断该字符属于哪种类型，然后对应类型的统计变量+1 假如ch是一个字符，我要判断它属于大写字母，小写字母，还是数字，直接判断该字符是否在对应的范 围即可 大写字母：ch>='A' && ch<='Z' 小写字母： ch>='a' && ch<='z' 数字： ch>='0' && ch<='9'
         5:输出三种类型的字符个数 */

        //键盘录入一个字符串，用 Scanner 实现
         Scanner sc = new Scanner(System.in);
         System.out.println("请输入一个字符串：");
         String line = sc.nextLine();
        // 要统计三种类型的字符个数，需定义三个统计变量，初始值都为0
         int bigCount = 0;
         int smallCount = 0;
         int numberCount = 0;
        // 遍历字符串，得到每一个字符
         for(int i=0; i<line.length(); i++) {
         char ch = line.charAt(i);
        // 判断该字符属于哪种类型，然后对应类型的统计变量+1
         if(ch>='A' && ch<='Z') {
         bigCount++;
         } else if(ch>='a' && ch<='z') {
         smallCount++;
         } else if(ch>='0' && ch<='9') {
         numberCount++;
         }
         }
        // 输出三种类型的字符个数
         System.out.println("大写字母：" + bigCount + "个");
         System.out.println("小写字母：" + smallCount + "个");
         System.out.println("数字：" + numberCount + "个");


        /* 思路：1:定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        2:定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。 返回值类型 String，参数列表 int[] arr
        3:在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        4:调用方法，用一个变量接收结果
        5:输出结果 */

        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
         int[] arr = {1, 2, 3};
        // 调用方法，用一个变量接收结果
         String s = arrayToString(arr);
        // 输出结果
         System.out.println("s:" + s);


    /* 思路：1:键盘录入一个字符串，用 Scanner 实现
    2:定义一个方法，实现字符串反转。返回值类型 String，参数 String s
    3:在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
    4:调用方法，用一个变量接收结果 5:输出结果 */
        //键盘录入一个字符串，用 Scanner 实现
         Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line1 = sc1.nextLine();
        //调用方法，用一个变量接收结果
         String sone = myReverse(line);
         //输出结果
         System.out.println("s2:" + sone);



    }
    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    // /* 两个明确： 返回值类型：String 参数：int[] arr */
     public static String arrayToString(int[] arr) {
    // 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
     StringBuilder sb = new StringBuilder();
     sb.append("[");
     for(int i=0; i<arr.length; i++) {
     if(i == arr.length-1) {
     sb.append(arr[i]);
     } else {
     sb.append(arr[i]).append(", ");
     }
     }
     sb.append("]");
     String s = sb.toString();
     return s;
     }

    //定义一个方法，实现字符串反转。返回值类型 String，参数 String s
    // /* 两个明确： 返回值类型：String 参数：String s */
     public static String myReverse(String s) {
    // 在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
    // String --- StringBuilder --- reverse() --- String
    // StringBuilder sb = new StringBuilder(s);
    // sb.reverse();
    // String ss = sb.toString();
    // return ss;
     return new StringBuilder(s).reverse().toString();
    }



}
