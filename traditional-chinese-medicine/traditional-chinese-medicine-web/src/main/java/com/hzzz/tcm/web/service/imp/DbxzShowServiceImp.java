package com.hzzz.tcm.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzzz.tcm.persistence.dao.DbxztreatrecordMapper;
import com.hzzz.tcm.web.service.DbxzShowService;
import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;

@Service("DbxzShowService")
public class DbxzShowServiceImp implements DbxzShowService {
	@Autowired
	DbxztreatrecordMapper dbxztreatrecordMapper;

	public List<DbxzRecord> selectArrangeRecords() {
		return dbxztreatrecordMapper.selectArrangeRecords();
	}

}
