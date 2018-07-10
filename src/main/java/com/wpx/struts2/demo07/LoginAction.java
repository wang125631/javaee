package com.wpx.struts2.demo07;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户登录
 * 
 * @author wangpx
 */
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

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
	
	public String login() {
		
		if(username.equals("wangpx")&&password.equals("123456")) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("name", "wangpx");
			return SUCCESS;
		}else {
			this.addFieldError("login.message", "用户名或者密码错误 ! ");
			return LOGIN;
		}
	}
	
}
