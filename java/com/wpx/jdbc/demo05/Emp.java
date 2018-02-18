package com.wpx.jdbc.demo05;
/**
 * 与数据表对应的员工表
 * 
 * @author wangpx
 */
public class Emp {

	private int eid;
	private String ename;
	private Double salary;
	private int dno;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	public Emp() {
		
	}
	public Emp(int eid, String ename, Double salary, int dno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.dno = dno;
	}
	@Override
	public String toString() {
		return "emp [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", dno=" + dno + "]";
	}
	
}
