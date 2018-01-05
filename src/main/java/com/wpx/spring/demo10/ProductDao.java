package com.wpx.spring.demo10;
/**
 * 被代理对象
 * @author wangpx
 */
public class ProductDao {

	public void add() {
		System.out.println("add ... ");
	}
	
	public void delete() {
		System.out.println("delete ... ");
	}
}
