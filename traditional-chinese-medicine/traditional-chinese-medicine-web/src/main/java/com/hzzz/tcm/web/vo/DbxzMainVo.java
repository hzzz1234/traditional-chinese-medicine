package com.hzzz.tcm.web.vo;

import java.util.List;

import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;

public class DbxzMainVo {
	List<DbxzRecord> waitList;
	List<DbxzRecord> rescueList;

	public List<DbxzRecord> getWaitList() {
		return waitList;
	}

	public void setWaitList(List<DbxzRecord> waitList) {
		this.waitList = waitList;
	}

	public List<DbxzRecord> getRescueList() {
		return rescueList;
	}

	public void setRescueList(List<DbxzRecord> rescueList) {
		this.rescueList = rescueList;
	}

}
