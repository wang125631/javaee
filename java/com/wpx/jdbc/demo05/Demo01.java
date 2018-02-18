package com.wpx.jdbc.demo05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 通过java操纵数据库
 * 
 * 查询
 * 
 * @author wangpx
 */
public class Demo01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 加载mysql驱动
		Class.forName("com.mysql.jdbc.Driver");
		//定义要连接的数据库,账号,密码 
		String url="jdbc:mysql:///jdbc";
		String username="root";
		String password="root";
		//获取连接对象
		Connection connection = DriverManager.getConnection(url, username, password);
		//通过连接对象获取操作sql语句Statement
		Statement statement = connection.createStatement();
		//要执行的sql语句
		String sql="select * from emp";
		//对sql进行操作
		ResultSet resultSet = statement.executeQuery(sql);
		//创建集合
		ArrayList<Emp> empList = new ArrayList<Emp>();
		//遍历结果集
		while(resultSet.next()) { //判断是否有下一个元素
			Emp e=new Emp();//创建emp实体,用于接受遍历出的结果集
			e.setEid(resultSet.getInt("eid"));
			e.setEname(resultSet.getString("ename"));
			e.setSalary(resultSet.getDouble("salary"));
			e.setDno(resultSet.getInt("dno"));
			empList.add(e);
		}
		//打印集合
		empList.forEach(System.out::println);
		//释放资源
		resultSet.close();
		statement.close();
		connection.close();
	}
}
