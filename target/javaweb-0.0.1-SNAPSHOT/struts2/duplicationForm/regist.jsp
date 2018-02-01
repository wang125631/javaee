<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册页面</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/registAction.action" method="get">
	<s:token/>
	username: <input type="text" name="username">
	password: <input type="password" name="password">
	<input type="submit" value="用户注册">
</form>
</body>
<!--1256317570@qq.com  -->
</html>