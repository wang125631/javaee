package com.wpx.servlet.demo13;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet 中乱码问题
 * 
 * @author wangpx
 */
public class ServletCharset extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//demo01(resp);
		demo02(resp);
	}
	/**
	 * 字符流
	 * @throws IOException 
	 */
	public void demo01(HttpServletResponse resp) throws IOException {
		//resp.setContentType("text/html;charset=utf-8");
		//设置缓冲区编码
		resp.setCharacterEncoding("utf-8");
		//设置浏览器打开文件所采用的编码
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.getWriter().print("汉字");
	}
	/**
	 * 字节流
	 * @throws IOException 
	 */
	public void demo02(HttpServletResponse resp) throws IOException {
		//设置浏览器打开文件时编码
		resp.setContentType("text/html;charset=utf-8");
		//通过response 获取输出流
		ServletOutputStream outputStream = resp.getOutputStream();
		//通过字节流打印汉字 设置字符集为utf-8
		outputStream.write("汉字".getBytes("utf-8"));
	}
	
	

}
