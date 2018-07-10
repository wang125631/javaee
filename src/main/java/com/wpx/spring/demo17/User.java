package com.wpx.spring.demo17;
/**
 * ”√ªß¿‡
 * @author wangpx
 */
public class User {
	private Integer id;
	private String name;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String name) {
		this.name = name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
