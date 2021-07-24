package com.javalocal;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 14:04
 */
public class demo5 {
    public static void main(String[] args) {
//            总结：每个方法在被调用执行的时候，都会进入栈内存，并且拥有自己独立的内存空间，方法内部代码调用
//            完毕之后，会从栈内存中弹栈消失。

//        需求：设计一个方法用于打印两个数中的较大数
        //思路：
        //①定义一个方法，用于打印两个数字中的较大数，例如getMax()
        //②方法中定义两个变量，用于保存两个数字
        //③使用分支语句分两种情况对两个数字的大小关系进行处理
        //④在main()方法中调用定义好的方法
//在main()方法中调用定义好的方法
        getMax();

        //在main()方法中调用定义好的方法（使用常量）
        getMax(10, 20);
        // 调用方法的时候，人家要几个，你就给几个，人家要什么类型的，你就给什么类型的
//         getMax(30);
//         getMax(10.0,20.0);
        // 在main()方法中调用定义好的方法（使用变量）
        int a = 10;
        int b = 20;
        getMax(a, b);


//             方法参数传递基本类型
        int number = 100;
        System.out.println("调用change方法前：" + number);
        change(number);
        System.out.println("调用change方法后：" + number);
//        结果均为100

//        结论：
//          基本数据类型的参数，形式参数的改变，不影响实际参数
//      结论依据：
//          每个方法在栈内存中，都会有独立的栈空间，方法运行结束后就会弹栈消失


//        方法参数传递引用类型
        int[] arr = {10, 20, 30};
        System.out.println("调用change方法前：" + arr[1]);
        change(arr);
        System.out.println("调用change方法后：" + arr[1]);
//        20  2000

//        结论：
//          对于引用类型的参数，形式参数的改变，影响实际参数的值
//        结论依据：
//          引用数据类型的传参，传入的是地址值，内存中会造成两个引用指向同一个内存的效果，所以即使方法
//          弹栈，堆内存中的数据也已经是改变后的结果


//        需求：设计一个方法用于数组遍历，要求遍历的结果是在一行上的。例如：[11, 22, 33, 44, 55]
//      思路：
        //①因为要求结果在一行上输出，所以这里需要在学习一个新的输出语句System.out.print(“内容”);
        //System.out.println(“内容”); 输出内容并换行
        //System.out.print(“内容”); 输出内容不换行
        //System.out.println(); 起到换行的作用
        //②定义一个数组，用静态初始化完成数组元素初始化
        //③定义一个方法，用数组遍历通用格式对数组进行遍历
        //④用新的输出语句修改遍历操作
        //⑤调用遍历方法
        //定义一个数组，用静态初始化完成数组元素初始化
        int[] arr1 = {11, 22, 33, 44, 55};
        // 调用方法
        printArray(arr1);



//        需求：设计一个方法用于获取数组中元素的最大值
            //思路：
            //①定义一个数组，用静态初始化完成数组元素初始化
            //②定义一个方法，用来获取数组中的最大值，最值的认知和讲解我们在数组中已经讲解过了
            //③调用获取最大值方法，用变量接收返回结果
            //④把结果输出在控制台

        //定义一个数组，用静态初始化完成数组元素初始化
         int[] arr2 = {12, 45, 98, 73, 60};
        // 调用获取最大值方法，用变量接收返回结果
         int number1 = getMax(arr2);
        // 把结果输出在控制台
         System.out.println("number:" + number1);

    }

    //    //定义一个方法，用数组遍历通用格式对数组进行遍历 /*
//    两个明确： 返回值类型：void
//    参数：int[] arr */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.println("]");
    }


    //定义一个方法，用来获取数组中的最大值
    // /* 两个明确： 返回值类型：int 参数：int[] arr */
     public static int getMax(int[] arr) {
     int max = arr[0];
     for(int x=1; x<arr.length; x++) {
     if(arr[x] > max) { max = arr[x];
                 }
            }
     return max;
     }




    public static void change(int number) { number = 200; }

    public static void change(int[] arr) { arr[1] = 200; }

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
     public static void getMax() {
         // 方法中定义两个变量，用于保存两个数字
         int a = 10;
         int b = 20;
         //使用分支语句分两种情况对两个数字的大小关系进行处理
         if(a > b) {
             System.out.println(a);
         } else {
             System.out.println(b);
         }
     }

//     需求：设计一个方法用于打印两个数中的较大数，数据来自于方法参数 }
        //思路：
        //①定义一个方法，用于打印两个数字中的较大数，例如getMax()
        //②为方法定义两个参数，用于接收两个数字
        //③使用分支语句分两种情况对两个数字的大小关系进行处理
        //④在main()方法中调用定义好的方法（使用常量）
        //⑤在main()方法中调用定义好的方法（使用变量）

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
    // 为方法定义两个参数，用于接收两个数字
     public static void getMax(int a, int b) {
    // 使用分支语句分两种情况对两个数字的大小关系进行处理
     if(a > b) {
     System.out.println(a);
     } else {
     System.out.println(b);
        }
     }

//     方法不能嵌套定义
//    void表示无返回值，可以省略return，也可以单独的书写return，后面不加数据




}
