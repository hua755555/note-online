package com.personal.model.other;

import java.util.List;

public class Factoryitems {
	private Long id;
	private String name;
	private String firstletter;
	private List<CarSeries> seriesitems;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<CarSeries> getSeriesitems() {
		return seriesitems;
	}
	public void setSeriesitems(List<CarSeries> seriesitems) {
		this.seriesitems = seriesitems;
	}

}
