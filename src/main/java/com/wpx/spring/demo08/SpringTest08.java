package com.wpx.spring.demo08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @author wangpx
 */
public class SpringTest08 {
	
	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		City city=(City) applicationContext.getBean("city");
		System.out.println(city);
	}
}
