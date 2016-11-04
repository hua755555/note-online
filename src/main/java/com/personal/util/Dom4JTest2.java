package com.personal.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

/**
 * dom4j框架学习： 读取并解析xml
 * 
 * 
 */
public class Dom4JTest2
{
    public static void main(String[] args) throws Exception
    {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new File("road.xml"));

        // 获取根元素
        Element root = document.getRootElement();
        System.out.println("Root: " + root.getName());

        // 获取所有子元素
        List<Element> childList = root.elements();
        System.out.println("total child count: " + childList.size());

        // 获取特定名称的子元素
        List<Element> childList2 = root.elements("Row");
        System.out.println("hello child: " + childList2.size());

        // 获取名字为指定名称的第一个子元素
        Element firstWorldElement = root.element("Row");
        // 输出其属性
        System.out.println("first World Attr: "
                + firstWorldElement.attribute(0).getName() + "="
                + firstWorldElement.attributeValue("roadName"));

        System.out.println("迭代输出-----------------------");
        // 迭代输出
        for (Iterator iter = root.elementIterator("Row"); iter.hasNext();)
        {
            Element e = (Element) iter.next();
            System.out.println(e.attributeValue("roadName"));
            System.out.println(e.attributeValue("roadLevel"));
            System.out.println(e.attributeValue("currentSpeed"));
            System.out.println(e.attributeValue("diff"));
            System.out.println(e.attributeValue("lastHourAvgSpeed"));
            System.out.println(e.attributeValue("lastWeekAvgSpeed"));
            System.out.println(e.attributeValue("color"));

        }

    }

}

