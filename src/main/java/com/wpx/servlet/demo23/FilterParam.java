package com.wpx.servlet.demo23;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Filter类
 * 
 * @author wangpx
 */
public class FilterParam implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init ...");
		//获取Filter名称
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);
		//获取初始化化参数
		Enumeration<String> names = filterConfig.getInitParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		//获取ServletContext对象
		filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("Filter 开始执行 .....");
			//判断
			if(1<0) {
				request.getRequestDispatcher("转发到新的页面");
			}
			//放行
			chain.doFilter(request, response);
			
	}
	

	@Override
	public void destroy() {
		 System.out.println("Filter destoy .....");
	}

}
