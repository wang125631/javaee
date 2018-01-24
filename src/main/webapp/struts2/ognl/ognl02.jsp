<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ognl</title>
</head>
<body>

<!-- 获取值栈中name 属性 -->
<s:property value="name"/>
<br><hr>

<!-- 获取栈顶非map集合属性 -->
<s:property value="[1].top"/>
<br><hr>

<!-- 获取ognl中Context属性 -->
<%
	request.setAttribute("rname", "rvalue");
	session.setAttribute("sname", "svalue");
	application.setAttribute("aname", "avalue");
%>

	<s:property value="#request.rname"/><br>
	<s:property value="#session.sname"/><br>
	<s:property value="#application.aname"/>
	
	<s:property value="attr.sname"/>
	<s:property value="parameters.name[0]"/>
	
</body>
<!--1256317570@qq.com  -->
</html>