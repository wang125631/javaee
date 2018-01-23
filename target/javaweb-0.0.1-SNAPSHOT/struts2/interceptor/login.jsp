<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
</head>
<body>
<h5>用户名wangpx 密码 123456</h5>
<form action="${pageContext.request.contextPath}/loginAction.action">
	Username :<input type="text" name="username">
	Password :<input type="password" name="password"><br>
	<font color="red"><s:fielderror name="login.message"/></font>
	<font color="red"><s:actionerror /></font>
	<input type="submit" value="登录">
</form>
</body>
</html>