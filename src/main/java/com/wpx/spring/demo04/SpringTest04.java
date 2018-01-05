package com.wpx.spring.demo04;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的完整生命周期
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest04 {
	@Test
	public void demo01() {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService	customerService=(CustomerService) applicationContext.getBean("customerService");
		customerService.add();
		customerService.find();
		applicationContext.close();
	}
}
