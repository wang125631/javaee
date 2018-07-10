package com.wpx.servlet.demo23;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class FilterLogin implements Filter{

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 System.out.println("init ....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session = req.getSession(); 
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			 chain.doFilter(request, response);
		 }
		req.getRequestDispatcher("/servlet/filter/login.jsp").forward(request, response);;
	}

	@Override
	public void destroy() {
		System.out.println("destory ...");
	}

}
