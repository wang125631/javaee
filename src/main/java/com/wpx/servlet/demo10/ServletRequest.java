package com.wpx.servlet.demo10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求Request常用API
 * 
 * @author wangpx
 */
public class ServletRequest extends HttpServlet{

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
		//ip
		String ip=req.getRemoteAddr();
		System.out.println(ip);
		//请求方式
		String method = req.getMethod();
		System.out.println(method);
		//获取路径
		String contextPath = req.getContextPath();
		System.out.println(contextPath);
		//请求求头来源
		String header = req.getHeader("referer");
		System.out.println(header);
		//获取用户代理/浏览器
		String user_agent = req.getHeader("user-agent");
		System.out.println(user_agent);
	}

}
