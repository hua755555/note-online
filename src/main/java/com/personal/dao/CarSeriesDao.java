package com.personal.dao;

import java.util.List;

import com.personal.model.other.CarSeries;

public interface CarSeriesDao {

	public Integer insert(CarSeries carSeries);
	
	public Integer count(CarSeries carSeries);

	public List<CarSeries> getList();
	
}
