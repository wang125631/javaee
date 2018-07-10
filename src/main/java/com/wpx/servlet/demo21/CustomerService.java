package com.wpx.servlet.demo21;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * 客户服务类
 * 
 * @author wangpx
 */
public class CustomerService {

	private CustomerDao customerDao=new CustomerDao();

	//查询总记录数
	public int getCustomerCount() throws SQLException {
		 Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDao.findAllCount(connection);
	}
	
	//添加用户
	public void addCustomer(Customer customer) throws SQLException {
		 Connection connection = null;
			try {
				connection = JdbcUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		customerDao.add(connection, customer);
	}
	
	//分页查询客户信息
	public PageBean findCustomerByPage(int pageNum,int currentPage) throws SQLException, ParseException{
		 Connection connection = null;
			try {
				connection = JdbcUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		//查询总记录数
		 int count = customerDao.findAllCount(connection);
		 //查询当前页的
		List<Customer> customerList=customerDao.findAll(connection, pageNum, currentPage);
		 //查询总页数
		int totalPage = (int) Math.ceil(count*1.0 / pageNum);
		PageBean pageBean=new PageBean();
		pageBean.setCsList(customerList);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(count);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
}
