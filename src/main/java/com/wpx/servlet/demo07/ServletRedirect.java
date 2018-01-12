package com.wpx.servlet.demo07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过Servlet进行重定向
 * 
 * @author wangpx
 */
public class ServletRedirect extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置头
		resp.setContentType("text/html;charset=utf-8");
		//设置状态
		resp.setStatus(302);
		//要跳转的地址
		resp.setHeader("location", "servlet/302.jsp");
	}

}
