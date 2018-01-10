package com.wpx.servlet.demo11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * 用户接口实现
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao{

	private Connection connection = null;
	
	@Override
	public void login(User user) {
		try {
			connection= JdbcUtils.getConnection();
			String sql="SELECT username,PASSWORD FROM t_user WHERE username=? AND PASSWORD= ? ";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			ResultSet rs = prepareStatement.executeQuery();
			if(rs.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登陆失败");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
