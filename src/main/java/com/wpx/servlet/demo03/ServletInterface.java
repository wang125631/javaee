package com.wpx.servlet.demo03;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 通过实现Servlet接口来成为一个Servlet
 * 
 * 生命周期：实例被创建，对外提供服务，销毁。
	* Servlet被创建后，然后调用init方法进行初始化
		void init(ServletConfig config) 
	* 从客户端发送所有的请求是service方法进行处理的。
		void service(ServletRequest req, ServletResponse res)  
	* 从服务器中移除服务，调用destroy方法。
		void destroy()  

 	* Servlet的生命周期：第一次请求的时候，Servlet实例被创建，立即调用init方法进行初始化。
						实例通过service方法提供服务。服务器关闭或者移除服务时，调用destroy方法进行销毁
						
						
		一次出生,一次死亡,多次工作				
		
 * @author wangpx
 */
public class ServletInterface implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet 初始化");
	}

	@Override
	public ServletConfig getServletConfig() {
		 System.out.println("Servlet 获取配置信息...");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 System.out.println("Servlet 工作...");
	}

	@Override
	public String getServletInfo() {
		 System.out.println("获取Servlet 信息....");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("Servlet 销毁...");
	}

}
