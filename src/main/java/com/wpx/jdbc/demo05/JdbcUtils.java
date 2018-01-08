package com.wpx.jdbc.demo05;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author wangpx
 */
public class JdbcUtils {
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	
	static {
	URL="jdbc:mysql:///jdbc";
	DRIVERCLASS="com.mysql.jdbc.Driver";
	USERNAME="root";
	PASSWORD="root";
}
	static {
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static   Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
	
}
