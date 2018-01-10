package com.wpx.servlet.demo08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面的定时跳转
 * 
 * @author wangpx
 */
public class ServletRefresh extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html;charset=utf-8");
		 resp.getWriter().print("3秒钟后自动跳转  ...");
		 resp.setHeader("refresh", "3;url=servlet/302.html");
	
	}

	
	
}
