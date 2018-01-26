package com.wpx.hibernate.demo05;
/**
 *  订单实体类
 * 
 * @author wangpx
 */
public class Order {
	
	private int id;
	private String addr;
	private Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
