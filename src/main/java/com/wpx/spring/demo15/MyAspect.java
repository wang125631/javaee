package com.wpx.spring.demo15;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 * @author wangpx
 */
public class MyAspect {

	public void before() {
		System.out.println("前置通知...");
	}
	public void afterReturning(Object returnVal) {
		System.out.println("后置通知..."+returnVal);
	}
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前通知...");
		Object result=proceedingJoinPoint.proceed();
		System.out.println("环绕后通知...");
		return result;
	}
	public void afterThrowable(Throwable e) {
		System.out.println("异常通知"+e.getMessage());
	}
	public void after() {
		System.out.println("最终通知...");
	}
}
