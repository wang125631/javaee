package com.wpx.spring.demo09;

import org.junit.Test;

/**
 * 
 * @author wangpx
 */
public class SpringTest09 {
	
	//传统方式添加日志
	@Test
	public void demo01() {
		UserDao userDao = new UserDaoImpl();
		userDao.add();
		System.out.println("log4j:add....");
		userDao.update();
	}
	//通过代理添加
	@Test
	public void demo02() {
		//被代理的对象
		UserDao userDao=new UserDaoImpl();
		//创建代理对象
		UserDao proxy=new JDKProxy(userDao).createProxy();
		proxy.add();
		proxy.update();
	}
}
