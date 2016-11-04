package com.personal.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.personal.model.other.CarBrand;
import com.personal.model.other.CarFactory;
import com.personal.model.other.CarSeries;
import com.personal.service.RoadConditionService;
import com.personal.util.http.HttpRequestUtil;

@Controller
@RequestMapping("/road")
public class RoadConditionController extends BaseController{
	@Autowired
	RoadConditionService roadConditionService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void car(HttpServletRequest request,HttpServletResponse response,
			@RequestBody List<CarBrand> brands){
		System.out.println("hello world");
//		roadConditionService.save();
//		com.personal.util.http.HttpRequestUtil.httpGet(url)
	}
	
	
	public static void main(String[] args) {
		Long id =140l;
		String str =HttpRequestUtil.httpGet("http://www.hzjtydzs.com/web/xmlsvc/currentRoadSpeed.aspx?rank=粗粒度&order=asc&areaid=小区");
		System.out.println(str);
		try {
			Document document = DocumentHelper.parseText(str);
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

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
}

