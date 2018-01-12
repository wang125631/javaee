package com.wpx.servlet.demo12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author wangpx
 */
public class ServletRedirectAndDispatcher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", "name01");
		request.getRequestDispatcher("/servlet/302.jsp").forward(request, response);
		//response.sendRedirect("/servlet/302.jsp");
	}

	
	
}
