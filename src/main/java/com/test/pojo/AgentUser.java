package com.test.pojo;

import com.test.valid.PamaField;
import com.test.valid.PamaFieldValid;

public class AgentUser {

	@PamaFieldValid(pamaField=PamaField.ISMOBILE)
	private String mobileNo;
	
	@PamaFieldValid(pamaField=PamaField.REQUEST)
	private String password;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
