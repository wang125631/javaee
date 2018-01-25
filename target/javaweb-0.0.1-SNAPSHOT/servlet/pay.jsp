<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结算页面</title>
</head>
<body>
<%
	//获取购物车
	Map<String,Integer> cart=(Map<String,Integer>)request.getSession().getAttribute("cart");
	//如果不为空则将其遍历否则,提示购物
	if(cart != null){
		Set<String> keys=cart.keySet();
		for(String key :keys){
%>
	<h3> 您购买的商品是<%=key%> 商品的数量是<%=cart.get(key) %> </h3>
<% 
		}
	}else{
%>
	<h1>你还么有购买任何物品,  <a href="servlet/cart.jsp">点击购物</a></h1>
<%
	}
%>

</body>
<!--1256317570@qq.com  -->
</html>