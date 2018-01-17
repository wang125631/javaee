package com.wpx.servlet.demo21;

import java.util.List;

/**
 * 用于分页的类
 * 
 * @author wangpx
 */
public class PageBean {

	private int pageNum; //页码
	private int currentPage; //当前页
	private int totalPage; //总页数
	private int totalCount; //总记录数
	private List<Customer> csList;//每页数据
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<Customer> getCsList() {
		return csList;
	}
	public void setCsList(List<Customer> csList) {
		this.csList = csList;
	}
	
	
}
