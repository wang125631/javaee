package com.wpx.spring.demo02;
/**
 * 使用静态工厂的方式实例化
 * @author wangpx
 */
public class BeanFactory02 {
	public static Bean02 getInstance() {
		System.out.println("使用静态工厂创建的Bean02....");
		return new Bean02();
	}
}
