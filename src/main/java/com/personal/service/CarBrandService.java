package com.personal.service;

import java.util.List;

import com.personal.model.other.CarBrand;

public interface CarBrandService{
	
	public void save(List<CarBrand> brands);
	
	public List<CarBrand> queryList();
		
}
