package com.wpx.spring.demo04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
@SuppressWarnings("all")
public class CustomerServiceImpl implements CustomerService,BeanNameAware,
	ApplicationContextAware,InitializingBean,DisposableBean{
	
	private String name;
	public void add() {
		 System.out.println("add customer ....");
	}

	public void find() {
		System.out.println("find customer ....");
	}
	public CustomerServiceImpl() {
		super();
		System.out.println("第一步:实例化类...");
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("第二步:属性的注入...");
	}
	public void setBeanName(String name) {
		 System.out.println("第三步:注入配置的类的名称"+name);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("第四步:注入applicationContext "+applicationContext);
	}

	public void afterPropertiesSet() throws Exception {
		
	}

	public void destroy() throws Exception {

	}



}
