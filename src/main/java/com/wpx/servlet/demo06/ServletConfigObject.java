package com.wpx.servlet.demo06;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <servlet>
		<servlet-name>ServletConfigObject</servlet-name>
		<servlet-class>com.wpx.servlet.demo06.ServletConfigObject</servlet-class>
		<init-param>
			<param-name>username</param-name>
			<param-value>wpx</param-value>
		</init-param>
		<init-param>
			<param-name>password</param-name>
			<param-value>123456</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletConfigObject</servlet-name>
		<url-pattern>/servletConfigObject</url-pattern>
	</servlet-mapping>
 * 
 * @author wangpx
 */

public class ServletConfigObject extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 先获取ServletConfig对象
		ServletConfig servletConfig = getServletConfig();
		System.out.println("Servlet的名称: "+servletConfig.getServletName());
		//获取初始化的参数
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		System.out.println("username is :" +username +"  and password is "+ password);
	
		Enumeration initParameterNames = servletConfig.getInitParameterNames();
			while(initParameterNames.hasMoreElements()) {
				String name= (String) initParameterNames.nextElement();
				String value = servletConfig.getInitParameter(name);
				System.out.println(name+":"+value);
			}
	}
}
