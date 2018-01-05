package com.wpx.spring.demo10;

import org.junit.Test;

/**
 * 基于cglib代理
 * 与jdk代理不同,cglib代理不需要被代理对象实现接口
 * @author wangpx
 */
public class SpringTest10 {

	@Test
	public void demo01() {
		ProductDao productDao = new ProductDao();
		ProductDao proxy=new CglibProxy(productDao).createProxy();
		proxy.add();
		proxy.delete();
	}
}
