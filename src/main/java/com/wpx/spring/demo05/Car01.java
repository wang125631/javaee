package com.wpx.spring.demo05;

public class Car01 {
	private String name;
	private Double price;
	public Car01() {
		super();
	}
	public Car01(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car01  [name=" + name + ", price=" + price + "]";
	}
	
	
}
