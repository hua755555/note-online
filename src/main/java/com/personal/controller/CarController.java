package com.personal.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.personal.model.other.CarBrand;
import com.personal.model.other.CarFactory;
import com.personal.model.other.CarSeries;
import com.personal.service.CarBrandService;
import com.personal.service.CarFactoryService;
import com.personal.service.CarSeriesService;
import com.personal.service.CarYearService;
import com.personal.util.http.HttpRequestUtil;

@Controller
@RequestMapping("/car")
public class CarController extends BaseController{
	
	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarSeriesService carSeriesService;
	@Autowired
	private CarFactoryService carFactoryService;
	@Autowired
	private CarYearService carYearService;
	
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
	
	
	
	/**
	 * 获取车不同厂家和相应系列的数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/factory",method=RequestMethod.GET)
	public void getCarFactory(HttpServletRequest request,HttpServletResponse response
			){
		List<CarBrand> brands = carBrandService.queryList();
		for(CarBrand brand:brands){
			carFactoryService.doSave(brand.getId());
			
		}
	}
	
	//获取年款车型
	@RequestMapping(value="/year",method=RequestMethod.GET)
	public void getYear(HttpServletRequest request,HttpServletResponse response
			){
		List<CarSeries> carSeries = carSeriesService.queryList();
		for(CarSeries series:carSeries){
			carYearService.doSave(series.getId());
			
		}
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
	
	@RequestMapping(method=RequestMethod.GET)
	public void getBook(HttpServletRequest request,HttpServletResponse response,
			@RequestBody List<CarBrand> brands){
		System.out.println("hello world");
		carBrandService.save(brands);
		Long id=34l;
		HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id);
//		com.personal.util.http.HttpRequestUtil.httpGet(url)
	}
	
	public static void main(String[] args) {
		Long id =140l;
//		JSONArray jsonArray = new JSONObject();
		String str =HttpRequestUtil.httpGet("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+id,"gbk");
		System.out.println(str);
//		BaseModel model = JSONArray.parseArray(str, BaseModel.class);
		  JSONObject json;
		json = JSONObject.parseObject(str);
		JSONObject result = json.getJSONObject("result");
		JSONArray factoryitems = result.getJSONArray("factoryitems");
		for(int i=0;i<factoryitems.size();i++){
			JSONObject factoryitem = factoryitems.getJSONObject(i);
			 CarFactory carFactory = new CarFactory();
			carFactory.setFirstletter(factoryitem.getString("firstletter"));
			carFactory.setName(factoryitem.getString("name"));
			carFactory.setBrandId(id);
			carFactory.setId(factoryitem.getLong("id"));
			//TODO insert factory
			JSONArray seriesitems = factoryitem.getJSONArray("seriesitems");
			 for(int j=0;j<seriesitems.size();j++){
				 JSONObject seriesitem = seriesitems.getJSONObject(j) ;
				CarSeries carSeries = new CarSeries();
				carSeries.setName(seriesitem.getString("name"));
				carSeries.setFirstletter(seriesitem.getString("firstletter"));
				carSeries.setSeriesstate(seriesitem.getLong("seriesstate"));
				carSeries.setSeriesorder(seriesitem.getLong("seriesorder"));
				carSeries.setFactoryId(carFactory.getId());
				//TODO insert carseries
			 }
		}
//		JSONArray jsonA = factoryitems.getJSONArray("seriesitems");
		
////		Factoryitems factoryitems =  
//		List<Factoryitems> factoryitems = (List<Factoryitems>) model.getResult().get("factoryitems");
//		for(Factoryitems factoryitem:factoryitems){
////			carSeriesService.save(factoryitem.getSeriesitems());
//			factoryitem.getSeriesitems();
//		}
//		map.get("result").get("factoryitems");
//		List<CarSeries> carSeries = 
//		JSONObject data=JSONObject.parseObject(str);
//		data.getString("message");
//		
////		System.out.println(data.getJSONObject("message"));
//		data.getJSONArray("seriesitems");
////		data.get
//		 data.getObject("seriesitems",HashMap.class);
		
//		String jsonData = "[{\"username\":\"arthinking\",\"userId\":1},{\"username\":\"Jason\",\"userId\":2}]";
	/*	try{
			JsonReader reader = new JsonReader(new StringReader(str));
			reader.beginArray();
			while(reader.hasNext()){
				reader.beginObject();
				while(reader.hasNext()){
					
					String tagName = reader.nextName();
					if(tagName.equals("factoryitems")){
						System.out.println(reader.nextString());
					}
					else if(tagName.equals("result")){
						System.out.println(reader.nextString());
					}
				}
				reader.endObject();
			}
			reader.endArray();
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
	}
}

