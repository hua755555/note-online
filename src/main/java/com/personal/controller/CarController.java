package com.personal.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.personal.model.other.CarBrand;
import com.personal.model.other.CarSeries;
import com.personal.service.CarBrandService;
import com.personal.util.StrUtils;
import com.personal.util.http.HttpRequestUtil;

@Controller
@RequestMapping("/car")
public class CarController extends BaseController{
	
	@Autowired
	private CarBrandService carBrandService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void car(HttpServletRequest request,HttpServletResponse response,
			@RequestBody List<CarBrand> brands){
		System.out.println("hello world");
		carBrandService.save(brands);
//		com.personal.util.http.HttpRequestUtil.httpGet(url)
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void getcar(HttpServletRequest request,HttpServletResponse response,
			@RequestBody List<CarBrand> brands){
		System.out.println("hello world");
		carBrandService.save(brands);
		Long id=34l;
		HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id);
//		com.personal.util.http.HttpRequestUtil.httpGet(url)
	}
	
	
	public static String doGet(int id) throws Exception{
		StringBuffer stringBuffer =new StringBuffer();
		stringBuffer.append("");
		URL url = new URL("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id);
		URLConnection connection;
		connection = url.openConnection();
		HttpURLConnection httpURLConnection =(HttpURLConnection) connection;
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resBuffer = new StringBuffer();
		String tempLineString = null;

		if(httpURLConnection.getResponseCode() >= 300){
		throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
		}

		try {
//			inputStream =httpURLConnection.getInputStream();
		inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(),"GBK");
		reader = new BufferedReader(inputStreamReader);
		while ((tempLineString = reader.readLine()) != null) {
		resBuffer.append(tempLineString);
		}

		}finally {

		if (reader != null) {
		reader.close();
		}

		if (inputStreamReader != null) {
		inputStreamReader.close();
		}

		if (inputStream != null) {
		inputStream.close();
		}

		}

		return resBuffer.toString();
		}
	
	
	public  void getSeries(HttpServletRequest request,HttpServletResponse response){
		List<CarBrand> brands = carBrandService.queryList();
		for(CarBrand brand:brands){
			String str =HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+brand.getId(),"gbk");
			JSONObject data=JSONObject.parseObject(str);
			data.getJSONArray("seriesitems");
			List<CarSeries> carSeries = data.message;
		}
		Long id=34l;
		String data = HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id,"gbk");
		System.err.println("data:"+data);
	}
	
	private String dealStr(String str){
		if(StrUtils.isEmpty(str)){
			System.out.println("str prase error");
			return "";
		}
		str.split("")
	}
	public static void main(String[] args) {
		Long id =34l;
//		JSONArray jsonArray = new JSONObject();
		String str =HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id,"gbk");
//		String str1="[{"id":179,"name":"ALFA 156","firstletter":"A","seriesstate":40,"seriesorder":16},{"id":401,"name":"ALFA GT","firstletter":"A","seriesstate":40,"seriesorder":21}]'';
		System.out.println(str);
//		JSONArray.parseArray(str, HashMap.class);
		Gson gson  = new Gson();
		Map<String, Object> map = gson.fromJson(str, new TypeToken<Map<String, Object>>() {}.getType());   
		map.get("result").get("factoryitems");
//		List<CarSeries> carSeries = 
//		JSONObject data=JSONObject.parseObject(str);
//		data.getString("message");
//		
////		System.out.println(data.getJSONObject("message"));
//		data.getJSONArray("seriesitems");
////		data.get
//		 data.getObject("seriesitems",HashMap.class);
	}
}

