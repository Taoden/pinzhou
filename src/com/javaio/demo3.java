package com.javaio;

import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/24 10:16
 */
public class demo3 {
    public static void main(String[] args) throws IOException {
//        byte[]  bytes = "你".getBytes("UTF-8");
//        System.out.println(Arrays.toString(bytes));
//
//        bytes = "你".getBytes("GBK");
//        System.out.println(Arrays.toString(bytes));
        // 定义文件路径
//        String FileName = "out.txt";
//        // 创建流对象,默认UTF8编码
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileName));
//        // 写出数据
//        osw.write("你好"); // 保存为6个字节
//        osw.flush();
//        osw.close();

        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");

        //写出单个字符
        fw.write(97);
        fw.flush();

        //写出字符数组
        char[] chs = "ABCDED".toCharArray();
        fw.write(chs);
        fw.flush();
    }
}
