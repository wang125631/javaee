<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的员工信息</title>
</head>
<body>
	<a href="list.do"> 显示所有员工信息</a>
	<c:if test="${empty requestScope.employees }">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees}">
		<table>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>性别</th>
				<th>部门</th>
				<th>修改</th>
				<th>删除</th>
			<tr>
			<c:forEach items="${requestScope.employees}" var="emp">
			<tr>
				<td>${emp.id} </td>
				<td>${emp.name} </td>
				<td>${emp.email} </td>
				<td>${emp.gender}</td>
				<td>${emp.department.departmentName} </td>
				<td><a href="">修改</a> </td>
				<td><a href="">删除</a> </td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>