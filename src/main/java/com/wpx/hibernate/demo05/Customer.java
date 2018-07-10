package com.wpx.hibernate.demo05;


import java.util.Set;

/**
 * 客户实体类
 * 
 * @author wangpx
 */
public class Customer {

	private int cid;
	private String name;
	private int age;
	private Set<Order> orders;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Customer() {
	
	}
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	
}
