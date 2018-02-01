package com.wpx.springmvc.demo04.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wpx.springmvc.demo04.dao.EmployeeDao;

@Controller
@RequestMapping("/spring-mvc/demo04")
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/list")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		System.out.println( employeeDao.getAll());
		return "demo04/list";
	}
}
