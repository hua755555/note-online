package com.personal.service.impl;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;

import com.personal.service.RoadConditionService;



@Service("roadConditionService")
public class RoadConditionServiceImpl implements RoadConditionService{
	
	public void doSave(Long bId) {
		
		 // 定义工厂API 使应用程序能够从XML文档获取生成DOM对象树的解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 获取此类的实例之后，将可以从各种输入源解析XML
//        DocumentBuilder builder = factory.newDocumentBuilder();
//		Document document = builder.parse(this.getClass().getResourceAsStream(
//            "/" + fileName));
		String url = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+bId;
		
	}

}
