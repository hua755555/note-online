package com.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.personal.dao.CarSpaceDao;
import com.personal.dao.CarYearDao;
import com.personal.model.other.CarSpace;
import com.personal.model.other.CarYear;
import com.personal.service.CarYearService;
import com.personal.util.http.HttpRequestUtil;

@Service("carYearService")
public class CarYearServiceImpl implements CarYearService{
	
	@Autowired
	private CarSpaceDao carSpaceDao;
	@Autowired
	private CarYearDao carYearDao;

	public void doSave(Long seriesId) {
		String url = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=5&value="+seriesId;
		String data = HttpRequestUtil.httpGet(url,"GBK");
		JSONObject json = JSONObject.parseObject(data);
		JSONObject result = json.getJSONObject("result");
		JSONArray yearitems = result.getJSONArray("yearitems");
		for(int i=0;i<yearitems.size();i++){
			JSONObject yearitem = yearitems.getJSONObject(i);
			 CarYear carYear = new CarYear();
			carYear.setName(yearitem.getString("name"));
			carYear.setSeriesId(seriesId);
			carYear.setId(yearitem.getLong("id"));
			Integer count = carYearDao.count(carYear);
			if(count ==0){
				carYearDao.insert(carYear);
			}
			//TODO insert factory
			JSONArray specitems = yearitem.getJSONArray("specitems");
			 for(int j=0;j<specitems.size();j++){
				 JSONObject specitem = specitems.getJSONObject(j) ;
				CarSpace carSpace = new CarSpace();
				carSpace.setName(specitem.getString("name"));
				carSpace.setYearId(carYear.getId());
				carSpace.setId(specitem.getLong("id"));
				carSpace.setState(specitem.getLong("state"));
				carSpace.setMaxprice(specitem.getLong("maxprice"));
				carSpace.setMinprice(specitem.getLong("minprice"));
				int num = carSpaceDao.count(carSpace);
				if(num == 0){
					carSpaceDao.insert(carSpace);
				}
			 }
		}
	}

}
