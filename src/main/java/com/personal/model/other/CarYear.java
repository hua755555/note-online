package com.personal.model.other;

import com.personal.model.BaseDomain;

public class CarYear extends BaseDomain{
	private static final long serialVersionUID = 1L;
	
	private String name; //系列名
	private Long seriesId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
		public Long getSeriesId() {
			return seriesId;
		}
		public void setSeriesId(Long seriesId) {
			this.seriesId = seriesId;
		}
	

}
