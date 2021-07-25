package com.javanet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;

/**
 * @description:
 * @author:dt
 * @date: 2021/7/25 10:43
 */
public class demo1 {
//    网络编程三要素
//    - **协议：**计算机网络通信必须遵守的规则
//     **IP地址：指互联网协议地址（Internet Protocol Address）**，俗称IP。
//     IP地址用来给一个网络中的计算机设备做唯一的编号。假如我们把“个人电脑”比作“一台电话”的话，那么“IP地址”就相当于“电话号码”。
//    *端口号：用两个字节表示的整数，它的取值范围是0~65535**。其中，0~1023之间的端口号用于一些知名的网络服务和应用，
//    普通的应用程序需要使用1024以上的端口号。如果端口号被另外一个服务或应用所占用，会导致当前程序启动失败。


//    `Socket` 类：该类实现客户端套接字，套接字指的是两台设备之间通讯的端点。

//    客户端向服务器发送数据--客户端程序
public static void main(String[] args) throws IOException {
    System.out.println("客户端发送数据");
    // 1.创建 Socket ( ip , port ) , 确定连接到哪里.
    Socket client=new Socket("localhost",6666);
    // 2.获取流对象 . 输出流
    OutputStream outputStream=client.getOutputStream();
//    3,写出数据
    outputStream.write("你好吗,tcp,我来了".getBytes());
    // ==============解析回写=========================
    // 4. 通过Scoket,获取 输入流对象
    InputStream inputStream=client.getInputStream();
    // 5. 读取数据数据
    byte[] b = new byte[100];
    int len = inputStream.read(b);
    System.out.println(new String(b, 0, len));
//    4. 关闭资源 .
    inputStream.close();
    outputStream.close();
    client.close();
}
}
class ServerTcp{
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动,等待连接");
//        1.创建ServerSocket对象,绑定端口，开始等待连接
        ServerSocket serverSocket=new ServerSocket(6666);
        // 2.接收连接 accept 方法, 返回 socket 对象.
        Socket socket=serverSocket.accept();
        // 3.通过socket 获取输入流
        InputStream inputStream=socket.getInputStream();
        // 4.一次性读取数据
        // 4.1 创建字节数组
        byte [] b=new byte[1024];
        // 4.2 据读取到字节数组中.
        int len=inputStream.read(b);
        // 4.3 解析数组,打印字符串信息
        String s = new String(b, 0, len);
        System.out.println("--------");
        System.out.println(s);
        // =================回写数据=======================
        // 5. 通过 socket 获取输出流
        OutputStream out = socket.getOutputStream();
        // 6. 回写数据
        out.write("我很好,谢谢你".getBytes());
        //5.关闭资源.
        out.close();
        inputStream.close();
        socket.close();
    }
}

/*
* 客户端】输入流，从硬盘读取文件数据到程序中。
2. 【客户端】输出流，写出文件数据到服务端。
3. 【服务端】输入流，读取文件数据到服务端程序。
4. 【服务端】输出流，写出文件数据到服务器硬盘中。

5. 【服务端】获取输出流，回写数据。
6. 【客户端】获取输入流，解析回写数据。
*
* */
class FileClient{
    public static void main(String[] args) throws IOException {
        // 1.创建流对象
        // 1.1 创建输入流,读取本地文件
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("test.jpg"));
        // 1.2 创建输出流,写到服务端
        Socket socket=new Socket("localhost",6666);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
        //2.写出数据.
        byte[] b=new byte[1024*8];
        int len;
        while ((len=bufferedInputStream.read(b))!=-1){
            bufferedOutputStream.write(b,0,len);
        }
        // 关闭输出流,通知服务端,写出数据完毕
        socket.shutdownOutput();
        System.out.println("文件发送完毕");
        // 3. =====解析回写============
        InputStream inputStream=socket.getInputStream();
        byte[] back=new byte[20];
        inputStream.read(back);
        System.out.println(new String(back));
        inputStream.close();
        // 4.释放资源
        socket.close();
        bufferedInputStream.close();
    }
}
class FileServer{
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动.....  ");
        // 1. 创建服务端ServerSocket
        ServerSocket serverSocket=new ServerSocket(6666);
        // 2. 循环接收,建立连接
        Socket accept = serverSocket.accept();
        /*
         *3. socket对象进行读写操作
         */
        //3.1 获取输入流对象
        BufferedInputStream bufferedInputStream=new BufferedInputStream(accept.getInputStream());
        //3.2 创建输出流对象, 保存到本地 .
        FileOutputStream fileOutputStream=new FileOutputStream(System.currentTimeMillis()+".jpg");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        // 3.3 读写数据
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len=bufferedInputStream.read(b))!=-1){
            bufferedOutputStream.write(b, 0, len);
        }
        // 4.=======信息回写===========================
        System.out.println("back ........");
        OutputStream outputStream=accept.getOutputStream();
        outputStream.write("上传成功".getBytes());
        outputStream.close();
        //================================
        //5. 关闭 资源
        bufferedInputStream.close();
        bufferedOutputStream.close();
        accept.close();
        System.out.println("文件上传已保存");

    }
}