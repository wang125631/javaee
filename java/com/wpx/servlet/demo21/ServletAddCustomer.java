package com.wpx.servlet.demo21;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 添加客户处理类
 * 
 * @author wangpx
 */
public class ServletAddCustomer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		CustomerService service = new CustomerService();
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String birthday = req.getParameter("birthday");
		String cellphone = req.getParameter("cellphone");
		
		String email = req.getParameter("email");
		String preference = req.getParameter("preference");
		String type = req.getParameter("type");
		String description = req.getParameter("description");
		
		Customer customer=new Customer();
		try {
			
			customer.setId(IdUtils.getUUID());
			customer.setName(name);
			customer.setGender(gender);
			customer.setBirthday(DateUtils.formatString(birthday));
			
			customer.setCellphone(cellphone);
			customer.setEmail(email);
			customer.setPreference(preference);
			customer.setType(type);
			
			customer.setDescription(description);
			
			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			service.addCustomer(customer);
			resp.sendRedirect("/javaweb/servlet/pagination/success.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("add.message", "添加失败!  ");
			req.getRequestDispatcher("/javaweb/servlet/pagination/addCustomer.jsp");
		}
	}

	
}
