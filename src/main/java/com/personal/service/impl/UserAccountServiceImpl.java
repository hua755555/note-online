package com.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.personal.dao.UserAccountDao;
import com.personal.model.UserAccount;
import com.personal.service.UserAccountService;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService{
	@Autowired
	private UserAccountDao userAccountDao;
	
	public int insert(UserAccount userAccount) {
		return 0;
	}

	public UserAccount doLogin(UserAccount user) throws Exception {
		if(user.getEmail() == null || user.getEmail() == ""){
			return null;
		}
		if(user.getPassword() == null || user.getPassword() == ""){
			return null;
		}
		UserAccount userAccount =userAccountDao.queryOneByAccount(user);
		if(userAccount == null){
			return null;
		}
		return userAccount;
	}

}
