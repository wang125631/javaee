package com.wpx.spring.demo05;

public class Car02 {
	private String name;
	private Double price;
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car02 [name=" + name + ", price=" + price + "]";
	}
	
}
