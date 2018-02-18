package com.wpx.hibernate.demo07;

/**
 * 部门实体类
 * 
 * @author wangpx
 */
public class Dep {

	private int did;
	private String dname;
	private Manager manager;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Dep() {
		
	}

	public Dep(String dname) {
		super();
		this.dname = dname;
	}
	
}
