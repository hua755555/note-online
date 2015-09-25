package com.personal.model.other;

import com.personal.model.BaseDomain;

public class CarBrand extends BaseDomain{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String bfirstletter;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBfirstletter() {
		return bfirstletter;
	}
	public void setBfirstletter(String bfirstletter) {
		this.bfirstletter = bfirstletter;
	}
	
	

}
