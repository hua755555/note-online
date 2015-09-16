package com.personal.service;

import com.personal.model.UserAccountModel;
import com.personal.model.UserProfile;
import com.personal.model.UserProfileModel;
import com.personal.util.exception.ServiceException;


public interface UserProfileService {

	public Integer insert(UserProfile userProfile);

	public UserProfileModel queryModel(Long uid) throws ServiceException;

	public void doRegist(UserAccountModel account) throws ServiceException;
}
