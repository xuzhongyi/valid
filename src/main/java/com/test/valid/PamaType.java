package com.test.valid;


/**
 * 判断需要验证的数据类型的验证
 * @author xzy
 *
 */
public enum PamaType {
	//定义枚举
	NULL(""),BASETYPE("base"),COMPLEXTYPE("complexty");
	
	private String type;

	private PamaType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
