package com.wpx.struts2.demo03;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ÊôÐÔÇý¶¯
 * @author wangpx
 */
@SuppressWarnings("all")
public class PojoAttDriven extends ActionSupport{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String show()  throws Exception{
	    HttpServletRequest request = ServletActionContext.getRequest();
	    request.setAttribute("username", user.getUsername());
	    request.setAttribute("password", user.getPassword());
	    return "main";
	}
	
}
