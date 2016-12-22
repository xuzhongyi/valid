package com.test.util;

import java.util.Map;

import com.test.pojo.AgentUser;

public class ThreadUtil {

	
	//用于处理验证的ThreadLocal<map>
	private static ThreadLocal<Map<String,String>> valid=null;

	public static ThreadLocal<Map<String, String>> getValid() {
		return valid;
	}

	public static void setValid(ThreadLocal<Map<String, String>> valid) {
		ThreadUtil.valid = valid;
	}
	
}
