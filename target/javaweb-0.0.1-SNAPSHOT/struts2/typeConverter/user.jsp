<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户表单页面</title>
<script language="javascript" type="text/javascript" src="../../My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/convertorAction" method="post">
	username: <input type="text" id="username" name="username"><br>
	password: <input type="text" id="password" name="password">
	age: <input type="text" id="age" name="age">
	birthday: <input type="text" class="Wdate" onclick="WdatePicker()" readonly="readonly" >
	hobby:  <input type="checkbox" name="hobby" value="java">Java
			<input type="checkbox" name="hobby" value="scala">scala
			<input type="checkbox" name="hobby" value="python">python
			<input type="checkbox" name="hobby" value="ruby"> ruby
	<input type="submit" value="登录" >
</form>
</body>
</html>