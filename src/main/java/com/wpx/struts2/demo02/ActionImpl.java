package com.wpx.struts2.demo02;

import com.opensymphony.xwork2.Action;

/**
 * 通过实现Action的接口成为Action
 * 
 * @author wangpx
 */
public class ActionImpl implements Action{

	@Override
	public String execute() throws Exception {	
		return SUCCESS;
	}

}
