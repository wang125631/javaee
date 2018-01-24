<%@page import="com.wpx.servlet.demo18.MyCookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>商品信息</title>
<style type="text/css">
		.img1{
			width: 160px;
			height: 140px;
		}
		.img2{
			width: 80px;
			height: 70px;
		}
	
	</style>
</head>
<body>
	<img class="img1" src="/javaweb/images/0.jpg"><a href="/javaweb/servletGoods?id=0">金针菇</a>
	<img class="img1" src="/javaweb/images/1.jpg"><a href="/javaweb/servletGoods?id=1">韭菜</a>
	<img class="img1" src="/javaweb/images/2.jpg"><a href="/javaweb/servletGoods?id=2">鲜鸡肾</a><br>
	<img class="img1" src="/javaweb/images/3.jpg"><a href="/javaweb/servletGoods?id=3">羊肉串</a>
	<img class="img1" src="/javaweb/images/4.jpg"><a href="/javaweb/servletGoods?id=4">牛肉串</a>
	
	<h3>浏览记录</h3>
	<h3><a href="/javaweb/servletRemove">清除记录</a></h3>
<%
	//获取cookie
	Cookie [] cookies = request.getCookies();
	//查找指定cookie
	Cookie cookie = MyCookieUtils.getCookieByName(cookies, "javaee_goods");
	//判断cookie是否为空
	if(cookie != null){
		//获取cookie的值
		String value = cookie.getValue();
		//通过,分割
		String[] values = value.split(",");
		for(String id : values){
%>
	<img class="img2" src="/javaweb/images/<%= id%>.jpg"><br/>
	
<%
		}
	}
%>
</body>
<!--1256317570@qq.com  -->
</html>