package com.wpx.struts2.demo09;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 给值栈赋值
 * 
 * @author wangpx
 */
public class OgnlAction02 extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//获取值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//为值栈赋值
		valueStack.set("name", "wangpx");
		//压栈
		valueStack.push("Hello ValueStack");
		return SUCCESS;
	}
}
