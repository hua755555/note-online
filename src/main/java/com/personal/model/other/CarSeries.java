package com.personal.model.other;

import com.personal.model.BaseDomain;

public class CarSeries extends BaseDomain{
	private static final long serialVersionUID = 1L;
	
	private String name; //系列名
	private String firstletter;//2级车名首字母
	private Long factoryId;
	private Long seriesstate;
	private Long seriesorder;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstletter() {
		return firstletter;
	}
	public void setFirstletter(String firstletter) {
		this.firstletter = firstletter;
	}
	public Long getSeriesstate() {
		return seriesstate;
	}
	public void setSeriesstate(Long seriesstate) {
		this.seriesstate = seriesstate;
	}
	public Long getSeriesorder() {
		return seriesorder;
	}
	public void setSeriesorder(Long seriesorder) {
		this.seriesorder = seriesorder;
	}
	public Long getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}
	
	

}
