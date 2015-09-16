package com.personal.dao;

import com.personal.model.UserAccount;
import com.personal.model.UserAccountModel;

public interface UserAccountDao {

	public Integer insert(UserAccount user);

	public Integer countExist(UserAccountModel user);

	public UserAccountModel queryOneByAccount(UserAccountModel user);

}
