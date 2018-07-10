package com.wpx.hibernate.demo06;

import java.util.Set;

/**
 * 课程实体类
 * 
 * @author wangpx
 */
public class Course {

	private int cid;
	private String cname;
	private Set<Student> students;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Course() {
	}
	public Course(String cname) {
		super();
		this.cname = cname;
	}
	
	

}
