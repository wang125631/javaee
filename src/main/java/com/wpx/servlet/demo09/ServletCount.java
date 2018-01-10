package com.wpx.servlet.demo09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 用于统计网站的访问次数
 * 
 * 
 * @author wangpx
 */
public class ServletCount extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("count", 0);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/**
	 * 每一次访问，都会执行该方法。
	 * 拿出count的变量，值自增，存入到域对象中
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer count = (Integer) getServletContext().getAttribute("count");
		getServletContext().setAttribute("count", ++count);
		// 向页面输出内容
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("第"+count+"次访问");
	}
}

