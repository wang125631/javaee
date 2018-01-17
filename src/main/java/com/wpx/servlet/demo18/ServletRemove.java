package com.wpx.servlet.demo18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于移除所有的用户记录
 * 
 * @author wangpx
 */
public class ServletRemove extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie=new Cookie("javaee_goods","");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		resp.addCookie(cookie);
		resp.sendRedirect("servlet/goodsList.jsp");
	}

	
}
