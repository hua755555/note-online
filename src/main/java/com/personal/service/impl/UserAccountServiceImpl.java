package com.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.UserAccountDao;
import com.personal.model.UserAccount;
import com.personal.model.UserAccountModel;
import com.personal.service.UserAccountService;
import com.personal.util.StrUtils;
import com.personal.util.exception.ServiceException;
import com.personal.util.security.PwdEncoder;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService{
	@Autowired
	private UserAccountDao userAccountDao;
	@Autowired
	private PwdEncoder pwdEncoder;
	
	public Integer insert(UserAccount userAccount) {
		return 0;
	}

	public UserAccountModel doLogin(UserAccountModel user) throws Exception {
		if(StrUtils.isEmpty(user.getAccount()) || StrUtils.isEmpty(user.getPassword())){
			return null;
		}
		
		user.setAccountType(UserAccount.ACCOUNT_TYPE_EMAIL);
		user.setIsVerified(UserAccount.IS_VERIFIED_TRUE);
		UserAccountModel userAccountModel = userAccountDao.queryOneByAccount(user);
		
		if(!pwdEncoder.isPasswordValid(userAccountModel.getPassword(),user.getPassword())){
			throw new ServiceException("error.account.password.invalid");
		}
		return userAccountModel;
		
	}
	
	public Boolean countExist(UserAccountModel user) throws ServiceException{
		if(StrUtils.isEmpty(user.getAccount())){
			throw new ServiceException("error.param.null.or.empty");
		}
		Integer count = userAccountDao.countExist(user);
		if(count!= null && count.intValue() >0){
			return true;
		}
		return  false;
		
	}

}
