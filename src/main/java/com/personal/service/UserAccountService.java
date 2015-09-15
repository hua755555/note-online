package com.personal.service;

import com.personal.model.UserAccount;


public interface UserAccountService {

	int insert(UserAccount userAccount);

	public UserAccount doLogin(UserAccount user) throws Exception;
	
}
