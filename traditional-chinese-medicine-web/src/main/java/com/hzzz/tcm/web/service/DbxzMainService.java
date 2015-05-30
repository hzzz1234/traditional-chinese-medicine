package com.hzzz.tcm.web.service;

import java.util.List;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;

public interface DbxzMainService {
	int insertArrange(int patientid);

	int updateRescue(int recordid);

	int updatedelete(int recordid);

	int updateRollback(int recordid);

	int updatefinish(int recordid);

	Dbxzpatient selectPatient(int patientid);

	List<DbxzRecord> selectArrangeRecords();

	List<DbxzRecord> selectRescueRecords();

}
