package com.personal.model.other;

import java.util.Map;

public class BaseModel {
	private Integer returncode;
	private String message;
	private Map<String, Object> result;
	
	public Integer getReturncode() {
		return returncode;
	}
	public void setReturncode(Integer returncode) {
		this.returncode = returncode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	

}
