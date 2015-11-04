package com.personal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.CarSeriesDao;
import com.personal.model.other.CarSeries;
import com.personal.service.CarSeriesService;

@Service("carSeriesService")
public class CarSeriesServiceImpl implements CarSeriesService{
	
	@Autowired
	private CarSeriesDao carSeriesDao;

	@Override
	public List<CarSeries> queryList() {
		return carSeriesDao.getList();
	}


}
