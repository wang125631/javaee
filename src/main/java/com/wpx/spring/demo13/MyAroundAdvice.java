package com.wpx.spring.demo13;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("方法执行前...");
		Object obj = invocation.proceed();//执行方法
		System.out.println("方法执行后...");
		return  obj;
	}

}
