package com.wpx.hibernate.demo07;
/**
 * 经理实体类
 * 
 * @author wangpx
 */
public class Manager {

	private int mid;
	private String mname;
	private Dep dep;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}
	public Manager() {
	}
	public Manager(String mname) {
		super();
		this.mname = mname;
	}
	
}
