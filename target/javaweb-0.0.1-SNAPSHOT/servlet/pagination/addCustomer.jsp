<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="../../My97DatePicker/WdatePicker.js"></script>
<title>添加客户</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/servletAddCustomer" method="post">		
		客户姓名:<input type="text" name="name"><br>		
		客户性别:<input type="radio" name="gender" value="男" checked="checked">男<input type="radio" name="gender" value="女">女	<br>		
		客户生日:<input type="text" id="b" name="birthday" class="Wdate" onclick="WdatePicker()" readonly="readonly"><br>
		客户电话:<input type="text" name="cellphone"><br>
		客户邮箱:<input type="text" name="email"><br>
		客户爱好:<input type="text" name="preference"><br>
		客户类型:<input type="text" name="type"><br>
		客户备注:<input type="text" name="description"><br>
		<input type="submit" value="添加">

	</form>
	<div align="center">
		<font color="red">${add.message}</font>
	</div>
</body>
<!--1256317570@qq.com  -->

</html>