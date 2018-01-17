package com.wpx.servlet.demo21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户接口
 * 
 * @author wangpx
 */
public class CustomerDao {

	//分页查询所有的客户
	public List<Customer> findAll(Connection connection,int pageNum,int currentPage) throws SQLException, ParseException{
		String sql="select * from customer limit ?,? ";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, (currentPage-1)*pageNum);
		prepareStatement.setInt(2, pageNum);
		ResultSet resultSet = prepareStatement.executeQuery();
		List<Customer> customerList=new ArrayList<Customer>();
		if(resultSet.next()) {
			Customer c=new Customer();
			c.setId(resultSet.getString("id"));
			c.setName(resultSet.getString("name"));
			c.setGender(resultSet.getString("gender"));
			c.setBirthday(DateUtils.formatString(resultSet.getString("birthday")));
			c.setCellphone(resultSet.getString("cellphone"));
			c.setEmail(resultSet.getString("email"));
			c.setPreference(resultSet.getString("perference"));
			c.setType(resultSet.getString("type"));
			c.setDescription(resultSet.getString("description"));
			customerList.add(c);
		}
		return customerList;
	}
	//添加用户
	public void add(Connection connection,Customer customer) throws SQLException {
		String sql="insert into customer values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1,customer.getId());
		prepareStatement.setString(2,customer.getName());
		prepareStatement.setString(3,customer.getGender());
		prepareStatement.setString(4,DateUtils.formatDate(customer.getBirthday()));
		prepareStatement.setString(5,customer.getCellphone());
		prepareStatement.setString(6,customer.getEmail());
		prepareStatement.setString(7,customer.getPreference());
		prepareStatement.setString(8,customer.getType());
		prepareStatement.setString(9,customer.getDescription());
		prepareStatement.executeUpdate();
	}
	//查询总记录数
	public int findAllCount(Connection connection) throws SQLException {
		String sql="SELECT COUNT(*) COUNT FROM customer";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery();
		return resultSet.getInt("count");
	}
	
}
