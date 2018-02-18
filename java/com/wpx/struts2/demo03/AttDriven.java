package com.wpx.struts2.demo03;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ÊôÐÔÇý¶¯
 * @author wangpx
 */
public class AttDriven extends ActionSupport{

	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String show()  throws Exception{
	    HttpServletRequest request = ServletActionContext.getRequest();
	    request.setAttribute("username", username);
	    request.setAttribute("password", password);
	    return "main";
	}
}
