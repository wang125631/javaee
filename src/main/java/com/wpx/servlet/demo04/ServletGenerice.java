package com.wpx.servlet.demo04;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * <servlet>
		<servlet-name>ServletGenerice</servlet-name>
		<servlet-class>com.wpx.servlet.demo04.ServletGenerice</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletGenerice</servlet-name>
		<url-pattern>/servletGenerice</url-pattern>
	</servlet-mapping>
 * 
 * 原生的Servlet接口需要重写5个方法,而实际上我们大多只关心他的执行部分
 * 
 * @author wangpx
 */
public class ServletGenerice extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("GenericServlet 执行......");
	}

}
