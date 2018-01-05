package com.wpx.spring.demo06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ¼¯ºÏBean
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest06 {

	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionBean collectionBean=(CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}
