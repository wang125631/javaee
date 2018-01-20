<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>catch</title>
</head>
<body>

<h1>传统</h1>
<%= "Hello JSTL"%>
<%
	int a= 10;
	request.setAttribute("name", "value");
%>
<%=a %>

<h1>JSTL</h1>
<c:out value="Hello JSTL"></c:out>
<c:out value="${name }"></c:out>

</body>
</html>