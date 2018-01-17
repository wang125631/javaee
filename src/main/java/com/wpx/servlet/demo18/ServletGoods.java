package com.wpx.servlet.demo18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商品的处理类
 * 用于记录商品的浏览信息
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ServletGoods extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//可以将cookie看做Map的数组集合
		//获取前端传入的参数
		String id = req.getParameter("id");
		//获取所有cookie从中查找特定的cookie
		Cookie[] cookies = req.getCookies();
		//获取到特定的cookie
		Cookie cookieByName = MyCookieUtils.getCookieByName(cookies, "javaee_goods");
		//判断cookie是否为空
		if(cookieByName==null) {
			//没有则新建cookie
			Cookie cookie = new Cookie("javaee_goods", id);
			//设置有效期
			cookie.setMaxAge(60*60*24);
			//设置path
			cookie.setPath("/");
			//回写cookie
			resp.addCookie(cookie);
		}else {
			//如果不是第一次访问则,获取到值
			String value = cookieByName.getValue();
			//将value值通过,分割开来
			String[] splitValue = value.split(",");
			if(!isContain(splitValue, id)) {
			//如果不包含则将其添加
			cookieByName.setValue(value+","+id);
			//设置有效期
			cookieByName.setMaxAge(24*60*60);
			//设置路径
			cookieByName.setPath("/");
			//回写
			resp.addCookie(cookieByName);
			}
		}
		resp.sendRedirect("servlet/goodsList.jsp");
	
	}
	private boolean isContain (String[] values,String id) {
		for (String string : values) {
			if(string.equals(id)) {
				return true;
			}
		}
		return false;
	}

}
