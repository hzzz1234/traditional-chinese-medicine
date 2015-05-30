package com.hzzz.tcm.web.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.Dbxztreatrecord;
import com.hzzz.tcm.persistence.dao.DbxzpatientMapper;
import com.hzzz.tcm.persistence.dao.DbxztreatrecordMapper;
import com.hzzz.tcm.web.service.DbxzMainService;
import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;

@Service("DbxzMainService")
public class DbxzMainServiceImp implements DbxzMainService {

	@Autowired
	DbxztreatrecordMapper dbxztreatrecordMapper;
	@Autowired
	DbxzpatientMapper dbxzpatientMapper;

	public int insertArrange(int patientid) {
		Dbxztreatrecord record = new Dbxztreatrecord();
		record.setPatientid(patientid);
		record.setStatus(Byte.valueOf("0"));
		record.setStarttime(new Date());
		record.setDatachangeLasttime(new Date());
		return dbxztreatrecordMapper.insert1(record);
	}

	public int updateRescue(int recordid) {

		return dbxztreatrecordMapper.updateRescue(recordid);
	}

	public int deleteSelective(int recordid) {
		return dbxztreatrecordMapper.deleteRecord(recordid);
	}

	public int updateRollback(int recordid) {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.updateRollback(recordid);
	}

	public int updatefinish(int recordid) {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.updatefinish(recordid);
	}

	public Dbxzpatient selectPatient(int patientid) {
		return dbxzpatientMapper.selectByPrimaryKey(patientid);
	}

	public List<DbxzRecord> selectArrangeRecords() {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.selectArrangeRecords();
	}

	public List<DbxzRecord> selectRescueRecords() {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.selectRescueRecords();
	}

	public int updatedelete(int recordid) {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.updatedelete(recordid);
	}

}
