package com.wpx.struts2.demo09;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author wangpx
 */
public class OgnlAction03 extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//创建学生集合
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "wangpx01"));
		studentList.add(new Student(2, "wangpx02"));
		studentList.add(new Student(3, "wangpx03"));
		//获取值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//将数据存储到值栈中
		valueStack.set("studentList", studentList);
	
		return SUCCESS;
	}
}
