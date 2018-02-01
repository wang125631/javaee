package com.wpx.springmvc.demo04.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wpx.springmvc.demo04.vo.Department;
import com.wpx.springmvc.demo04.vo.Employee;

/**
 * 
 * 员工接口类
 * 
 * @author wangpx
 */
@SuppressWarnings("unused")
@Repository
public class EmployeeDao {

	private static Map<Integer,Employee> employees= null;
	@Autowired
	private DepartmentDao departmentDao;

	static {
		
		employees = new HashMap<Integer,Employee>();
	
		employees.put(1001, new Employee(1001, "wpx001"," wpx01@163.com", "男", new Department(01, "Name-01")));
		employees.put(1002, new Employee(1002, "wpx002"," wpx02@163.com", "男", new Department(02, "Name-02")));
		employees.put(1003, new Employee(1003, "wpx003"," wpx03@163.com", "男", new Department(03, "Name-03")));
		employees.put(1004, new Employee(1004, "wpx004"," wpx04@163.com", "男", new Department(04, "Name-04")));
	}
	
	public static Integer initId=1005;
	
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartmentId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return  employees.values();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employees.get(id);
	}
	
	public void deleteEmployeeById(Integer id) {
		employees.remove(id);
	}
	
	
}
