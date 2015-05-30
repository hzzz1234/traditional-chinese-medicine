package com.hzzz.tcm.web.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzzz.tcm.domain.model.Dbxzsystemuser;
import com.hzzz.tcm.persistence.dao.DbxzsystemuserMapper;
import com.hzzz.tcm.web.service.DbxzSystemUserService;

@Service("DbxzSystemUserService")
public class DbxzSystemUserServiceImp implements DbxzSystemUserService {
	@Autowired
	DbxzsystemuserMapper dbxzsystemuserMapper;

	public Dbxzsystemuser selectByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return dbxzsystemuserMapper.selectByUserNameAndPassword(username, password);
	}

}
