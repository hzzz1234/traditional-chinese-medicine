package com.hzzz.tcm.web.service;

import org.apache.ibatis.annotations.Param;

import com.hzzz.tcm.domain.model.Dbxzsystemuser;

public interface DbxzSystemUserService {
	Dbxzsystemuser selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
