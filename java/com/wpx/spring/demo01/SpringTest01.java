package com.wpx.spring.demo01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 主程序 加载spring配置文件将name属性值注入
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest01 {
	//传统方式
	@Test
	public void demo01() {
		HelloServiceImpl helloSeriviceImpl = new HelloServiceImpl();
		helloSeriviceImpl.setName("wpx");
		helloSeriviceImpl.say();
	}
	//Spring通过加载applicationContext文件注入
	@Test
	public void demo02() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService helloSerivice=(HelloService) applicationContext.getBean("helloService");
		helloSerivice.say();
	}
	// 加载磁盘路径下的配置文件:
	@Test
	public void demo03() {
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\nodejs\\javaee\\src\\main\\resources/applicationContext.xml");
		HelloService helloService=(HelloService) applicationContext.getBean("helloService");
		helloService.say();
	}
	
}
