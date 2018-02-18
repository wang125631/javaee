package com.wpx.servlet.demo19;
/**
 * 学生实体类
 * 
 * @author wangpx
 */
public class Student {

	private Integer id;
	private String name;
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
	public Student() {
	}
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
