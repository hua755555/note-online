package com.personal.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccount implements  Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8298270604938901589L;
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private int emailVerify;
	
	private int status;
	
	public final static int STATUS_NOT_ACTIVATED = 0;
	
	public final static int STATUS_NORMAL = 1;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(int emailVerify) {
		this.emailVerify = emailVerify;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}