package com.wpx.springmvc.demo07;

import java.util.Date;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author wangpx
 */
public class Person {
	
	@NotNull
	private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;


	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date birthday;


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", birthday=" + birthday + "]";
	}


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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
