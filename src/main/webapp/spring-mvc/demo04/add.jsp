<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户信息</title>
</head>
<body>
<form action="emp" method="post">
	<div style="padding-top: 280px" align="center">
		姓名: <input name="name"><br>
		邮箱: <input name="email"><br>
		性别:
		 <select name="gender">
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
		
		部门:
		<select name="departmentId">
			<option  value="1">Name-01</option>
			<option  value="2">Name-02</option>
			<option  value="3">Name-03</option>
			<option  value="4">Name-04</option>
		</select>
		
		<input type="submit" value="提交">
	</div>	
</form>
</body>
</html>