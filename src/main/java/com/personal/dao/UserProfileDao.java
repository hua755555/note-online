package com.personal.dao;

import com.personal.model.UserProfile;
import com.personal.model.UserProfileModel;

public interface UserProfileDao {

	public Integer insert(UserProfile user);

	public UserProfileModel queryModel(Long uid);

}
