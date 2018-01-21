<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通过pojo加载参数</title>
</head>
<body>


	<form action="${pageContext.request.contextPath}/pojoAttDriven.action" method="post">
		username:<input type="text" name="user.username"><br>
		password:<input type="password" name="user.password"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>