package com.personal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.CarBrandDao;
import com.personal.model.other.CarBrand;
import com.personal.service.CarBrandService;

@Service("carBrandService")
public class CarBrandServiceImpl implements CarBrandService{
	
	@Autowired
	private CarBrandDao carBrandDao;
	public void save(List<CarBrand> brands) {
		if(brands == null || brands.size()==0){
			return ;
		}
		for(CarBrand carBrand:brands){
			carBrandDao.insert(carBrand);
		}
	}
	@Override
	public List<CarBrand> queryList() {
		
		return carBrandDao.getList();
	}
	
	

}
