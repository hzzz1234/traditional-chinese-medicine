package com.hzzz.tcm.web.vo;

public class DbxzPatientVo {
	private int id;
	private String name;
	private int age;
	private int sex;
	private String contact;
	private String symptom;
	private String prescriptionids;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getPrescriptionids() {
		return prescriptionids;
	}

	public void setPrescriptionids(String prescriptionids) {
		this.prescriptionids = prescriptionids;
	}

}
