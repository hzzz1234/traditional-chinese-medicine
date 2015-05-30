package com.hzzz.tcm.web.vo.wrapper;

import java.util.List;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.Dbxzprescription;
import com.hzzz.tcm.domain.model.Dbxztreatrecord;

public class DbxzPatientSpec {
	public DbxzPatientSpec(Dbxzpatient dbxzpatient, List<Dbxzprescription> dbxzprescriptions, List<Dbxztreatrecord> dbxztreatrecords) {
		super();
		this.dbxzpatient = dbxzpatient;
		this.dbxzprescriptions = dbxzprescriptions;
		this.dbxztreatrecords = dbxztreatrecords;
	}

	Dbxzpatient dbxzpatient;
	List<Dbxzprescription> dbxzprescriptions;
	List<Dbxztreatrecord> dbxztreatrecords;

	public List<Dbxztreatrecord> getDbxztreatrecords() {
		return dbxztreatrecords;
	}

	public void setDbxztreatrecords(List<Dbxztreatrecord> dbxztreatrecords) {
		this.dbxztreatrecords = dbxztreatrecords;
	}

	public Dbxzpatient getDbxzpatient() {
		return dbxzpatient;
	}

	public void setDbxzpatient(Dbxzpatient dbxzpatient) {
		this.dbxzpatient = dbxzpatient;
	}

	public List<Dbxzprescription> getDbxzprescriptions() {
		return dbxzprescriptions;
	}

	public void setDbxzprescriptions(List<Dbxzprescription> dbxzprescriptions) {
		this.dbxzprescriptions = dbxzprescriptions;
	}

}
