package com.personal.service;

import com.personal.model.UserAccount;
import com.personal.model.UserAccountModel;
import com.personal.util.exception.ServiceException;


public interface UserAccountService {

	Integer insert(UserAccount userAccount);

	public UserAccountModel doLogin(UserAccountModel user) throws Exception;
	
	public Boolean countExist(UserAccountModel user) throws ServiceException;

}
