package com.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.dao.UserAccountDao;
import com.personal.dao.UserProfileDao;
import com.personal.model.UserAccountModel;
import com.personal.model.UserProfile;
import com.personal.model.UserProfileModel;
import com.personal.service.UserAccountService;
import com.personal.service.UserProfileService;
import com.personal.util.LongUtils;
import com.personal.util.StrUtils;
import com.personal.util.exception.ServiceException;

public class UserProfileServiceImpl implements UserProfileService{

	@Autowired
	public UserProfileDao userProfileDao;
	@Autowired
	public UserAccountService userAccountService;
	@Autowired
	public UserAccountDao userAccountDao;
	
	public Integer insert(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserProfileModel queryModel(Long uid) throws ServiceException {
		if(LongUtils.isEmpty(uid)){
			throw new ServiceException("");
		}
		
		return userProfileDao.queryModel(uid);
	}

	public void doRegist(UserAccountModel account) throws ServiceException {
		if(StrUtils.isEmpty(account.getAccount()) || StrUtils.isEmpty(account.getNickName())){
			throw new ServiceException("error.param.null.or.empty");
		}
		if(StrUtils.isEmpty(account.getPassword()) || account.getPassword().length()<6){
			throw new ServiceException("error.account.password.length.short");
		}
		if(userAccountService.countExist(account)){
			throw new ServiceException("error.account.account.existed");
		}
		UserProfile profile = new UserProfile();
		profile.setNickName(account.getNickName());
		profile.setEmail(account.getAccount());
		userProfileDao.insert(profile);
		
		account.setUid(profile.getId());
		userAccountDao.insert(account);
	}

}
