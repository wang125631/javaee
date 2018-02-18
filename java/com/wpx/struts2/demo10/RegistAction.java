package com.wpx.struts2.demo10;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * 
 * @author wangpx
 */
public class RegistAction extends ActionSupport{

	private String username;
	private String password;
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
	
	@Override
	public String execute() throws Exception {
		System.out.println("username is "+username +" and password is "+password);
		return null;
	}
}
