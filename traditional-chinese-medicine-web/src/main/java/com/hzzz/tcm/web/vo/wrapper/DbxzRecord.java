package com.hzzz.tcm.web.vo.wrapper;

public class DbxzRecord {
	int recordid;
	int patientid;
	String patientname;
	int patientsex;
	int recordcount;
	int seq;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getRecordcount() {
		return recordcount;
	}

	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}

	public int getPatientsex() {
		return patientsex;
	}

	public void setPatientsex(int patientsex) {
		this.patientsex = patientsex;
	}

	public int getRecordid() {
		return recordid;
	}

	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

}
