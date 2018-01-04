package com.wpx.spring.demo03;

public class Product {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public void init() {
		System.out.println("Product init ....");
	}
	public void destory() {
		System.out.println("Product destory ....");
	}
	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}
	
	
}
