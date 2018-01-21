package com.wpx.struts2.demo03;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ModDriven extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String show()  throws Exception{
	    HttpServletRequest request = ServletActionContext.getRequest();
	    request.setAttribute("username", user.getUsername());
	    request.setAttribute("password", user.getPassword());
	    return "main";
	}
	
	
}
