package com.wpx.mybatis.demo01.vo;

import java.util.Date;
/**
 * create table Person(
	  id number,
	  name varchar(20),
	  sex varchar(2),
	  birthday Date,
	  address varchar(40)
	);
 * 
 * @author wangpx
 */
public class Person {
	private int id;
	private String name;
	private String sex;
	private Date birthday;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + "]";
	}
	
}
