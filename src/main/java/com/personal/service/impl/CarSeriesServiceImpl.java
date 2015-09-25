package com.personal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.CarSeriesDao;
import com.personal.model.other.CarSeries;
import com.personal.service.CarSeriesService;

@Service("carBrandService")
public class CarSeriesServiceImpl implements CarSeriesService{
	
	@Autowired
	private CarSeriesDao carSeriesDao;
	public void save(List<CarSeries> series) {
		if(series == null || series.size()==0){
			return ;
		}
		for(CarSeries serie:series){
			carSeriesDao.insert(serie);
		}
	}

}
