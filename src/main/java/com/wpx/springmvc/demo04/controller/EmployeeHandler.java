package com.wpx.springmvc.demo04.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "demo04/list";
	}
	
	/**
	 * 根据客户id查询客户
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String get(@PathVariable Integer id,Map<String,Object> map) {
		map.put("employee",employeeDao.getEmployeeById(id));
		return "demo04/update";
	}
	
	/**
	 * 添加客户
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String add(Employee employee) {
		employeeDao.save(employee);
		return "redirect:emp";
	}
	/**
	 * 修改客户
	 */
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee empolyee) {
		employeeDao.updateEmployee(empolyee);
		return "redirect:emp";
	}
	/**
	 * 删除客户
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String detele(@PathVariable Integer id) {
		employeeDao.deleteEmployeeById(id);
		return "redirect:emp";
	}
}
