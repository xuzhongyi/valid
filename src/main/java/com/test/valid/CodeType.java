package com.test.valid;
/**
 * 用于验证失败的code
 * @author xzy
 *
 */
public enum CodeType {

	
	mobile("mobileCode","手机数据不合法"),request("requestCode","数据不能为空");

	private CodeType(String code, String data) {
		this.code = code;
		this.data = data;
	}

	//code
	private final String code;

	private final String data;
	
	
	public String getCode() {
		return code;
	}

	public String getData() {
		return data;
	}

	
	
	
	
}
