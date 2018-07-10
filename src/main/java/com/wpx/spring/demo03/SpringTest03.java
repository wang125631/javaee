package com.wpx.spring.demo03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的作用范围
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest03 {
	// 测试Scope
	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer01=(Customer) applicationContext.getBean("customer");
		Customer customer02=(Customer) applicationContext.getBean("customer");
		System.out.println(customer01==customer02);
	}
	//测试spring的生命周期
	@Test
	public void demo02() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Product product=(Product) applicationContext.getBean("product");
		product.destory();
	}
	
}
