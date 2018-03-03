package com.wpx.oracle.proandtri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	private static String diver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521/root";
	private static String user = "scott";
	private static String password = "tiger";
	
	static {
		try {
			Class.forName(diver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("¡¨Ω” ß∞‹");
			e.printStackTrace();
		}
		return null;
	}
	 
	public static void release(Connection conn,Statement st,ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				st = null;
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
	}

}
