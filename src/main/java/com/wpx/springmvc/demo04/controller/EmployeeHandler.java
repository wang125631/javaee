package com.wpx.springmvc.demo04.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wpx.springmvc.demo04.dao.EmployeeDao;
import com.wpx.springmvc.demo04.vo.Employee;
/**
 * 创建资源 post
 * 获取资源 get
 * 更新资源 put
 * 删除资源 delete
 * 
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc/demo04")
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	/**
	 * 
	 * 显示所有客户信息
	 */
	@RequestMapping("/list")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "demo04/list";
	}
	/**
	 * 添加客户
	 */
	public String add(Employee employee) {
		employeeDao.save(employee);
		return "demo04/list";
	}
	/**
	 * 修改客户
	 */
	public String update(Employee empolyee) {
		employeeDao.updateEmployee(empolyee);
		return "demo04/list";
	}
	/**
	 * 删除客户
	 */
	public String detele(Integer id) {
		employeeDao.deleteEmployeeById(id);
		return "demo04/list";
	}
}
