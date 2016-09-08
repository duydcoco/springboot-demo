package com.ck.springbootdemo.modules.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

@Controller
public class StudentControler {

	@RequestMapping("/index")
	@ResponseBody
	public String list (){
		Map<String,String> map = Maps.newHashMap();
		map.put("json", "hello");
		Gson gson = new Gson();
		return gson.toJson(map);
	}
}
