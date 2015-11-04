package com.personal.model.other;

import com.personal.model.BaseDomain;

public class CarSpace extends BaseDomain{
	private static final long serialVersionUID = 1L;
	
	private String name; //系列名
	private Long yearId;
	private Long state;
	private Long minprice;
	private Long maxprice;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getYearId() {
		return yearId;
	}
	public void setYearId(Long yearId) {
		this.yearId = yearId;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public Long getMinprice() {
		return minprice;
	}
	public void setMinprice(Long minprice) {
		this.minprice = minprice;
	}
	public Long getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(Long maxprice) {
		this.maxprice = maxprice;
	}
	

}
