package com.wpx.struts2.demo04;

import java.util.Arrays;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author wangpx
 */
public class ConvertorAction  extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private int age;
	private Date birthday;
	private String[] hobby;

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String execute() throws Exception {

		System.out.println(this.toString());

		return null;
	}

	@Override
	public String toString() {
		return "RegistAction [username=" + username + ", password=" + password
				+ ", age=" + age + ", birthday=" + birthday + ", hobby="
				+ Arrays.toString(hobby) + "]";
	}
}
