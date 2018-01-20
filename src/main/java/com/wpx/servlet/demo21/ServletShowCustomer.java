package com.wpx.servlet.demo21;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 分页显示所有的页面
 * 
 * @author wangpx
 */
public class ServletShowCustomer extends HttpServlet{

	private CustomerService customerService=new CustomerService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String page=req.getParameter("currentPage");
		Integer currentPage=1;
		if(page == null) {
			currentPage=1;
		}else {
			currentPage = Integer.valueOf(page);
		}
		
		try {
			//分页查询相关信息
			PageBean findCustomerByPage = customerService.findCustomerByPage(15, currentPage);
			findCustomerByPage.setCurrentPage(currentPage);
			req.setAttribute("pageBean",findCustomerByPage);
			
			req.getRequestDispatcher("servlet/pagination/showCustomer.jsp").forward(req, resp);;
			
		} catch (SQLException | ParseException e) {
			req.setAttribute("show.message", "显示客户信息失败,请刷新重试!");
			e.printStackTrace();
		}
		
		
	}
	
	
}
