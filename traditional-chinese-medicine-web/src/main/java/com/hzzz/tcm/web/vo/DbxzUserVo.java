package com.hzzz.tcm.web.vo;

import java.util.List;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.Dbxzprescription;

public class DbxzUserVo {
	String condition;
	List<Dbxzpatient> dbxzPatients;
	List<Dbxzprescription> dbxzprescriptions;
	Page page;

	public List<Dbxzprescription> getDbxzprescriptions() {
		return dbxzprescriptions;
	}

	public void setDbxzprescriptions(List<Dbxzprescription> dbxzprescriptions) {
		this.dbxzprescriptions = dbxzprescriptions;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Dbxzpatient> getDbxzPatients() {
		return dbxzPatients;
	}

	public void setDbxzPatients(List<Dbxzpatient> dbxzPatients) {
		this.dbxzPatients = dbxzPatients;
	}
}
