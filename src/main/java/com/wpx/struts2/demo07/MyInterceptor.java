package com.wpx.struts2.demo07;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 自定义拦截器多用于继承MethodFilterInterceptor
 * 因为此方法可以指定那些方法不被拦截
 * 
 * @author wangpx
 */
public class MyInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取登录明名称
		String name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		if(name==null || !name.equals("wangpx")) {
			BookAction action = (BookAction) invocation.getAction();
			action.addActionError(" 没有登录或者该用户的权限不足! ");
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
