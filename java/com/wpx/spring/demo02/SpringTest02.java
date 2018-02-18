package com.wpx.spring.demo02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring的实例化
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest02 {

	//// 无参数的构造方法的实例化
	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean01 bean01=(Bean01) applicationContext.getBean("bean01");
		System.out.println(bean01);
	}
	// 静态工厂实例化
	@Test
	public void demo02(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean02 bean02=(Bean02) applicationContext.getBean("bean02");	
		System.out.println(bean02);
	}
	// 实例工厂实例化
	@Test
	public void demo03() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Bean03 bean03 = (Bean03) applicationContext.getBean("bean03");
		System.out.println(bean03);
	}
}
