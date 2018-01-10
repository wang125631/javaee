package com.wpx.servlet.demo05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <servlet>
		<servlet-name>InitParameter</servlet-name>
		<servlet-class>com.wpx.servlet.demo05.InitParameter</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>InitParameter</servlet-name>
		<url-pattern>/initParameter</url-pattern>
	</servlet-mapping>
 * 
 * 对于一些特定的数据,如不需要修改的一些菜单栏等,我们希望他在初始化的时候就被加载而不是第一次访问的时候
 * 
 * @author wangpx
 */
public class InitParameter extends HttpServlet{

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
		//通过MenuDao加载数据
		
		//...
		
		//通过response写到页面
		resp.setCharacterEncoding("gbk");
		resp.getWriter().write("菜单一");
		resp.getWriter().write("菜单一");
		
	}

	@Override
	public void init() throws ServletException {
		//初始化需要的参数化
		System.out.println("init  ....");
	}

	
	
}
