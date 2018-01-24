<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模型驱动</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/modDriven.action" method="post">
		username:<input type="text" name="username"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="登录">
	</form>
</body>
<!--1256317570@qq.com  -->
</html>