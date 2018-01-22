<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户表单页面</title>
<script language="javascript" type="text/javascript" src="../../My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/convertorAction.action" method="post">
	username: <input type="text" id="username" name="username"><s:fielderror fieldName="username.message"/><br>
	password: <input type="text" id="password" name="password"><s:fielderror fieldName="password.message"/><br>
	age: <input type="text" id="age" name="age"><s:fielderror fieldName="age.message"/><br>
	birthday: <input type="text" name="birthday" class="Wdate" onclick="WdatePicker()" readonly="readonly" >
	email: <input type="text" name="email" ><s:fielderror fieldName="email.message"/><br>
	phonenumber: <input type="text" name="phonenumber"><s:fielderror fieldName="phonenumber.message"/>
	
	<input type="submit" value="登录" >
</form>
</body>
</html>