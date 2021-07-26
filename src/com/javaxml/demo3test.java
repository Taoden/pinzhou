package com.javaxml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @description:
 * @author: dt
 * @date: 2021/7/26 10:00
 */
public class demo3test {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader=new SAXReader();
        String file = demo3test.class.getClassLoader().getResource("demo3.xml").getFile();
        File file1=new File(file);
        Document document=saxReader.read(file);
        //4.结合xpath语法查询
        //4.1查询所有student标签
        List<Node> nodes=document.selectNodes("//student");
        for (Node node : nodes) {
            System.out.println(node);
        }
        System.out.println("----------");
        //4.2查询所有student标签下的name标签
        nodes=document.selectNodes("//student/name");
        for (Node node : nodes) {
            System.out.println(node);
        }
        System.out.println("--------------------");
        //4.3查询student标签下带有id属性的name标签
        nodes=document.selectNodes("//studnet/name[@id]");
        for (Node node : nodes) {
            System.out.println(node);
        }
        System.out.println("--------------------");
        //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
        nodes = document.selectNodes("//student/name[@id='itcast']");
        for (Node node : nodes) {
            System.out.println(node);
        }
    }
}
