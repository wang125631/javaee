package com.wpx.springmvc.demo04.vo;
/**
 * 
 *员工实体类
 *
 * @author wangpx
 */
public class Employee {

	private Integer id;
	private String name;
	private String email;
	private String gender;
	private Department department;
	private Integer departmentId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee() {

	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Employee(Integer id, String name, String email, String gender, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}
	
	
	
	
}
