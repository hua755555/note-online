package com.personal.dao;

import java.util.List;

import com.personal.model.other.CarBrand;

public interface CarBrandDao {

	public Integer insert(CarBrand carBrand);
	
	public List<CarBrand> getList();
	
}
