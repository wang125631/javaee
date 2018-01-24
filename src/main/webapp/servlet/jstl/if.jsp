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
<%
	if(10 > 5){
		out.print("true");
	}else{
		out.print("false");
	}
%>

<h1>JSTL</h1>
<c:set var="i" value="10"></c:set>
<c:if test="${i > 5 }">
	true
</c:if>
<c:if test="${i <= 5 }">
	false
</c:if>
</body>
<!--1256317570@qq.com  -->
</html>