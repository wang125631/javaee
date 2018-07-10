package com.wpx.spring.demo05;

public class Person01 {
	private String name;
	private Car02 car02;
	public void setName(String name) {
		this.name = name;
	}
	public void setCar02(Car02 car02) {
		this.car02 = car02;
	}
	@Override
	public String toString() {
		return "Person01 [name=" + name + ", car02=" + car02 + "]";
	}
	
}
