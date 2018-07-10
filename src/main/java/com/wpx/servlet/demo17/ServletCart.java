package com.wpx.servlet.demo17;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 通过Session 来实现购物车功能
 * 常见如美团外卖
 * @author wangpx
 */
public class ServletCart extends HttpServlet{

	private static final long serialVersionUID = -1229999864730298789L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受后台参数
		String id = req.getParameter("id");
		// 购物列表
		String[] names = {"金针菇","韭菜","鲜鸡肾","羊肉串","牛肉串"};
		//根据参数获取具体商品
		String productName = names[Integer.parseInt(id)];
		//从session 中获取购物车
		HttpSession session = req.getSession();
		Map<String,Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		if(cart ==null){
			//第一次则新建购物车
			cart=new HashMap<String,Integer>();
			cart.put(productName, 1);
			//存入到session中
			session.setAttribute("cart", cart);
		}else {
			//如果不是第一次访问则判断是够包含产品
			//如果包含
			if(cart.containsKey(productName)) {
				//获取商品数量
				Integer count = cart.get(productName);
				//将商品数量加1
				count++;
				//更新购物车
				cart.put(productName, count);
				//将购物车放到session中
				session.setAttribute("cart", cart);
			}else {//如果不包含
				cart.put(productName, 1);
				session.setAttribute("cart", cart);
			}
		}
		//继续购物或者去结算
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("您可以选择  <a href='servlet/Cart.jsp'>继续购物</a>  或者   <a href='servlet/pay.jsp'>去结算</a>");
	}

}
