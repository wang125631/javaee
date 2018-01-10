package com.wpx.servlet.demo11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author wangpx
 */
public class JdbcUtils {
	
	/**
	 * 连接数据库
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// 加载mysql驱动
		Class.forName("com.mysql.jdbc.Driver");
		//定义要连接的数据库,账号,密码 
		String url="jdbc:mysql:///jdbc";
		String username="root";
		String password="root";
		//获取连接对象
		Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
	}
	/**
	 * 关闭连接
	 * @param con
	 * @throws SQLException
	 */
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}

