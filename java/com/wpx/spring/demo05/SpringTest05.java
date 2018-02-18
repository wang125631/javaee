package com.wpx.spring.demo05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SuppressWarnings("all")
public class SpringTest05 {

	//构造方式
	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Car01 car01=(Car01) applicationContext.getBean("car01");
		System.out.println(car01);
	}
	@Test
	public void demo02() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Car02 car02=(Car02) applicationContext.getBean("car02");
		System.out.println(car02);
	}
	@Test
	public void demo03() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person01 person = (Person01) applicationContext.getBean("person01");
		System.out.println(person);
	}
}
