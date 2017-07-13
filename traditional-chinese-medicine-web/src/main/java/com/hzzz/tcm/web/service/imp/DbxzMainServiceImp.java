package com.hzzz.tcm.web.service.imp;

import java.util.Date;
import java.util.List;

import com.hzzz.tcm.persistence.dao.SeqMapper;
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
	@Autowired
	SeqMapper seqMapper;

	public int insertArrange(int patientid) {
		Integer seq = seqMapper.selectSeq();
		seqMapper.replaceSeq(seq+1);
		Dbxztreatrecord record = new Dbxztreatrecord();
		record.setPatientid(patientid);
		record.setStatus(Byte.valueOf("0"));
		record.setStarttime(new Date());
		record.setDatachangeLasttime(new Date());
		record.setSeq(seq+1);
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

	public int reset() {
		return seqMapper.replaceSeq(0);
	}

	public int updatedelete(int recordid) {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.updatedelete(recordid);
	}

}
