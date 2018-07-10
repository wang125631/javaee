package com.wpx.spring.demo09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理
 * @author wangpx
 */
public class JDKProxy implements InvocationHandler{

	private UserDao userDao;

	public JDKProxy(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	public UserDao createProxy() {
		UserDao proxy=(UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);
		return proxy;
	}
	// 调用目标对象的任何一个方法 都相当于调用invoke();
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("add".equals(method.getName())) {
			System.out.println("log4j: add .......");
			Object result=method.invoke(userDao, args);
			return result;
		}
		return method.invoke(userDao, args);
	}

}
