<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息展示</title>
</head>
<body>
	${show.Customer}
	<table>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			
			<td>手机</td>
			<td>邮箱</td>
			<td>客户爱好</td>
			<td>客户类型</td>
			
			<td>备注</td>
		</tr>
		<c:forEach var="cs" items="${pageBean.csList}">
		<tr>
			<td>${cs.id} </td>
			<td>${cs.name }</td>
			<td>${cs.gender }</td>
			<td>${cs.birthday }</td>
			
			<td>${cs.cellphone }</td>
			<td>${cs.email }</td>
			<td>${cs.preference }</td>
			<td>${cs.type }</td>
			
			<td>${cs.description }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/servletShowCustomer">首页</a>
	<c:if test="${pageBean.currentPage == 1}">
		上一页&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageBean.currentPage != 1}">
		<a href="${pageContext.request.contextPath}/servletShowCustomer?currentPage=${pageBean.currentPage -1}">上一页</a>&nbsp;&nbsp;&nbsp;
	</c:if>
	
	<c:if test="${pageBean.currentPage == pageBean.totalPage}">
		下一页&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageBean.currentPage != pageBean.totalPage}">
		<a href="${pageContext.request.contextPath}/servletShowCustomer?currentPage=${pageBean.currentPage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
	</c:if>
	
	<a href="${pageContext.request.contextPath}/servletShowCustomer?currentPage=${pageBean.totalPage}">尾页</a>
</body>

</html>