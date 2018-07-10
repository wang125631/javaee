package com.wpx.servlet.demo11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
	
	use jdbc;
	 
	 CREATE TABLE t_user(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	username VARCHAR(20),
	PASSWORD VARCHAR(20)
	)

	INSERT INTO t_user VALUES (NULL,'wpx','123');

 * 
 * 
 * 通过Servlet来模拟登陆功能的实现
 * 
 * @author wangpx
 */
public class ServletLogin extends HttpServlet{

	private UserDao userDao=new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user=new User (username,password);
		userDao.login(user);		
	}

}
