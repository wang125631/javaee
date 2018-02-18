package com.wpx.spring.demo14;
/**
 * 切面类:就是切点与增强结合
 * 
 * @author wangpx
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class MyAspect {

	//前置通知
	@Before("execution(* com.wpx.spring.demo14.PersonDao.add(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("前置通知  "+joinPoint);
	}
	//后置通知
	@AfterReturning(value="execution(* com.wpx.spring.demo14.PersonDao.update(..))",returning="returnVal")
	public void afterReturning(Object returnVal) {
		System.out.println("后置通知  "+returnVal);
	}
	//环绕通知
	@Around(value="MyAspect.myPointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕前通知...");
		Object obj=proceedingJoinPoint.proceed();
		System.out.println("环绕后通知...");
		return obj;
	}
	//异常处理
	@AfterThrowing(value="execution(*  com.wpx.spring.demo14.PersonDao.ex(..))",throwing="e")
	public void ex(Throwable e) {
		System.out.println("异常  "+e.getMessage());
	}
	//最终通知
	@After("MyAspect.myPointcut()")
	public void after() {
		System.out.println("最终通知");
	}
	
	//切点
	@Pointcut("execution(* com.wpx.spring.demo14.PersonDao.find(..))")
	private void myPointcut() {	}
}
