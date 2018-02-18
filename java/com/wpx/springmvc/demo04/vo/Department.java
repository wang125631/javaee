package com.wpx.springmvc.demo04.vo;
/**
 * 
 * 部门实体类
 * 
 * @author wangpx
 */
public class Department {

	private Integer id;
	private String departmentName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Department() {
	}
	public Department(Integer id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	
	
}
