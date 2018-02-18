package com.wpx.servlet.demo23;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * 用户登录处理类
 * 
 * @author wangpx
 */
public class ServletLogin extends HttpServlet{

	private UserService UserService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = UserService.login(username, password);
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("/javaweb/servlet/filter/success.jsp");
		}else {
			req.setAttribute("login.message", "用户名或者密码错误 ! ");
			req.getRequestDispatcher("/servlet/filter/login.jsp").forward(req, resp);;
		}
	}

	
	
}
