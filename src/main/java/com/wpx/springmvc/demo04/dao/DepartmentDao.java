package com.wpx.springmvc.demo04.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wpx.springmvc.demo04.vo.Department;

/**
 * 部门接口类
 * 
 * @author wangpx
 */
@Repository
public class DepartmentDao {

	private static Map<Integer,Department> departments = null;
	
	/**
	 * 初始化参数
	 */
	static {
	
		departments = new HashMap<Integer,Department>();
	
		departments.put(01, new Department(01, "Name-01"));
		departments.put(02, new Department(02, "Name-02"));
		departments.put(03, new Department(03, "Name-03"));
		departments.put(04, new Department(04, "Name-04"));		
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartmentById(Integer id) {
		return departments.get(id);
	}
}
