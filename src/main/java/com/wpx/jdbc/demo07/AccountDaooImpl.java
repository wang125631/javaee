package com.wpx.jdbc.demo07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountDaooImpl implements AccountDao{

	@Override
	public void in(Connection con, String to, int money) {
		try {
			
			String sql="UPDATE account SET money =money + ? WHERE NAME= ? ";
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setInt(1, money);
			prepareStatement.setString(2, to);
			prepareStatement.executeUpdate();
			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public void out(Connection con, String from, int money) {
		try {
			//¿ªÆôÊÂÎñ
			con.setAutoCommit(false);
			String sql="UPDATE account SET money =money - ? WHERE NAME= ? ";
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setInt(1, money);
			prepareStatement.setString(2, from);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	

}
