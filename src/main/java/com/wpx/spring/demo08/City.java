package com.wpx.spring.demo08;

public class City {
	private String name;
	private int code;
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "City [name=" + name + ", code=" + code + "]";
	}
	
}
