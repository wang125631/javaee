package com.wpx.hibernate.demo08;


import java.util.HashSet;
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
	private Set<Order> orders =new  HashSet<Order>();
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
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", orders=" + orders + "]";
	}

	
}
