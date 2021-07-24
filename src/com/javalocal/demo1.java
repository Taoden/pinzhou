package com.javalocal;

/**
 * @description:
 * @author: dt
 * @date: 2021/6/25 13:28
 */
public class demo1 {
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
//        byte b3 = b1 + b2;
        // 第三行代码会报错，b1和b2会自动转换为int类型，计算结果为int，int赋值给byte需要强制类型转换。
        // 修改为: int num = b1 + b2; // 或者： byte b3 = (byte) (b1 + b2);
//        boolean类型不能与其他基本数据类型相互转换。
    }
}
