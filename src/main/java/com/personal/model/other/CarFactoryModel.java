package com.personal.model.other;

import java.util.List;

public class CarFactoryModel extends CarFactory{
	private static final long serialVersionUID = 1L;
	
	private List<CarSeries> seriesitems;

	public List<CarSeries> getSeriesitems() {
		return seriesitems;
	}

	public void setSeriesitems(List<CarSeries> seriesitems) {
		this.seriesitems = seriesitems;
	}

}
