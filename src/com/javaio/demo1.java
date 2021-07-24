package com.javaio;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/24 9:23
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
//        文件路径名
//        String pathname="D:\\\\aaa.txt";
//        File file=new File(pathname);
//        System.out.println(file);

//        通过父路径和子路径字符串
//        String parent = "d:\\aaa";
//           String child="bbb.txt";
//           File file1=new File(parent,child);
//        System.out.println(file1);

//        File f = new File("d:/aaa/bbb.java");
//        System.out.println("文件绝对路径:"+f.getAbsolutePath());
//        File f = new File("D:\\bbb.java");
//        System.out.println(f.getAbsolutePath());
//
//        File f = new File("d:\\aaa\\bbb.java");
//        File f2 = new File("d:\\aaa");
//        System.out.println("d:\\aaa\\bbb.java 是否存在:"+f.exists());

//        // 文件的创建
//        File f = new File("aaa.txt");
//        System.out.println("是否存在:"+f.exists()); // false
////        System.out.println("是否创建:"+f.createNewFile()); // true
//        System.out.println("是否存在:"+f.exists()); // true
//
//
//        // 目录的创建
//        File f2= new File("newDir");
//        System.out.println("是否存在:"+f2.exists());// false
////        System.out.println("是否创建:"+f2.mkdirs());// true
//        System.out.println("是否存在:"+f2.exists());// true
//
//        // 文件的删除
//        System.out.println(f.delete());// true
//
//        // 目录的删除
//        System.out.println(f2.delete());// true

        File dir =new File("D:\\image");
        File [] files=dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith("java");
            }
        });
        for (File file : files) {
            System.out.println(file);
        }


        int num=5;
        int sum = getSum(num);
        System.out.println(sum);


        File file1 =new File("D:\\image");
        printDir(file1);





    }

    public static void printDir(File file1) {
        System.out.println(file1);
        // 获取子文件和目录
        File[] files = file1.listFiles();
        // 循环打印
        for (File file : files) {
            //判断是文件，直接输出
            if (file.isFile()) {
                System.out.println(file);
            } else {
                // 是目录，继续遍历,形成递归
                printDir(file);
            }
        }
    }

    public static int  getSum(int num) {
        if(num==1){
            return 1;
        }
        return num+getSum(num-1);
//        5+4+3+2+1
    }
}
