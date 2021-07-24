package com.javaArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @description: 集合1
 * @author: dt
 * @date: 2021/7/23 8:51
 */
public class demo1 {
//    数组的弊端
//  - 数组长度是固定的，一旦创建不可修改。
//  - 需要添加元素，只能创建新的数组，将原数组中的元素进行复制。
//- 为了解决数组的定长问题，Java语言从JDK1.2开始出现集合框架。

    public static void main(String[] args) {
//集合和数组既然都是容器，它们有什么区别呢？
//
//- 数组的长度是固定的。集合的长度是可变的。
//- 数组中存储的是同一类型的元素，可以存储任意类型数据。集合存储的都是引用数据类型。如果想存储基本类型数据需要存储对应的包装类型

//        Collection
//        `java.util.List`和`java.util.Set`
//        java.util.ArrayList`和`java.util.LinkedList      java.util.HashSet`和`java.util.LinkedHashSet

//        使用多态方式创建对象
        Collection<String> collection=new ArrayList<>();
        collection.add("111");
        collection.add("1112");
        collection.add("1113");
//        使用迭代器遍历
        Iterator<String> iterator = collection.iterator();
//        判断是否有迭代元素
        while (iterator.hasNext()) {
//            获取迭代出的元素
            String next = iterator.next();
            System.out.println(next);

        }

//            结论
//             - 所有集合的迭代器，全由内部类实现。
//            - 集合中定义内部类，实现迭代器接口，可以使所有集合的遍历方式统一。
//            - 调用迭代器的方法hasNext()，next()均执行集合中内部类的重写方法。

//            在使用迭代器遍历集合中，不能使用集合本身的方法改变集合的长度，
//            一旦被改变将会抛出ConcurrentModificationException并发修改异常。


//            数据存储的常用结构有：栈、队列、数组、链表和红黑树。


//            List接口特点
//            - List集合是有序的集合，存储和取出的顺序一致。
//            - List集合允许存储重复的元素。
//            - List集合中的每个元素具有索引。


//            `java.util.ArrayList`集合数据存储的结构是数组结构。元素增删慢，查找快，线程不安全，运行速度快。

//            `java.util.LinkedList`集合数据存储的结构是链表结构。方便元素添加、删除的集合。
//集合特点：元素增删快，查找慢，线程不安全，运行速度快。
//            LinkedList是一个双向链表


            ArrayList<String>  pokerBox=new ArrayList<String>();
            ArrayList<String>  colors=new ArrayList<String>();
            ArrayList<String>  numbers=new ArrayList<String>();
            colors.add("♥");
            colors.add("♦");
            colors.add("♠");
            colors.add("♣");

            for (int i = 2; i <=10 ; i++) {
                    numbers.add(i+"");
            }
            numbers.add("J");
            numbers.add("Q");
            numbers.add("K");
            numbers.add("A");
            for (int i = 0; i < colors.size(); i++) {
                for (int i1 = 0; i1 < numbers.size(); i1++) {
                        String card=colors.get(i)+numbers.get(i1);
                        pokerBox.add(card);
                }
            }
            pokerBox.add("小☺");
            pokerBox.add("大☠");
            Collections.shuffle(pokerBox);
            ArrayList<String> player1 = new ArrayList<String>();
            ArrayList<String> player2 = new ArrayList<String>();
            ArrayList<String> player3 = new ArrayList<String>();
            ArrayList<String> dipai = new ArrayList<String>();
            for (int i = 0; i < pokerBox.size(); i++) {
                String card=pokerBox.get(i);
                if(i>=51){
                    dipai.add(card);
                }else {
                    if(i%3==0){
                        player1.add(card);
                    }else if(i%3==1){
                        player2.add(card);
                    }else {
                        player3.add(card);
                    }
                }
            }
            System.out.println("1"+player1);
            System.out.println("2"+player2);
            System.out.println("3"+player3);
            System.out.println(dipai);


        }
    }

