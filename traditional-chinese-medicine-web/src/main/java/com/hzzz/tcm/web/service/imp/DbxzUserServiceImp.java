package com.hzzz.tcm.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.Dbxzprescription;
import com.hzzz.tcm.domain.model.Dbxztreatrecord;
import com.hzzz.tcm.persistence.dao.DbxzpatientMapper;
import com.hzzz.tcm.persistence.dao.DbxzpatjpreMapper;
import com.hzzz.tcm.persistence.dao.DbxzprescriptionMapper;
import com.hzzz.tcm.persistence.dao.DbxztreatrecordMapper;
import com.hzzz.tcm.web.service.DbxzUserService;
import com.hzzz.tcm.web.vo.Page;
import com.hzzz.tcm.web.vo.wrapper.DbxzPatientSpec;

@Service("DbxzUserService")
public class DbxzUserServiceImp implements DbxzUserService {
	@Autowired
	DbxzpatientMapper dbxzpatientMapper;
	@Autowired
	DbxzprescriptionMapper dbxzprescriptionMapper;
	@Autowired
	DbxztreatrecordMapper dbxztreatrecordMapper;
	@Autowired
	DbxzpatjpreMapper dbxzpatjpreMapper;

	public List<Dbxzpatient> selectDbxzpatients(String condition, Page page) {
		return dbxzpatientMapper.selectDbxzpatients(condition, page.getCurPage(), 1l);
	}

	public DbxzPatientSpec selectDbxzpatientSpecById(Integer id) {
		Dbxzpatient dbxzpatient = dbxzpatientMapper.selectByPrimaryKey(id);
		List<Dbxzprescription> dbxzprescriptions = dbxzpatjpreMapper.selectByPatientid(id);
		List<Dbxztreatrecord> dbxztreatrecords = dbxztreatrecordMapper.selectRecordByPatientid(id);

		// return dbxzpatientMapper.selectDbxzpatientSpecById(id);
		return new DbxzPatientSpec(dbxzpatient, dbxzprescriptions, dbxztreatrecords);
	}

	// 删除病人和药的关系，病人的记录
	public int deleteSelectivePatient(int patientid) {
		dbxztreatrecordMapper.UpdateDeletedAsDeletePatient(patientid);
		dbxzpatjpreMapper.UpdateDeletedAsDeletePatient(patientid);
		return dbxzpatientMapper.updateDeleted(patientid);
	}

	public int insertPatient(Dbxzpatient dbxzpatient, List<Integer> prescriptionids) {
		dbxzpatjpreMapper.UpdateDeletedAsDeletePatient(dbxzpatient.getId());
		for (Integer p : prescriptionids) {
			dbxzpatjpreMapper.insertPatRPre(dbxzpatient.getId(), p);
		}
		return dbxzpatientMapper.insertPatient(dbxzpatient);
	}

	public List<Dbxzprescription> selectDbxzprescriptions() {
		return dbxzprescriptionMapper.selectDbxzprescriptions();
	}

	public int replaceSelectivePrescription(Dbxzprescription record) {
		// TODO Auto-generated method stub
		return dbxzprescriptionMapper.replaceSelectivePrescription(record);
	}

	public Dbxzprescription selectbyMedication(String name) {
		// TODO Auto-generated method stub
		return dbxzprescriptionMapper.selectbyMedication(name);
	}

	public Long selectDbxzpatientsCount(String condition) {
		// TODO Auto-generated method stub
		return dbxzpatientMapper.selectDbxzpatientsCount(condition);
	}

	public Dbxzpatient selectPatientByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dbxzpatientMapper.selectByPrimaryKey(id);
	}

	public int deleteRecord(Integer recordid) {
		// TODO Auto-generated method stub
		return dbxztreatrecordMapper.updatedelete(recordid);
	}

	public int updateDeletePrescriptionById(Integer prescriptionid) {
		// TODO Auto-generated method stub
		dbxzpatjpreMapper.UpdateDeletedAsDeletePrescription(prescriptionid);
		return dbxzprescriptionMapper.updateDeletePrescriptionById(prescriptionid);
	}

	public long selectMaxId() {
		// TODO Auto-generated method stub
		return dbxzpatientMapper.selectMaxId();
	}
}
