package com.personal.model.other;

import com.personal.model.BaseDomain;

public class CarFactory extends BaseDomain{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String firstletter;
	private Long brandId;
	
	public String getFirstletter() {
		return firstletter;
	}
	public void setFirstletter(String firstletter) {
		this.firstletter = firstletter;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
