package com.hzzz.tcm.web.service;

import java.util.List;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.Dbxzprescription;
import com.hzzz.tcm.web.vo.Page;
import com.hzzz.tcm.web.vo.wrapper.DbxzPatientSpec;

public interface DbxzUserService {
	List<Dbxzpatient> selectDbxzpatients(String condition, Page page);

	DbxzPatientSpec selectDbxzpatientSpecById(Integer id);

	public int deleteSelectivePatient(int patientid);

	int insertPatient(Dbxzpatient dbxzpatient, List<Integer> prescriptionids);

	List<Dbxzprescription> selectDbxzprescriptions();

	int replaceSelectivePrescription(Dbxzprescription record);

	Dbxzprescription selectbyMedication(String name);

	Long selectDbxzpatientsCount(String condition);

	Dbxzpatient selectPatientByPrimaryKey(Integer id);

	int deleteRecord(Integer recordid);

	int updateDeletePrescriptionById(Integer prescriptionid);

	long selectMaxId();
}
