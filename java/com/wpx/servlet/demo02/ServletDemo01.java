package com.wpx.servlet.demo02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
	web.xml的配置如下
	表示:
	拦截到请求url为/servletDemo01后会交由Servlet名为ServletDemo01的Servlet处理
	
	名为ServletDemo01的Servlet会找到特定的类进行处理
		要求该类配置为全路径,继承HttpServlet,重写doGet,doPost方法
	
	
 	<servlet>
		<servlet-name>ServletDemo01</servlet-name>
		<servlet-class>com.wpx.servlet.demo02.ServletDemo01</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletDemo01</servlet-name>
		<url-pattern>/servletDemo01</url-pattern>
	</servlet-mapping>
	
 * @author wangpx
 */
public class ServletDemo01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet .....");
	}

}
