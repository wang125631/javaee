package com.wpx.hibernate.demo05;
/**
 *  订单实体类
 * 
 * @author wangpx
 */
public class Order {
	
	private int oid;
	private String addr;
	private Customer customer;

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public Order() {
	
	}
	public Order(String addr, Customer customer) {
		super();
		this.addr = addr;
		this.customer = customer;
	}
	
}
