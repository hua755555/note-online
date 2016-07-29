package com.personal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.model.other.CarBrand;
import com.personal.service.BookService;
import com.personal.util.http.HttpRequestUtil;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController{
	
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public void getBook(HttpServletRequest request,HttpServletResponse response
			){
		String str = HttpRequestUtil.httpGet("view-source:http://www.bodani.cn/article/showlist.aspx?categ_id=0_01&v=12");
//		com.personal.util.http.HttpRequestUtil.httpGet(url)
	}
	
	
	
	/**
	 * 获取车不同厂家和相应系列的数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/factory",method=RequestMethod.GET)
	public void getCarFactory(HttpServletRequest request,HttpServletResponse response
			){
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public void getBook(HttpServletRequest request,HttpServletResponse response,
			@RequestBody List<CarBrand> brands){
		System.out.println("hello world");
		Long id=34l;
		HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id);
//		com.personal.util.http.HttpRequestUtil.httpGet(url)
	}
	
	public static void main(String[] args) {
		//1.根据系列找出所有的书  2.循环查出所有书对应的id，并书名
		String baseurl="http://www.bodani.cn/";
		String str = HttpRequestUtil.httpGet("http://www.bodani.cn/article/showlist.aspx?categ_id=0_01&v=12");
		int from;
		int to;
		int n = str.indexOf("a href='/article/?bk=");
		System.out.println(n);
		String id=str.substring(n+21, n+27);
		System.out.println(id);
		from=str.indexOf("<b>", n+27)+3;
		to = str.indexOf("</b>",n+27);
		
		//获取书名或标题
		String title = str.substring(from,to);
		from=str.indexOf("<b>", to)+3;
		to=str.indexOf("</b>",from);
		
		//获取作者
		String author = str.substring(from,to);
		System.out.println(title+"  "+author+"  系列：0_001");
//		String acticle = HttpRequestUtil.httpGet(baseurl+"article/?bk="+id);
		String acticle = HttpRequestUtil.httpGet(baseurl+"article/?bk="+200365);
		from = acticle.indexOf("value")+7;
		to =acticle.indexOf("/>",from)-1;
		//获取所有相关的id节点
		String ta = acticle.substring(from,to);
		System.out.println(ta);
		//获取处理jstree
		Document doc = (Document) Jsoup.parse(acticle);
//		Document doc = (Document) Jsoup.parse("www.baidu.com");
		Element e = doc.getElementById("treecontent");
		Elements links = (Elements) e.getElementsByTag("a");
		Long linkId=-1l;
		//获取e里面所有含li的标签
		Elements lis = (Elements) e.getElementsByTag("li");
	/*	for (org.jsoup.nodes.Element link : links) {
		  String linkHref = link.attr("href");
		  String idstr = link.attr("id");
		  String linkText = link.text();
		  List<String> ids= new ArrayList<String>();
		  ids.add(linkText);
		  System.out.println(idstr+":"+linkText);
		}*/
		List<Long> ids= new ArrayList<Long>();
		for (org.jsoup.nodes.Element link : lis) {
			Element element = link.getElementsByTag("span").first();
			if(element.getElementsByTag("a").size() > 0){
				linkId=Long.valueOf(element.child(0).id());
			}else{
				linkId=-1l;
			}
			int level=2;
			if(link.getElementsByTag("span").size()>1){
				level=2;
			}else{
				level=3;
			}
			String linkText = link.getElementsByTag("span").first().text();
//			String linkText1 = link.child(1).text();
			
			
			if(linkId>0){
				ids.add(linkId);
			}
//			System.out.println("id:"+linkId+","+level+"目录"+",标题:"+linkText);
		}
		
		//获取正文
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
		//for(Long ID:ids){
			for(int j=0;j<4;j++){
				List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ta",ta));
			params.add(new BasicNameValuePair("id",ids.get(j).toString()));
			String content = HttpRequestUtil.httpPost(baseurl+"get_ajax/GetContent.aspx", params);
			Document document= Jsoup.parse(content);
			Element string = document.getElementById("mainBody");
			System.out.println(string);
		}
		
//		params.add(new BasicNameValuePair("ta",ta));
//		params.add(new BasicNameValuePair("id",id));
//		String content = HttpRequestUtil.httpPost(baseurl+"get_ajax/GetContent.aspx", params);
//		Document document= Jsoup.parse(content);
//		Element string = document.getElementById("mainBody");
//		
//		System.out.println(string);
		//System.out.println(str);
	}
}

