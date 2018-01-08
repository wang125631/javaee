package com.wpx.jdbc.demo05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 通过java操纵数据库
 * 
 * 修改
 * 
 * @author wangpx
 */
public class Demo03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//要插入的数据
		Emp emp = new Emp(6, "ename6", 234d, 3);
		try {
			update(emp);
			System.out.println("修改成功");
		} catch (Exception e) {
			System.out.println("修改失败");
			e.printStackTrace();
		}
	}
	public static void update(Emp emp) throws Exception {
		// 加载mysql驱动
				Class.forName("com.mysql.jdbc.Driver");
				//定义要连接的数据库,账号,密码 
				String url="jdbc:mysql:///jdbc";
				String username="root";
				String password="root";
				//获取连接对象
				Connection connection = DriverManager.getConnection(url, username, password);
				//要执行的sql语句
				String sql="update emp set ename = ?,salary = ?,dno=?  where eid=?   ";
				//通过con来获取prepareStatement接口防止sql注入
				PreparedStatement prepareStatement = connection.prepareStatement(sql);

				prepareStatement.setString(1, emp.getEname());
				prepareStatement.setDouble(2, emp.getSalary());
				prepareStatement.setInt(3, emp.getDno());
				prepareStatement.setInt(4, emp.getEid());
				prepareStatement.executeUpdate();
				//释放资源
				prepareStatement.close();
				connection.close();
	}
}
