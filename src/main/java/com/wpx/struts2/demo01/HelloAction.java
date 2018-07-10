package com.wpx.struts2.demo01;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * struts2的默认执行方法为execute方法
 * 
 * 通过继承ActionSupport 成为一个
 * 
 * @author wangpx
 */
public class HelloAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	
}
