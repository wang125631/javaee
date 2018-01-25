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
<h1>使用ognl获取值栈中较为复杂的数据</h1>
<!-- 通过push存储数据获取 -->
<h2>通过push存储数据获取</h2>

<br><hr>
<s:property value="[0].top.studentList"/>

<br><hr>
<s:iterator value="[0].top.studentList" var="student">
	学号:<s:property value="#student.id"/><br>
	姓名:<s:property value="#student.name"/>
</s:iterator>

<br><hr>
<s:iterator value="[0].top.studentList">
	学号:<s:property value="id"/>
	姓名:<s:property value="name"/>
</s:iterator>

<h2>使用set来存储数据</h2>
<s:property value="studentList"/>
<br><hr>
<s:iterator value="studentList" var="student">
	学号:<s:property value="#student.id"/>
	姓名:<s:property value="#student.name"/>
</s:iterator>
<br><hr>
<s:iterator value="studentList">
	学号:<s:property value="id"/>
	姓名:<s:property value="name"/>
</s:iterator>


</body>
<!--1256317570@qq.com  -->
</html>