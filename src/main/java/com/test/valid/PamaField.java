package com.test.valid;


public enum PamaField implements Pama{
	NULL("",""),REQUEST("com.test.valid.ParamRequest","request"),ISNUMBER("com.test.valid.ParamRequest","isNumber"),ISMOBILE("com.test.valid.ParamRequest","isMobile");
	
	//类名
	private final String classValue;
	
	//方法名
	private final String methodValue;
	
	PamaField(String classValue,String methodValue)
	{
		this.classValue = classValue;
		this.methodValue = methodValue;
	}

	public String getClassValue() {
		return classValue;
	}
	
	public String getMethodValue() {
		return methodValue;
	}
	
}
