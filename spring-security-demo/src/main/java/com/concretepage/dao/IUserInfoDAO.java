package com.concretepage.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.concretepage.entity.UserInfo;

public interface IUserInfoDAO extends CrudRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo>{
	UserInfo getUserInfo(String userName) ;
}
