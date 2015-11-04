package com.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.personal.dao.CarFactoryDao;
import com.personal.dao.CarSeriesDao;
import com.personal.model.other.CarFactory;
import com.personal.model.other.CarSeries;
import com.personal.service.CarFactoryService;
import com.personal.util.http.HttpRequestUtil;

@Service("carFactoryService")
public class CarFactoryServiceImpl implements CarFactoryService{
	
	@Autowired
	private CarSeriesDao carSeriesDao;
	@Autowired
	private CarFactoryDao carFactoryDao;

	@Override
	public void doSave(Long bId) {
		String url = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value="+bId;
		String data = HttpRequestUtil.httpGet(url,"GBK");
		JSONObject json = JSONObject.parseObject(data);
		JSONObject result = json.getJSONObject("result");
		JSONArray factoryitems = result.getJSONArray("factoryitems");
		for(int i=0;i<factoryitems.size();i++){
			JSONObject factoryitem = factoryitems.getJSONObject(i);
			 CarFactory carFactory = new CarFactory();
			carFactory.setFirstletter(factoryitem.getString("firstletter"));
			carFactory.setName(factoryitem.getString("name"));
			carFactory.setBrandId(bId);
			carFactory.setId(factoryitem.getLong("id"));
			Integer count = carFactoryDao.count(carFactory);
			if(count ==0){
				carFactoryDao.insert(carFactory);
			}
			//TODO insert factory
			JSONArray seriesitems = factoryitem.getJSONArray("seriesitems");
			 for(int j=0;j<seriesitems.size();j++){
				 JSONObject seriesitem = seriesitems.getJSONObject(j) ;
				CarSeries carSeries = new CarSeries();
				carSeries.setName(seriesitem.getString("name"));
				carSeries.setFirstletter(seriesitem.getString("firstletter"));
				carSeries.setSeriesstate(seriesitem.getLong("seriesstate"));
				carSeries.setSeriesorder(seriesitem.getLong("seriesorder"));
				carSeries.setId(seriesitem.getLong("id"));
				carSeries.setFactoryId(carFactory.getId());
				int num = carSeriesDao.count(carSeries);
				if(num == 0){
				carSeriesDao.insert(carSeries);
				}
			 }
		}
	}

}
