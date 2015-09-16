package com.personal.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccount extends  BaseDomain{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8298270604938901589L;
	
	private Long uid;
	
	private String account;
	
	private Integer accountType;
	
	private String password;
	
	private int isVerified;
	
	public final static int ACCOUNT_TYPE_EMAIL=0;
	public final static int ACCOUNT_TYPE_MOBILE=1;
	public final static int IS_VERIFIED_DEFAULT=0;
	public final static int IS_VERIFIED_TRUE=1;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}