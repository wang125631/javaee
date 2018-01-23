package com.wpx.struts2.demo06;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 国际化
 * 
 * @author wangpx
 */
public class ActionI18n extends ActionSupport{
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//动态文本
		System.out.println(this.getText("message", new String[] {"Tom","jack"}));
		return SUCCESS;
	}

}
