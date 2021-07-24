package com.javaio;

import java.io.*;

/**
 * @description: IO流
 * @author: dt
 * @date: 2021/7/24 9:53
 */
public class demo2 {
//     **输入流** ：把数据从`其他设备`上读取到`内存`中的流。
//-     **输出流** ：把数据从`内存` 中写出到`其他设备`上的流
//      - **字节流** ：以字节为单位，读写数据的流。
//      - **字符流** ：以字符为单位，读写数据的流。
public static void main(String[] args) throws IOException {
//    File file=new File("a.txt");
//    FileOutputStream fileOutputStream=new FileOutputStream(file);
//    FileOutputStream fileOutputStream=new FileOutputStream("a.txt",true);
////    fileOutputStream.write(97);
////    fileOutputStream.write(98);
////    fileOutputStream.write(99);
//    byte[] b="asdasdasda".getBytes();
//    fileOutputStream.write(b);
//    fileOutputStream.close();


//    FileInputStream fileInputStream=new FileInputStream("a.txt");
////    int b=0;
//    int len;
//    byte [] b=new byte[2];
//    while ((len=fileInputStream.read(b))!=-1){
//        System.out.println(new String(b) );
//    }
//    fileInputStream.close();

// 1.创建流对象
    // 1.1 指定数据源
//    FileInputStream fileInputStream=new FileInputStream("D:\\image\\a.jpg");
//    // 1.2 指定目的地
//    FileOutputStream fos = new FileOutputStream("test_copy.jpg");
//    // 2.读写数据
//    // 2.1 定义数组
//    byte[] b = new byte[1024];
//// 2.2 定义长度
//    int len;
//    // 2.3 循环读取
//    while ((len = fileInputStream.read(b))!=-1) {
//        // 2.4 写出数据
//        fos.write(b, 0 , len);
//    }
//    // 3.关闭资源
//    fos.close();
//    fileInputStream.close();

    // 创建字节缓冲输入流
//    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bis.txt"));
// 创建字节缓冲输出流
//    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));

    // 记录开始时间
    long start = System.currentTimeMillis();
    // 创建流对象

    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("jdk8.exe"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.exe"));
    // 读写数据
    int len = 0;
    byte[] bytes = new byte[8*1024];
    while ((len = bis.read(bytes)) != -1) {
        bos.write(bytes, 0 , len);
    }

    // 记录结束时间
    long end = System.currentTimeMillis();
    System.out.println("缓冲流使用数组复制时间:"+(end - start)+" 毫秒");
}
}
