package com.javathread;

/**
 * @description: 实现线程的方法
 * @author: dt
 * @date: 2021/7/25 8:46
 */
public class demo1  extends Thread{
    public static void main(String[] args) {
//        进程：是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间，
//        一个应用程序可以同时运行多个进程；进程也是程序的一次执行过程，
//        是系统运行程序的基本单位；系统运行一个程序即是一个进程从创建、运行到消亡的过程。
//        线程：是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。
//        一个进程中是可以有多个线程的，这个应用程序也可以称之为多线程程序。
//
        //        2. 创建Thread子类的实例，即创建了线程对象
        demo1 demo=new demo1();
        //        3. 调用线程对象的start()方法来启动该线程
        demo.setName("嘟嘟");
        demo.start();
        for (int i = 0; i <200 ; i++) {
            System.out.println(Thread.currentThread().getName()+"main线程"+i);
        }
//    run()方法，是线程执行的任务方法，每个线程都会调用run()方法执行，
//    我们将线程要执行的任务代码都写在run()方法中就可以被线程调用执行。

//start()方法，开启线程，线程调用run()方法。
// start()方法源代码中会调用本地方法start0()来启动线程：private native void start0()，
// 本地方法都是和操作系统交互的，因此可以看出每次开启一个线程的线程都会和操作系统进行交互。
    //注意：一个线程只能被启动一次！！


    }
    //        1. 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务,因此把run()方法称为线程执行体。

    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
//            System.out.println("自定义线程正在执行"+i);
            System.out.println("线程名字"+i+" "+super.getName());
        }
    }



}
class test2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
            System.out.println(Thread.currentThread().getName()+"名称"+i);
        }
    }


    public static void main(String[] args) {
//        //创建自定义类对象  线程任务对象
//        test2 test=new test2();
//        //创建线程对象
//        Thread thread=new Thread(test);
//        thread.start();

//          实现Runnable接口比继承Thread类所具有的优势：
    //      适合多个相同的程序代码的线程去共享同一个资源。
    //      可以避免java中的单继承的局限性。
    //      增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。


//使用匿名内部类的方式实现Runnable接口，重新Runnable接口中的run方法：
        //---这个整体  相当于new MyRunnable
//        new Runnable(){
//            @Override
//            public void run() {
//                for (int i = 0; i <200 ; i++) {
//                    System.out.println(Thread.currentThread().getName()+i);
//                }
//            }
//        };

//        Runnable r=new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <200 ; i++) {
//                    System.out.println(Thread.currentThread().getName()+i);
//                }
//            }
//        };
        Runnable r= () -> {
            for (int i = 0; i <200 ; i++) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        };
        new Thread(r).start();





    }
}
