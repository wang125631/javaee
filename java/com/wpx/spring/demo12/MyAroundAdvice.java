package com.wpx.spring.demo12;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 * 
 * @author wangpx
 */
public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("方法执行前.....");
		Object obj=invocation.proceed();//执行目标方法
		System.out.println("方法执行后......");
		return obj;
	}



}
