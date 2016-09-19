package com.ck.springbootdemo.modules.controller;

import java.util.Map;

import com.ck.springbootdemo.modules.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentControler {

	@Autowired
	private StudentMapper studentMapper;

	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView index (){
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("name", studentMapper.selectAll().get(0).getName());
		return mav;
	}

}
