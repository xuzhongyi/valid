package com.test.valid;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.test.util.ThreadUtil;

public class ParamRequest {

	public void request(Object object) throws Exception{
		if(null == object || "".equals(object)){
			ThreadLocal<Map<String,String>> valid=new ThreadLocal<Map<String,String>>();
			HashMap<String, String> hashMap = new HashMap<String,String>();
			hashMap.put(CodeType.request.getCode(), CodeType.request.getData());
			hashMap.put(CodeType.request.getCode(), CodeType.request.getData());
			valid.set(hashMap);
			ThreadUtil.setValid(valid);
		}
	}
	
	public void isNumber(Object object) throws Exception{
		if(object == null || !StringUtils.isNumeric((String)object)){
			throw new Exception("参数不是数字类型");
		}
	}
	
	public void isMobile(Object object) throws Exception{
		System.out.println(object);
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		if(null == object){
			ThreadLocal<Map<String,String>> valid=new ThreadLocal<Map<String,String>>();
			HashMap<String, String> hashMap = new HashMap<String,String>();
			hashMap.put(CodeType.mobile.getCode(), CodeType.mobile.getData());
			hashMap.put(CodeType.mobile.getCode(), CodeType.mobile.getData());
			valid.set(hashMap);
			ThreadUtil.setValid(valid);
		}else{
			Matcher m = p.matcher((String)object);
			if("".equals(object)||!m.matches()){
				ThreadLocal<Map<String,String>> valid=new ThreadLocal<Map<String,String>>();
				HashMap<String, String> hashMap = new HashMap<String,String>();
				hashMap.put(CodeType.mobile.getCode(), CodeType.mobile.getData());
				hashMap.put(CodeType.mobile.getCode(), CodeType.mobile.getData());
				valid.set(hashMap);
				ThreadUtil.setValid(valid);
			}
		}
	}
}
