package com.wpx.spring.demo07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解的方式:
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest07 {

	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		userService.say();
	}
}
