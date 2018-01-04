package com.wpx.spring.demo01;
/**
 * 实现接口
 * 为属性name提供set方法
 * 
 * @author wangpx
 */
public class HelloServiceImpl implements HelloService{
	String name;
	public void setName(String name) {
		this.name = name;
	}
	public void say() {
		System.out.println("Hello "+name);
	}

}
