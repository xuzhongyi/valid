package com.test.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.pojo.AgentUser;
import com.test.util.ThreadUtil;
import com.test.valid.PamaMethod;
import com.test.valid.PamaMethodValid;
import com.test.valid.PamaType;
import com.test.valid.RequestValid;

@Controller
@RequestMapping("/valid")
public class LoginUser {

	@RequestMapping(value="validUser",produces = {"application/json;charset=UTF-8"})
	@RequestValid()
	@ResponseBody
	public String saveUser(@PamaMethodValid(pamaType=PamaType.COMPLEXTYPE) AgentUser user,@PamaMethodValid(pamaType=PamaType.BASETYPE,pamaMethod=PamaMethod.REQUEST)String validNo){
		/**
		 * 验证信息
		 */
		//用户验证的回调
		ThreadLocal<Map<String,String>> valid = ThreadUtil.getValid();
		//验证失败
		if(null!=valid && null!=valid.get()){
			Map<String, String> map = valid.get();
			for(String str:map.keySet()){
				System.out.println(str);
				System.out.println(map.get(str));
			}
		}else{
			//实现逻辑
		}
		return "";
	}
}
